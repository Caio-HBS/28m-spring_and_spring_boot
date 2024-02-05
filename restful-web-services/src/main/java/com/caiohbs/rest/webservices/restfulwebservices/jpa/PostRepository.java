package com.caiohbs.rest.webservices.restfulwebservices.jpa;

import com.caiohbs.rest.webservices.restfulwebservices.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
