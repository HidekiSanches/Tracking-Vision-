/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hideki.tracking.vision.java;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author hidek
 */
public class RedeService {

    public void cadastrarRede(Redes rede) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        con.update("INSERT INTO placaRede(nomeRede,nomeExibicao,ipv4,mac,fkMaquina) VALUES (?, ?, ?, ?,?)", rede.getNomeRede(), rede.getNomeExibicao(), rede.getIpv4(), rede.getMac(), rede.getFkMaquina());
    }

    public Integer retornarIdRede(Redes rede) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        return con.queryForObject("SELECT idRede FROM placaRede WHERE nomeRede = ? AND nomeExibicao = ? AND ipv4 = ? AND mac = ?", Integer.class, rede.getNomeRede(), rede.getNomeExibicao(), rede.getIpv4(), rede.getMac());
    }

}
