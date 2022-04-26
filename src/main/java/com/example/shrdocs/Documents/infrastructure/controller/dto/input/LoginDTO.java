package com.example.shrdocs.Documents.infrastructure.controller.dto.input;

import com.example.shrdocs.Documents.domain.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDTO {
    private String username;
    private String password;
    public Document LoginDTO(){
        Document user = new Document();
        if (this.getPassword() != null) {
            user.setPassword(this.getPassword());
        }
        if (this.getUsername() != null) {
            user.setUsername(this.getUsername());
        }
       return user;
    }
}
