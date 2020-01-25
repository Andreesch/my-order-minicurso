package com.app.myorder.entities;

import javax.persistence.*;

@Entity
@Table(name = "ESTABELECIMENTO")
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "TELEFONE", nullable = false)
    private String telefone;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    public Integer getId() {
        return id;
    }

    public Estabelecimento setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Estabelecimento setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Estabelecimento setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Estabelecimento setEmail(String email) {
        this.email = email;
        return this;
    }
}
