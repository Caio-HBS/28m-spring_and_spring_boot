package com.caiohbs.rest.webservices.restful.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiohbs.rest.webservices.restful.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
