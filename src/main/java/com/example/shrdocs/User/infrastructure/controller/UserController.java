package com.example.shrdocs.User.infrastructure.controller;

import com.example.shrdocs.User.application.Userservice;
import com.example.shrdocs.User.domain.User;
import com.example.shrdocs.User.infrastructure.controller.dto.input.LoginDTO;
import com.example.shrdocs.User.infrastructure.controller.dto.input.UserInputDTO;
import com.example.shrdocs.User.infrastructure.controller.dto.output.UserOutDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v0/eventos")
public class UserController {
    Userservice userservice;

    @Transactional
    @PostMapping()
    public ResponseEntity<UserOutDTO> createUser(UserInputDTO userInputDTO){
        User usuario = userservice.createUser(userInputDTO);
        return ResponseEntity.ok(new UserOutDTO(usuario));
    }

    @Transactional
    @DeleteMapping
    public ResponseEntity<Void> deleteUser(Integer userId){
        userservice.deleteUsuario(userId);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PutMapping("{id}")
    public ResponseEntity<UserOutDTO> updateUser(@PathVariable("id") Integer userId, UserInputDTO userInputDTO){
        User usuario = userservice.updateUsuario(userInputDTO, userId);
        return ResponseEntity.ok(new UserOutDTO(usuario));
    }
    @Transactional
    @GetMapping("login")
    public ResponseEntity<Boolean> login(LoginDTO loginDTO){
        return ResponseEntity.ok(userservice.authenticate(loginDTO));
    }

}
