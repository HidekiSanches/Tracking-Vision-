/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hideki.tracking.vision.java;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author hidek
 */
public class FuncionarioService {

    public List<Funcionario> login(String email, String senha) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        return con.query("SELECT * FROM funcionario WHERE email = ? AND senha = ?", new BeanPropertyRowMapper(Funcionario.class), email, senha);
    }

    public Integer retornarFkEmpresa(String email, String senha) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        return con.queryForObject("SELECT fkEmpresa FROM funcionario WHERE email = ? AND senha = ?", Integer.class, email, senha);
    }

}
