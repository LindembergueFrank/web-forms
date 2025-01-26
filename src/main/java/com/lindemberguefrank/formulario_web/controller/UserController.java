package com.lindemberguefrank.formulario_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lindemberguefrank.formulario_web.DAO.IUser;
import com.lindemberguefrank.formulario_web.model.User;

@RestController
@RequestMapping("/forms")
public class UserController {

    @Autowired
    private IUser dao;

    @GetMapping("/users")
    public List<User> listaUsuarios() {
        return (List<User>) dao.findAll();
    }

}
