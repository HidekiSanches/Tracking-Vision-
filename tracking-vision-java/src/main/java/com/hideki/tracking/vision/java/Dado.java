/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hideki.tracking.vision.java;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.janelas.JanelaGrupo;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.hideki.tracking.vision.java.API;
import com.hideki.tracking.vision.java.Log;
import com.hideki.tracking.vision.java.LogService;
import com.hideki.tracking.vision.java.Maquina;
import com.hideki.tracking.vision.java.MaquinaService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import java.io.IOException;

/**
 *
 * @author hidek
 */
public class Dado {

    public void capturar() {

        LogService logService = new LogService();
        MaquinaService maquinaService = new MaquinaService();
        API api = new API();
        Looca looca = new Looca();
        Rede rede = looca.getRede();
        JanelaGrupo janelaGrupo = looca.getGrupoDeJanelas();
        DiscoGrupo disco = looca.getGrupoDeDiscos();
        List<Maquina> hostname = maquinaService.buscarPeloHostname(rede.getParametros().getHostName());

        Double usoDisco = Double.valueOf(api.getDisco().get(0).getTamanho() - disco.getVolumes().get(0).getDisponivel());
        usoDisco = usoDisco / 1073741824.00;
        Double usoRam = Double.valueOf(api.getMemoriaEmUso());
        usoRam = usoRam / 1073741824.00;

        Double finalUsoDisco = usoDisco;
        Double finalUsoRam = usoRam;
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());

                System.out.println("=========================================================");
                System.out.println(String.format("Processador: %.2f %%", api.getProcessadorEmUso()));
                System.out.println(String.format("Disco: %.2f GB", finalUsoDisco));
                System.out.println("Horário: " + timeStamp);
                System.out.println(String.format("Ram: %.2f GB", finalUsoRam));
                System.out.println("=========================================================");
            }
        }, 0, 5000);
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Dentro do timertask");
                List<String> janelas = new ArrayList();
                List<Long> janelasPid = new ArrayList();
                for (int i = 0; i < janelaGrupo.getTotalJanelasVisiveis(); i++) {
                    if (janelaGrupo.getJanelasVisiveis().get(i).getTitulo().length() > 0) {
                        janelas.add(janelaGrupo.getJanelasVisiveis().get(i).getTitulo());
                        janelasPid.add(janelaGrupo.getJanelasVisiveis().get(i).getPid());
                    }
                }
                System.out.println("=========================================================");
                List<RedeInterface> redes = new ArrayList();

                for (int i = 0; i < rede.getGrupoDeInterfaces().getInterfaces().size(); i++) {
                    if (!rede.getGrupoDeInterfaces().getInterfaces().get(i).getEnderecoIpv4().isEmpty() && rede.getGrupoDeInterfaces().getInterfaces().get(i).getPacotesRecebidos() > 0 && rede.getGrupoDeInterfaces().getInterfaces().get(i).getPacotesEnviados() > 0) {
                        redes.add(rede.getGrupoDeInterfaces().getInterfaces().get(i));
                    }
                }

                for (int j = 0; j < janelas.size(); j++) {
                    String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    Log log = new Log(null, timeStamp, janelasPid.get(j), janelas.get(j), api.getProcessador().getUso(), finalUsoDisco, finalUsoRam, (redes.get(0).getBytesRecebidos() * 8) / 1000000, (redes.get(0).getBytesEnviados() * 8) / 1000000, hostname.get(0).getIdMaquina());

                    System.out.println(log.toString());
                    logService.salvarLog(log);
                    System.out.println(janelas.get(j));
                }
                System.out.println("=========================================================");
            }
        }, 0, 60000);

    }

}
