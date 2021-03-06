package com.sgpd.br.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tbOrder")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderVehicle> listOrderVehicle;
	
	@Column(name = "data_criacao")
	private Date dataCriacao;
	
	@Column(name = "data_entrada_orgao", nullable = true)
	private Date dataEntradaOrgao;
	
	@Column(name = "data_pronto", nullable = true)
	private Date dataPronto;
	
	@Column(name = "data_entrega", nullable = true)
	private Date dataEntrega;
	
	@Column(name = "data_atualizacao", nullable = false)
	private Date dataAtualizacao;
	
	@Column(name = "recommendation", nullable = false)
	private String recommendation;
	
	@Column(name = "note", nullable = false)
	private String note;
	
	private String status;
	
	public Order() {
	}

	public Order(Long id, Instant moment, User client, Person person, Date dataEntradaOrgao, Date dataPronto, Date dataEntrega, String recommendation, String note, String status) {
		this.id = id;
		this.moment = moment;
		this.user = client;
		this.person = person;
		this.dataEntradaOrgao = dataEntradaOrgao;
		this.dataPronto = dataPronto;
		this.dataEntrega = dataEntrega;
		this.recommendation = recommendation;
		this.note = note;
		this.status = status;
		this.listOrderVehicle = new ArrayList<OrderVehicle>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<OrderVehicle> getListOrderVehicle() {
		return listOrderVehicle;
	}

	public void setListOrderVehicle(List<OrderVehicle> listOrderVehicle) {
		this.listOrderVehicle = listOrderVehicle;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataEntradaOrgao() {
		return dataEntradaOrgao;
	}

	public void setDataEntradaOrgao(Date dataEntradaOrgao) {
		this.dataEntradaOrgao = dataEntradaOrgao;
	}

	public Date getDataPronto() {
		return dataPronto;
	}

	public void setDataPronto(Date dataPronto) {
		this.dataPronto = dataPronto;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", moment=" + moment + ", user=" + user + ", person=" + person
				+ ", listOrderVehicle=" + listOrderVehicle + ", dataCriacao=" + dataCriacao + ", dataEntradaOrgao="
				+ dataEntradaOrgao + ", dataPronto=" + dataPronto + ", dataEntrega=" + dataEntrega
				+ ", dataAtualizacao=" + dataAtualizacao + ", recommendation=" + recommendation + ", note=" + note
				+ ", status=" + status + "]";
	}

}
