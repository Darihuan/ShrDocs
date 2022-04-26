package com.example.shrdocs.User.infrastructure.controller.dto.input;

import com.example.shrdocs.User.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDTO {
    private String username;
    private String password;
    public User LoginDTO(){
        User user = new User();
        if (this.getPassword() != null) {
            user.setPassword(this.getPassword());
        }
        if (this.getUsername() != null) {
            user.setUsername(this.getUsername());
        }
       return user;
    }
}
