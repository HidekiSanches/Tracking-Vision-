/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hideki.tracking.vision.java;

/**
 *
 * @author hidek
 */
public class Funcionario {

    private Integer idFuncionario;
    private String nome;
    private String email;
    private String cpf;
    private String cargo;
    private String senha;
    private Integer fkEmpresa;

    public Funcionario(Integer idFuncionario, String nome, String email, String cpf, String cargo, String senha, Integer fkEmpresa) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cargo = cargo;
        this.senha = senha;
        this.fkEmpresa = fkEmpresa;
    }

    public Funcionario() {
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    @Override
    public String toString() {
        return String.format("Funcionario:\n id: %d\n Nome: %s\n Email: %s\n CPF: %s\n Cargo: %s\n Senha: *******\n idEmpresa: %d", idFuncionario, nome, email, cpf, cargo, fkEmpresa);
    }

}
