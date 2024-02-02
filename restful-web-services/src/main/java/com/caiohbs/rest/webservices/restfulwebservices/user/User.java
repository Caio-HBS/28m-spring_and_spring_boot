package com.caiohbs.rest.webservices.restfulwebservices.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


public class User {
    @Positive(message="field 'id' has to be a positive number")
    private Integer id;
    @NotNull(message="field 'name' cannot be null")
    @Size(min=2, max=15, message="field 'name' has to be between 2 and 15 characters")
    private String name;
    @NotNull(message="field 'birthDate' cannot be null")
    @Past(message="field 'birthDate' has to be in the past")
    private LocalDate birthDate;

    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", birthDate=" + birthDate +
               '}';
    }
}
