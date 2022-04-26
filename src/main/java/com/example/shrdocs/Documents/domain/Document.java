package com.example.shrdocs.Documents.domain;

import com.example.shrdocs.Documents.infrastructure.controller.dto.input.UserInputDTO;
import com.example.shrdocs.User.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="users")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name = "content",length = 250000)
    public String content;
    @Column(name = "title",length = 150)
    public String title;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date createdDate;
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedDate;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "documents_users", joinColumns = @JoinColumn(name = "id_document"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    List<User> usuarios;

}
