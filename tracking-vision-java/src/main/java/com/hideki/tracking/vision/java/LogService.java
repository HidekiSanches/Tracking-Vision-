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
public class LogService {
    
        public Integer retornarIdLog (Log log) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();

        return con.queryForObject("SELECT idLog FROM log WHERE horarioCapturado = ? AND fkMaquina= ? AND janelaPid = ? ", Integer.class, log.getHorarioCapturado(), log.getFkMaquina(), log.getJanelaPid());
      }
    public void salvarLog(Log log) {
        Conexao conexao = new Conexao();

        JdbcTemplate con = conexao.getConnection();
        con.update("INSERT INTO log(horarioCapturado,janelaPid,tituloJanela,usoCpu,usoDisco,usoRam,bytesRecebidos,bytesEnviados,fkMaquina) VALUES (?, ?, ?, ?, ?,?,?,?,?)", log.getHorarioCapturado(), log.getJanelaPid(), log.getTituloJanela(), log.getUsoCpu(), log.getUsoDisco(), log.getUsoRam(),log.getBytesRecebidos(),log.getBytesEnviados(), log.getFkMaquina());
    }
    
}
