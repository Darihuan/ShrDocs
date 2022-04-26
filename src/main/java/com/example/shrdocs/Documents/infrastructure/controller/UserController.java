package com.example.shrdocs.Documents.infrastructure.controller;

import com.example.shrdocs.Documents.application.DocumentService;
import com.example.shrdocs.Documents.domain.Document;
import com.example.shrdocs.Documents.infrastructure.controller.dto.input.LoginDTO;
import com.example.shrdocs.Documents.infrastructure.controller.dto.input.UserInputDTO;
import com.example.shrdocs.Documents.infrastructure.controller.dto.output.UserOutDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v0/eventos")
public class UserController {
    DocumentService udocumentService;

    @Transactional
    @PostMapping()
    public ResponseEntity<UserOutDTO> createUser(UserInputDTO userInputDTO){
        Document usuario = udocumentService.createUser(userInputDTO);
        return ResponseEntity.ok(new UserOutDTO(usuario));
    }

    @Transactional
    @DeleteMapping
    public ResponseEntity<Void> deleteUser(Integer userId){
        udocumentService.deleteUsuario(userId);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PutMapping("{id}")
    public ResponseEntity<UserOutDTO> updateUser(@PathVariable("id") Integer userId, UserInputDTO userInputDTO){
        Document usuario = udocumentService.updateUsuario(userInputDTO, userId);
        return ResponseEntity.ok(new UserOutDTO(usuario));
    }
    @Transactional
    @GetMapping("login")
    public ResponseEntity<Boolean> login(LoginDTO loginDTO){
        return ResponseEntity.ok(udocumentService.authenticate(loginDTO));
    }

}
