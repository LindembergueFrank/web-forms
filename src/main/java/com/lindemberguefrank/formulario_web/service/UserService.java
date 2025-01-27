package com.lindemberguefrank.formulario_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.lindemberguefrank.formulario_web.model.User;
import com.lindemberguefrank.formulario_web.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /*@Autowired
    private JavaMailSender mailSender;

    public void saveAndSendEmail(User user) {
        userRepository.save(user);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Confirmação de envio do formulário");
        message.setText(String.format(
                "Olá %s,\n\nSeu formulário foi recebido com sucesso.\n\nDados enviados:\n- Nome: %s\n- E-mail: %s\n- Telefone: %s\n\nObrigado!",
                user.getNome(), user.getNome(), user.getEmail(), user.getTelefone()
        ));
        mailSender.send(message);
    }/* */

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}