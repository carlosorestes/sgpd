package com.sgpd.br.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sgpd.br.entities.Order;

public class VehicleDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty(value= "id")
	private Long id;
	
	@JsonProperty(value= "tipo")
	private String tipo;
	
	@JsonProperty(value= "ano")
	private Integer ano;
	
	@JsonProperty(value= "modelo")
	private String modelo;
	
	@JsonProperty(value= "cor")
	private String cor;
	
	@JsonProperty(value= "placa")
	private String placa;
	
	@JsonProperty(value= "renavam")
	private String renavam;
	
	@JsonProperty(value= "status")
	private String status;
	
	@JsonProperty(value = "log_external_data")
	private String logExternalData;
	
	private Order order;
	
	private Date dataCriacao;
	
	private Date dataAtualizacao;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLogExternalData() {
		return logExternalData;
	}

	public void setLogExternalData(String logExternalData) {
		this.logExternalData = logExternalData;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		return "VehicleDTO [tipo=" + tipo + ", ano=" + ano + ", modelo=" + modelo + ", cor=" + cor + ", placa=" + placa
				+ ", renavam=" + renavam + "]";
	}
	
}
