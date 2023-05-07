/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hideki.tracking.vision.java;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author hidek
 */
public class Executavel {
   
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConnection();
        Dado dado = new Dado();

        try {
            // Tenta executar uma query em uma tabela existente
            String sql = "SELECT * FROM empresa;";
            con.query(sql, (rs, rowNum) -> null);
        } catch (BadSqlGrammarException e) {
            // Se a tabela não existir, cria uma nova
            if (e.getSQLException().getErrorCode() == 208) {
                String createTableSql = "CREATE TABLE empresa (\n"
                        + "idEmpresa int primary key auto_increment,\n"
                        + "nomeEmpresa varchar(100),\n"
                        + "emailEmpresa varchar(256),\n"
                        + "senha varchar(45),\n"
                        + "cnpj char(14),\n"
                        + "rua varchar(80),\n"
                        + "bairro varchar(80),\n"
                        + "estado varchar(80),\n"
                        + "cep char(8),\n"
                        + "numero int\n"
                        + ");";
                con.execute(createTableSql);
                createTableSql = "CREATE TABLE funcionario (\n"
                        + "idFuncionario int primary key auto_increment,\n"
                        + "nome varchar(60),\n"
                        + "email varchar(256),\n"
                        + "cpf char(11),\n"
                        + "cargo varchar(45),\n"
                        + "senha varchar(45),\n"
                        + "fkEmpresa int,\n"
                        + "foreign key (fkEmpresa) references empresa(idEmpresa)\n"
                        + ");";
                con.execute(createTableSql);
                createTableSql = "CREATE TABLE janelasBloqueadas (\n"
                        + "idJanelasBloqueadas int primary key auto_increment,\n"
                        + "nome varchar(200),\n"
                        + "endereco varchar(100)\n"
                        + ");";
                con.execute(createTableSql);
                createTableSql = "CREATE TABLE rede (\n"
                        + "idRede int primary key auto_increment,\n"
                        + "nomeRede varchar(45),\n"
                        + "nomeExibicao varchar(45),\n"
                        + "ipv4 char(15),\n"
                        + "mac char(17),\n"
                        + "bytesEnviados int,\n"
                        + "bytesRecebidos int\n"
                        + ");";
                con.execute(createTableSql);
                createTableSql = "CREATE TABLE maquina (\n"
                        + "idMaquina int primary key auto_increment,\n"
                        + "status tinyint,\n"
                        + "hostnameMaquina varchar(45),\n"
                        + "nomeModeloCpu varchar(80),\n"
                        + "clockCpu DECIMAL(10,2),\n"
                        + "nomeModeloRam varchar(45),\n"
                        + "capacidadeTotalRam DECIMAL(10,2),\n"
                        + "nomeModeloDisco varchar(100),\n"
                        + "capacidadeTotalDisco DECIMAL (10,2),\n"
                        + "leituraDisco DECIMAL(10,2),\n"
                        + "escritaDisco DECIMAL(10,2),\n"
                        + "fkRede int,\n"
                        + " foreign key (fkRede) references rede(idRede),\n"
                        + "fkEmpresa int,\n"
                        + " foreign key (fkEmpresa) references empresa(idEmpresa),\n"
                        + "fkJanelasBloqueadas int,\n"
                        + " foreign key (fkJanelasBloqueadas) references janelasBloqueadas(idJanelasBloqueadas)\n"
                        + ");";
                con.execute(createTableSql);
                createTableSql = "CREATE TABLE log(\n"
                        + "idLog int primary key auto_increment,\n"
                        + "horarioCapturado datetime default current_timestamp,\n"
                        + "janelaPid int,\n"
                        + "tituloJanela varchar(200),\n"
                        + "usoCpu DECIMAL (10,2),\n"
                        + "usoDisco DECIMAL(10,2),\n"
                        + "usoRam DECIMAL (10,2),\n"
                        + "fkMaquina int,\n"
                        + " foreign key (fkMaquina) references maquina(idMaquina),\n"
                        + "fkLimites int,\n"
                        + " foreign key (fkLimites) references limites(idLimites)\n"
                        + ");";
                con.execute(createTableSql);
                System.out.println("Tabelas criadas com sucesso!");
            } else {
                // Se o erro não for de tabela inexistente, lança a exceção novamente
                throw e;
            }
            String email;
            String senha;
            Scanner leitor = new Scanner(System.in);
            FuncionarioService funcDao = new FuncionarioService();
            API api = new API();

            System.out.println("Digite o seu email:");
            email = leitor.next();
            System.out.println("Digite a sua senha:");
            senha = leitor.next();
            
            if (!funcDao.login(email, senha).isEmpty()) {
                System.out.println("Login realizado!");
                Looca looca = new Looca();
                MaquinaService maquinaService = new MaquinaService();
                RedeService redeDao = new RedeService();
                Rede rede = looca.getRede();

                Double frequenciaCpu = Double.valueOf(api.getProcessador().getFrequencia());
                frequenciaCpu = frequenciaCpu / 1000000000.00;
                Double capRam = Double.valueOf(api.getMemoria().getTotal());
                capRam = capRam / 1073741824.00;
                Double capDisco = Double.valueOf(api.getDisco().get(0).getTamanho());
                capDisco = capDisco / 1073741824.00;
                Double leituraDisco = Double.valueOf(api.getDisco().get(0).getBytesDeLeitura());
                leituraDisco = leituraDisco / 100000000.00;
                Double escritaDisco = Double.valueOf(api.getDisco().get(0).getBytesDeEscritas());
                escritaDisco = escritaDisco / 100000000.00;

                List<Maquina> hostname = maquinaService.buscarPeloHostname(rede.getParametros().getHostName());
                List<RedeInterface> redes = new ArrayList();
                if (hostname.isEmpty()) {
                    for (int i = 0; i < rede.getGrupoDeInterfaces().getInterfaces().size(); i++) {
                        if (!rede.getGrupoDeInterfaces().getInterfaces().get(i).getEnderecoIpv4().isEmpty() && rede.getGrupoDeInterfaces().getInterfaces().get(i).getPacotesRecebidos() > 0 && rede.getGrupoDeInterfaces().getInterfaces().get(i).getPacotesEnviados() > 0) {
                            redes.add(rede.getGrupoDeInterfaces().getInterfaces().get(i));
                        }
                    }
                    Maquina maquina = new Maquina(null, rede.getParametros().getHostName(), 1, api.getProcessador().getNome(), frequenciaCpu, "Memoria", capRam, api.getDisco().get(0).getModelo(), capDisco, leituraDisco, escritaDisco,funcDao.retornarFkEmpresa(email,senha), 1);
                    maquinaService.salvarMaquina(maquina);

                    hostname = maquinaService.buscarPeloHostname(rede.getParametros().getHostName());
                    System.out.println("Hostname do login: " + hostname);
                    Redes redesCadastrar = new Redes(null, redes.get(0).getNome(), redes.get(0).getNomeExibicao(), redes.get(0).getEnderecoIpv4().get(0), redes.get(0).getEnderecoMac(), hostname.get(0).getIdMaquina());
                    redeDao.cadastrarRede(redesCadastrar);
                    dado.capturar();
                } else {
                    System.out.println("Maquina ja cadastrada!");
                    dado.capturar();
                }
        } else {
            System.out.println("Senha ou email invalido ou usuario nao cadastrado via web");
        }

        }
    }
   
}
