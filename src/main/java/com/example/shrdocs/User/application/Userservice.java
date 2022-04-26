package com.example.shrdocs.User.application;

import com.example.shrdocs.User.domain.User;
import com.example.shrdocs.User.infrastructure.controller.dto.input.LoginDTO;
import com.example.shrdocs.User.infrastructure.controller.dto.input.UserInputDTO;
import com.example.shrdocs.User.infrastructure.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class Userservice {
  @Autowired private UserRepository userRepository;

  public User createUser(UserInputDTO user) {
    User usuario = new User(user);

    userRepository
        .findByEmail(user.getEmail())
        .orElseThrow(() -> new RuntimeException("Usuario ya existe"));
    userRepository
        .findByUsername(user.getUsername())
        .orElseThrow(() -> new RuntimeException("Usuario ya existe"));

    return userRepository.save(usuario);
  }

  public void deleteUsuario(Integer id) {
    userRepository.deleteById(id);
  }

  public User updateUsuario(UserInputDTO user, Integer id) {
    User usuario = new User(user);
    usuario.setId(id);
    return userRepository.save(usuario);
  }

  public Boolean authenticate(LoginDTO login) {
    User usuario =
        userRepository
            .findByUsername(login.getUsername())
            .orElseThrow((() -> new RuntimeException("Usuario no encontrado")));
    return usuario.getPassword().equals(login.getPassword());
  }
}
