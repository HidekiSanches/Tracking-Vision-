/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hideki.tracking.vision.java;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.janelas.Janela;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.util.List;

/**
 *
 * @author hidek
 */
public class API {

    private Sistema sistema;
    private Memoria memoria;
    private List<Disco> disco;
    private Processador processador;
    private List<RedeInterface> redeInterface;
    private List<Janela> janela;
    private List<Disco> hardware;
    private ProcessoGrupo processo;

    public API() {
        Looca looca = new Looca();
        this.sistema = looca.getSistema();
        this.memoria = looca.getMemoria();
        this.disco = looca.getGrupoDeDiscos().getDiscos();
        this.processador = looca.getProcessador();
        this.redeInterface = looca.getRede().getGrupoDeInterfaces().getInterfaces();
        this.janela = looca.getGrupoDeJanelas().getJanelas();
        this.hardware = looca.getGrupoDeDiscos().getDiscos();
        this.processo = looca.getGrupoDeProcessos();
    }

    public List<Disco> getHardware() {
        return hardware;
    }

    public ProcessoGrupo getProcesso() {
        return processo;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public Memoria getMemoria() {
        return memoria;
    }

    public List<Disco> getDisco() {
        return disco;
    }

    public Processador getProcessador() {
        return processador;
    }

    public List<Janela> getJanela() {
        return janela;
    }

    public List<RedeInterface> getRedeInterface() {
        return redeInterface;
    }

    public Long getMemoriaEmUso() {
        return memoria.getEmUso();
    }

    public Long getBystesDeLeitura() {
        for (Disco discos : this.disco) {
            return discos.getBytesDeLeitura();
        }
        return null;
    }

    public Long getBytesDeEscrita() {
        for (Disco discos : this.disco) {
            return discos.getBytesDeEscritas();
        }
        return null;
    }

    public Long getLeitura() {
        for (Disco discos : this.disco) {
            return discos.getLeituras();
        }
        return null;
    }

    public Long getEscrita() {
        for (Disco discos : this.disco) {
            return discos.getEscritas();
        }
        return null;
    }

    public Double getProcessadorEmUso() {
        return processador.getUso();
    }

    public Long getBytesEnviados() {
        for (RedeInterface redeInterface : this.redeInterface) {
            return redeInterface.getBytesEnviados();
        }
        return null;
    }

    public Long getBytesRecebidos() {
        for (RedeInterface redeInterface : this.redeInterface) {
            return redeInterface.getBytesRecebidos();
        }
        return null;
    }

    public Long getPacotesEnviados() {
        for (RedeInterface redeInterface : this.redeInterface) {
            return redeInterface.getPacotesEnviados();
        }
        return null;
    }

    public Long getPacotesRecebidos() {
        for (RedeInterface redeInterface : this.redeInterface) {
            return redeInterface.getPacotesRecebidos();
        }
        return null;
    }

    public Long getJanelaId() {
        for (Janela janelas : this.janela) {
            return janelas.getJanelaId();
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("Dados capturados pela API:\n Sistema: %s\n Memória: %s\n Disco: %s\n Processador: %s\n Janela: %s\n Processo: %s", sistema, memoria, disco, processador, janela, processo);
    }

}
