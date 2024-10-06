package com.example.demo.Repo;

import com.example.demo.model.FileMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMetadataRepository extends JpaRepository<FileMetadata, Long> {
    // Podemos adicionar métodos de busca personalizados aqui se necessário
}