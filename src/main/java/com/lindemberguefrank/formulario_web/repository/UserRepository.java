package com.lindemberguefrank.formulario_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lindemberguefrank.formulario_web.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
