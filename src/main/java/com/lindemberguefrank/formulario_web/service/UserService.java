package com.lindemberguefrank.formulario_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.lindemberguefrank.formulario_web.DAO.IUser;
import com.lindemberguefrank.formulario_web.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUser userRepository;

    @Autowired
    private JavaMailSender mailSender;

    public void saveAndSendEmail(User user) {
        // Salvar usuário no banco
        userRepository.save(user);

        // Enviar e-mail
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Confirmação de envio do formulário");
        message.setText(String.format(
                "Olá %s,\n\nSeu formulário foi recebido com sucesso.\n\nDados enviados:\n- Nome: %s\n- E-mail: %s\n- Telefone: %s\n\nObrigado!",
                user.getFullName(), user.getFullName(), user.getEmail(), user.getPhone()
        ));
        mailSender.send(message);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}