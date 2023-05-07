/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hideki.tracking.vision.java;

/**
 *
 * @author hidek
 */
public class Maquina {

    private Integer idMaquina;
    private String hostnameMaquina;
    private Integer status;
    private String nomeModeloCpu;
    private Double clockCpu;
    private String nomeModeloRam;
    private Double capacidadeTotalRam;
    private String nomeModeloDisco;
    private Double capacidadeTotalDisco;
    private Double leituraDisco;
    private Double escritaDisco;
    private Integer fkEmpresa;
    private Integer fkJanelasBloqueadas;

    public Maquina(Integer idMaquina, String hostnameMaquina, Integer status, String nomeModeloCpu, Double clockCpu, String nomeModeloRam, Double capacidadeTotalRam, String nomeModeloDisco, Double capacidadeTotalDisco, Double leituraDisco, Double escritaDisco, Integer fkEmpresa, Integer fkJanelasBloqueadas) {
        this.idMaquina = idMaquina;
        this.hostnameMaquina = hostnameMaquina;
        this.status = status;
        this.nomeModeloCpu = nomeModeloCpu;
        this.clockCpu = clockCpu;
        this.nomeModeloRam = nomeModeloRam;
        this.capacidadeTotalRam = capacidadeTotalRam;
        this.nomeModeloDisco = nomeModeloDisco;
        this.capacidadeTotalDisco = capacidadeTotalDisco;
        this.leituraDisco = leituraDisco;
        this.escritaDisco = escritaDisco;
        this.fkEmpresa = fkEmpresa;
        this.fkJanelasBloqueadas = fkJanelasBloqueadas;
    }

    public Maquina() {
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getHostnameMaquina() {
        return hostnameMaquina;
    }

    public void setHostnameMaquina(String hostnameMaquina) {
        this.hostnameMaquina = hostnameMaquina;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNomeModeloCpu() {
        return nomeModeloCpu;
    }

    public void setNomeModeloCpu(String nomeModeloCpu) {
        this.nomeModeloCpu = nomeModeloCpu;
    }

    public Double getClockCpu() {
        return clockCpu;
    }

    public void setClockCpu(Double clockCpu) {
        this.clockCpu = clockCpu;
    }

    public String getNomeModeloRam() {
        return nomeModeloRam;
    }

    public void setNomeModeloRam(String nomeModeloRam) {
        this.nomeModeloRam = nomeModeloRam;
    }

    public Double getCapacidadeTotalRam() {
        return capacidadeTotalRam;
    }

    public void setCapacidadeTotalRam(Double capacidadeTotalRam) {
        this.capacidadeTotalRam = capacidadeTotalRam;
    }

    public String getNomeModeloDisco() {
        return nomeModeloDisco;
    }

    public void setNomeModeloDisco(String nomeModeloDisco) {
        this.nomeModeloDisco = nomeModeloDisco;
    }

    public Double getCapacidadeTotalDisco() {
        return capacidadeTotalDisco;
    }

    public void setCapacidadeTotalDisco(Double capacidadeTotalDisco) {
        this.capacidadeTotalDisco = capacidadeTotalDisco;
    }

    public Double getLeituraDisco() {
        return leituraDisco;
    }

    public void setLeituraDisco(Double leituraDisco) {
        this.leituraDisco = leituraDisco;
    }

    public Double getEscritaDisco() {
        return escritaDisco;
    }

    public void setEscritaDisco(Double escritaDisco) {
        this.escritaDisco = escritaDisco;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public Integer getFkJanelasBloqueadas() {
        return fkJanelasBloqueadas;
    }

    public void setFkJanelasBloqueadas(Integer fkJanelasBloqueadas) {
        this.fkJanelasBloqueadas = fkJanelasBloqueadas;
    }

    @Override
    public String toString() {
        return String.format("Informações da maquina:\n id: %d\n Host Name: %s\n Status: %d\n Modelo CPU: %s\n Clock CPU: %.2f\n Modelo RAM: %s\n Capacidade total RAM: %.2f\n Capacidade total disco: %.2f\n Leitura disco: %.2f\n Escrita disco: %.2f\n idEmpresa: %d\n idJanela: %d", idMaquina, hostnameMaquina, status, nomeModeloCpu, clockCpu, capacidadeTotalRam, capacidadeTotalDisco, escritaDisco, fkEmpresa, fkJanelasBloqueadas);
    }

}
