package com.example.shrdocs.Documents.infrastructure.controller.dto.output;

import com.example.shrdocs.Documents.domain.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserOutDTO {
  private String username;
  private String email;

  public UserOutDTO(Document user) {
    if (user != null) {
      if (user.getUsername() != null) {
        this.setUsername(user.getUsername());
      }
      if (user.getEmail() != null) {
        this.setEmail(user.getEmail());
      }
    }
  }
}
