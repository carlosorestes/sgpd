package com.sgpd.br.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sgpd.br.enums.TipoVeiculo;

@Entity
@Table(name = "tbVehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_veiculo", nullable = false)
	private TipoVeiculo tipoVeiculo;
	
	@Column(name = "ano", nullable = false)
	private Integer ano;
	
	@Column(name = "modelo", nullable = false)
	private String modelo;
	
	@Column(name = "cor", nullable = false)
	private String cor;
	
	@Column(name = "placa", nullable = false)
	private String placa;
	
	@Column(name = "renavam", nullable = false)
	private String renavam;
	
	@ManyToMany(mappedBy = "listVeiculo")
	@JsonBackReference
	private List<Order> listOrder;
	
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;
	
	@Column(name = "data_atualizacao", nullable = false)
	private Date dataAtualizacao;
	
	public Vehicle() {
		
	}
	
	public Vehicle(Long id, Integer ano, String modelo, String cor, String placa, String renavam,
			TipoVeiculo tipoVeiculo) {
		super();
		this.id = id;
		this.ano = ano;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.renavam = renavam;
		this.tipoVeiculo = tipoVeiculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtuaizacao() {
		return dataAtualizacao;
	}

	public void setDataAtuaizacao(Date dataAtuaizacao) {
		this.dataAtualizacao = dataAtuaizacao;
	}
	
	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}


	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public List<Order> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<Order> listOrder) {
		this.listOrder = listOrder;
	}

	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", ano=" + ano + ", modelo=" + modelo + ", cor=" + cor + ", placa=" + placa
				+ ", renavam=" + renavam + ", tipoVeiculo=" + tipoVeiculo + ", listOrder=" + listOrder.toString() + ", dataCriacao="
				+ dataCriacao + ", dataAtualizacao=" + dataAtualizacao + "]";
	}

}
