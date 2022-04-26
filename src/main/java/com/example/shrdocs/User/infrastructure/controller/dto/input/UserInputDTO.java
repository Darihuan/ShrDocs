package com.example.shrdocs.User.infrastructure.controller.dto.input;

import com.example.shrdocs.User.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInputDTO {
    private String username;
    private String email;
    private String password;


    public User UserInputDTO() {
        User user = new User();
        if (this.getUsername() != null) {
            user.setUsername(this.getUsername());
        }
        if (this.getEmail() != null) {
            user.setEmail(this.getEmail());
        }
        if (this.getPassword() != null) {
            user.setPassword(this.getPassword());
        }
        return user;
    }


}
