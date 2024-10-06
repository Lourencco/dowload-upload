package com.example.demo.controller;

import com.example.demo.model.FileMetadata;
import com.example.demo.Repo.FileMetadataRepository;
import com.example.demo.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/files")
public class FileUploadController {

    private final StorageService storageService;
    private final FileMetadataRepository fileMetadataRepository;

    @Autowired
    public FileUploadController(StorageService storageService, FileMetadataRepository fileMetadataRepository) {
        this.storageService = storageService;
        this.fileMetadataRepository = fileMetadataRepository;
    }

    // Upload de arquivo junto com metadados
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam("professor") String professor,
                                   @RequestParam("disciplina") String disciplina,
                                   @RequestParam("classe") String classe) {
        // Gerar um navy nome para o arquivo
        String originalFilename = file.getOriginalFilename();
        String uniqueFilename = System.currentTimeMillis() + "_" + originalFilename; // Adiciona um timestamp ao nome original
        
        // Armazenar o arquivo usando o novo nome
        storageService.store(file, uniqueFilename);
        
        // Criar e salvar os metadados do arquivo no banco de dados
        FileMetadata metadata = new FileMetadata(originalFilename, uniqueFilename, professor, disciplina, classe);
        fileMetadataRepository.save(metadata);
        
        return "File uploaded successfully";
    }


    // Retornar todos os metadados dos arquivos
    @GetMapping("/metadata")
    public List<FileMetadata> listAllFiles() {
        return fileMetadataRepository.findAll();
    }

    // Baixar um arquivo pelo nome
    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
   
}
