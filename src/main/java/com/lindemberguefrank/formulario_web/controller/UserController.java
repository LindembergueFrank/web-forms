package com.lindemberguefrank.formulario_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.lindemberguefrank.formulario_web.DAO.IUser;
import com.lindemberguefrank.formulario_web.model.User;
import com.lindemberguefrank.formulario_web.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/forms")
public class UserController {

    private final UserService userService;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/submit")
    public ResponseEntity<String> submitForm(
            @Valid @ModelAttribute User user,
            @RequestParam("curriculum") MultipartFile file,
            HttpServletRequest request) {

        try {

            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("Arquivo de currículo é obrigatório.");
            }
            if (!file.getOriginalFilename().matches(".*\\.(doc|docx|pdf)$")) {
                return ResponseEntity.badRequest().body("Apenas arquivos .doc, .docx ou .pdf são permitidos.");
            }
            if (file.getSize() > 1_048_576) { 
                return ResponseEntity.badRequest().body("O tamanho do arquivo não pode exceder 1MB.");
            }

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);
            Files.copy(file.getInputStream(), filePath);

            user.setCurriculum(filePath.toString());
            user.setIpAdress(request.getRemoteAddr());
            user.setDataEnvio(LocalDateTime.now());

            userService.saveAndSendEmail(user);
            return ResponseEntity.ok("Formulário enviado com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao processar o formulário: " + e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> listUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}