package com.example.demo.storage;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;




public interface StorageService {

    void init();  // Para inicializar o diretório de armazenamento

    void store(MultipartFile file, String uniqueFilename);  // Para armazenar o arquivo

    Stream<Path> loadAll();  // Para carregar todos os arquivos

    Path load(String filename);  // Para carregar um arquivo específico

    Resource loadAsResource(String filename);  // Para carregar um arquivo como um recurso

    void deleteAll();  // Para deletar todos os arquivos (opcional)
}