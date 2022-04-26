package com.example.shrdocs.Documents.application;

import com.example.shrdocs.Documents.domain.Document;
import com.example.shrdocs.Documents.infrastructure.controller.dto.input.LoginDTO;
import com.example.shrdocs.Documents.infrastructure.controller.dto.input.UserInputDTO;
import com.example.shrdocs.Documents.infrastructure.repository.DocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DocumentService {
  @Autowired private DocumentRepository documentRepository;

  public Document createUser(UserInputDTO user) {
    Document usuario = new Document(user);

    documentRepository
        .findByEmail(user.getEmail())
        .orElseThrow(() -> new RuntimeException("Usuario ya existe"));
    documentRepository
        .findByUsername(user.getUsername())
        .orElseThrow(() -> new RuntimeException("Usuario ya existe"));

    return documentRepository.save(usuario);
  }

  public void deleteUsuario(Integer id) {
    documentRepository.deleteById(id);
  }

  public Document updateUsuario(UserInputDTO user, Integer id) {
    Document usuario = new Document(user);
    usuario.setId(id);
    return documentRepository.save(usuario);
  }

  public Boolean authenticate(LoginDTO login) {
    Document usuario =
        documentRepository
            .findByUsername(login.getUsername())
            .orElseThrow((() -> new RuntimeException("Usuario no encontrado")));
    return usuario.getPassword().equals(login.getPassword());
  }
}
