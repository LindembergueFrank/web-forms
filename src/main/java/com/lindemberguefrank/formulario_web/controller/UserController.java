package com.lindemberguefrank.formulario_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.lindemberguefrank.formulario_web.model.User;
import com.lindemberguefrank.formulario_web.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/forms")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("desiredPosition") String desiredPosition,
            @RequestParam("education") String education,
            @RequestParam(value = "observations", required = false) String observations,
            @RequestParam("resume") MultipartFile resume,
            HttpServletRequest request
    ) throws IOException {
        
        User user = new User();
        user.setNome(name);
        user.setEmail(email);
        user.setTelefone(phoneNumber);
        user.setCargoDesejado(desiredPosition);
        user.setEscolaridade(education);
        user.setObservacoes(observations);
        user.setCurriculum(resume.getBytes());  
        
        String ipString = request.getRemoteAddr();
        user.setIpAdress(ipString); 
        
        user.setDataEnvio(LocalDateTime.now()); 

        System.out.println("Received IP: " + ipString);
        System.out.println("Received Name: " + name);
        System.out.println("Received Email: " + email);
        System.out.println("Received Phone: " + phoneNumber);
        System.out.println("Received Position: " + desiredPosition);
        System.out.println("Received Education: " + education);
        System.out.println("Received Observations: " + observations);


        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
