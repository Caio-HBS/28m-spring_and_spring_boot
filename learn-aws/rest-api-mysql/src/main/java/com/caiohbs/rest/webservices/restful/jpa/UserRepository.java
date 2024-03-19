package com.caiohbs.rest.webservices.restful.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiohbs.rest.webservices.restful.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
