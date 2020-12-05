package com.sgpd.br.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sgpd.br.entities.Order;
import com.sgpd.br.entities.Person;
import com.sgpd.br.entities.User;
import com.sgpd.br.entities.Vehicle;

public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value= "id")
	private Long id;
	
	@JsonProperty(value= "cpf")
	private String cpfPerson;
	
	@JsonProperty(value= "despachante")
	private String userNome;
	
	@JsonProperty(value= "dtEntrada")
	private Date dtEntrada;
	
	@JsonProperty(value= "dtEntradaOrg")
	private Date dtEntradaOrgao;
	
	@JsonProperty(value= "dtEntrega")
	private Date dtEntrega;
	
	@JsonProperty(value= "dtPronto")
	private Date dtPronto;
	
	@JsonProperty(value= "indicacao")
	private String indicacao;
	
	@JsonProperty(value= "nome")
	private String personNome;
	
	@JsonProperty(value= "obs")
	private String obs;
	
	@JsonProperty(value = "vehicles")
	private List<VehicleDTO> listVehicles;
	
	public OrderDTO() {
	}

	public OrderDTO(String cpfPerson, String userNome, Date dtEntrada, Date dtEntradaOrgao, Date dtEntrega,
			Date dtPronto, String indicacao, String personNome, String obs, List<VehicleDTO> vehiclesDTO) {
		super();
		this.cpfPerson = cpfPerson;
		this.userNome = userNome;
		this.dtEntrada = dtEntrada;
		this.dtEntradaOrgao = dtEntradaOrgao;
		this.dtEntrega = dtEntrega;
		this.dtPronto = dtPronto;
		this.indicacao = indicacao;
		this.personNome = personNome;
		this.obs = obs;
		this.listVehicles = vehiclesDTO;
	}

	public Order buildOrder(User user, Person person) {
		Order order = new Order();
		order.setId(id);
		order.setDataEntradaOrgao(dtEntradaOrgao);
		order.setDataEntrega(dtEntrega);
		order.setDataPronto(dtPronto);
		order.setRecommendation(indicacao);
		order.setNote(obs);
		order.setUser(user);
		order.setPerson(person);
		return order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpfPerson() {
		return cpfPerson;
	}

	public void setCpfPerson(String cpfPerson) {
		this.cpfPerson = cpfPerson;
	}

	public String getUserNome() {
		return userNome;
	}

	public void setUserNome(String userNome) {
		this.userNome = userNome;
	}

	public Date getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public Date getDtEntradaOrgao() {
		return dtEntradaOrgao;
	}

	public void setDtEntradaOrgao(Date dtEntradaOrgao) {
		this.dtEntradaOrgao = dtEntradaOrgao;
	}

	public Date getDtEntrega() {
		return dtEntrega;
	}

	public void setDtEntrega(Date dtEntrega) {
		this.dtEntrega = dtEntrega;
	}

	public Date getDtPronto() {
		return dtPronto;
	}

	public void setDtPronto(Date dtPronto) {
		this.dtPronto = dtPronto;
	}

	public String getIndicacao() {
		return indicacao;
	}

	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
	}

	public String getNome() {
		return personNome;
	}

	public void setNome(String nome) {
		this.personNome = nome;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public List<VehicleDTO> getListVehicles() {
		return listVehicles;
	}

	public void setListVehicles(List<VehicleDTO> vehiclesDTO) {
		this.listVehicles = vehiclesDTO;
	}

	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", cpfPerson=" + cpfPerson + ", userNome=" + userNome + ", dtEntrada=" + dtEntrada
				+ ", dtEntradaOrgao=" + dtEntradaOrgao + ", dtEntrega=" + dtEntrega + ", dtPronto=" + dtPronto
				+ ", indicacao=" + indicacao + ", personNome=" + personNome + ", obs=" + obs + ", listVehicles="
				+ listVehicles + "]";
	}
}
