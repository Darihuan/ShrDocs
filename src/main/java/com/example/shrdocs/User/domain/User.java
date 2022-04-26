package com.example.shrdocs.User.domain;

import com.example.shrdocs.User.infrastructure.controller.dto.input.UserInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name="username")
    public String username;
    @Column(name="password")
    public String password;
    @Column(name="email")
    public String email;

    public User(UserInputDTO userInputDTO) {
        if(userInputDTO.getUsername()!= null) {
            this.username = userInputDTO.getUsername();
        }
        if(userInputDTO.getPassword()!= null) {
            this.password = userInputDTO.getPassword();
        }
        if(userInputDTO.getEmail()!= null) {
            this.email = userInputDTO.getEmail();
        }

    }
}
