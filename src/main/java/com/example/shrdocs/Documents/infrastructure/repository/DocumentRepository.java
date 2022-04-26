package com.example.shrdocs.Documents.infrastructure.repository;

import com.example.shrdocs.Documents.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
}
