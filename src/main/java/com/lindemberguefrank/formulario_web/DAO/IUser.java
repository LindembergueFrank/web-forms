package com.lindemberguefrank.formulario_web.DAO;

import org.springframework.data.repository.CrudRepository;

import com.lindemberguefrank.formulario_web.model.User;

public interface IUser extends CrudRepository<User, Long>{

}
