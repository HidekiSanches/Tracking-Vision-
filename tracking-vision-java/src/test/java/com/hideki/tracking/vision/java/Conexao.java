/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hideki.tracking.vision.java;

import java.io.IOException;
import java.net.InetAddress;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author hidek
 */
public class Conexao {

    private JdbcTemplate connection;

    public Conexao() {
        try {
            InetAddress.getByName("www.google.com").isReachable(5000);
            System.out.println("Conexão com a Internet verificada.");
            // criar conexão com o banco de dados da Azure
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dataSource.setUrl("jdbc:sqlserver://servidor-tracking-vision.database.windows.net:1433;database=bd-tracking-vision;user=admin-tracking-vision@servidor-tracking-vision;password=#Gfgrupo5;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
            dataSource.setUsername("admin-tracking-vision");
            dataSource.setPassword("#Gfgrupo5");
            this.connection = new JdbcTemplate(dataSource);
        } catch (IOException e) {
            System.out.println("Erro: Sem conexão com a Internet.");
            System.out.println("Tentando conectar ao banco de dados local...");
            // criar conexão com o banco de dados local
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/Track");
            dataSource.setUsername("root");
            dataSource.setPassword("urubu100");
            this.connection = new JdbcTemplate(dataSource);
        }
    }

    public JdbcTemplate getConnection() {
        return connection;
    }
}
