package com.example.shrdocs.User.infrastructure.controller.dto.output;

import com.example.shrdocs.User.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserOutDTO {
  private String username;
  private String email;

  public UserOutDTO(User user) {
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
