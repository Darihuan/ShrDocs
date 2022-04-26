package com.example.shrdocs.Documents.infrastructure.controller.dto.input;

import com.example.shrdocs.Documents.domain.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInputDTO {
    private String username;
    private String email;
    private String password;


    public Document UserInputDTO() {
        Document user = new Document();
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
