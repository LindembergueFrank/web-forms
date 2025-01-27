package com.lindemberguefrank.formulario_web.model;

import java.time.LocalDateTime;
import javax.validation.constraints.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "form")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 255, nullable = true)
    @NotBlank(message = "O nome completo é obrigatório.")
    private String nome;
    
    @Column(name = "email", length = 50, nullable = true)
    @Email(message = "E-mail inválido.")
    private String email;

    @Column(name = "phone_number", length = 20, nullable = true)
    @NotBlank(message = "O telefone é obrigatório.")
    private String telefone;

    @Column(name = "desired_position", length = 100, nullable = true)
    @NotBlank(message = "A posição desejada é obrigatória.")
    private String cargoDesejado;

    @Column(name = "education", length = 50, nullable = true)
    @NotBlank(message = "A escolaridade é obrigatória.")
    private String escolaridade;

    @Column(name = "observations", columnDefinition = "TEXT")
    private String observacoes;

    @Column(name = "resume", nullable = true)
    private String curriculum;

    @Column(name = "ip_address", nullable = true)
    private String ipAdress;

    @Column(name = "date", nullable = true)
    private LocalDateTime dataEnvio;



}
