/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hideki.tracking.vision.java;

/**
 *
 * @author hidek
 */
public class Log {

    private Integer idLog;
    private String horarioCapturado;
    private Long janelaPid;
    private String tituloJanela;
    private Double usoCpu;
    private Double usoDisco;
    private Double usoRam;
    private Long bytesRecebidos;
    private Long bytesEnviados;
    private Integer fkMaquina;

    public Log(Integer idLog, String horarioCapturado, Long janelaPid, String tituloJanela, Double usoCpu, Double usoDisco, Double usoRam, Long bytesRecebidos, Long bytesEnviados, Integer fkMaquina) {
        this.idLog = idLog;
        this.horarioCapturado = horarioCapturado;
        this.janelaPid = janelaPid;
        this.tituloJanela = tituloJanela;
        this.usoCpu = usoCpu;
        this.usoDisco = usoDisco;
        this.usoRam = usoRam;
        this.bytesRecebidos = bytesRecebidos;
        this.bytesEnviados = bytesEnviados;
        this.fkMaquina = fkMaquina;
    }

    public Log() {
    }

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public String getHorarioCapturado() {
        return horarioCapturado;
    }

    public void setHorarioCapturado(String horarioCapturado) {
        this.horarioCapturado = horarioCapturado;
    }

    public Long getJanelaPid() {
        return janelaPid;
    }

    public void setJanelaPid(Long janelaPid) {
        this.janelaPid = janelaPid;
    }

    public String getTituloJanela() {
        return tituloJanela;
    }

    public void setTituloJanela(String tituloJanela) {
        this.tituloJanela = tituloJanela;
    }

    public Double getUsoCpu() {
        return usoCpu;
    }

    public void setUsoCpu(Double usoCpu) {
        this.usoCpu = usoCpu;
    }

    public Double getUsoDisco() {
        return usoDisco;
    }

    public void setUsoDisco(Double usoDisco) {
        this.usoDisco = usoDisco;
    }

    public Double getUsoRam() {
        return usoRam;
    }

    public void setUsoRam(Double usoRam) {
        this.usoRam = usoRam;
    }

    public Long getBytesRecebidos() {
        return bytesRecebidos;
    }

    public void setBytesRecebidos(Long bytesRecebidos) {
        this.bytesRecebidos = bytesRecebidos;
    }

    public Long getBytesEnviados() {
        return bytesEnviados;
    }

    public void setBytesEnviados(Long bytesEnviados) {
        this.bytesEnviados = bytesEnviados;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    @Override
    public String toString() {
        return String.format("Dados coeltados:\n id: %d\n Horario da captura: %s\n PID Janela: %d\n Titulo da janela: %s\n CPU em uso: %.2f\n Disco em uso: %.2f\n RAM em uso: %.2f\n Bytes recebidos: %d\n Bytes enviados: %d\n idMaquina: %d", idLog, horarioCapturado, janelaPid, tituloJanela, usoCpu, usoDisco, usoRam, bytesRecebidos, bytesEnviados, fkMaquina);
    }
    
}
