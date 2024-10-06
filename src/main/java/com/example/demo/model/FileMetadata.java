package com.example.demo.model;

import java.time.Year;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FileMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalFilename; // Nome original do arquivo
    private String uniqueFilename; // Nome gerado para o armazenamento
    private String filename;
    private String professor;
    private String disciplina;
    private String classe;
    private Year ano;

    // Construtores, getters e setters

    public FileMetadata() {}

    public FileMetadata(String originalFilename, String uniqueFilename, String professor, String disciplina, String classe) {
        this.setOriginalFilename(originalFilename);
        this.setUniqueFilename(uniqueFilename);
        this.professor = professor;
        this.disciplina = disciplina;
        this.classe = classe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public String getUniqueFilename() {
		return uniqueFilename;
	}

	public void setUniqueFilename(String uniqueFilename) {
		this.uniqueFilename = uniqueFilename;
	}

	public Year getAno() {
		return ano;
	}

	public void setAno(Year ano) {
		this.ano = ano;
	}
}
