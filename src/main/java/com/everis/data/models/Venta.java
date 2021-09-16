package com.everis.data.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ventas")
public class Venta {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigo;
	private String valor;
	private Integer cantidadProductos;
	private String nombrePersonaCargo; //nombre de la persona a cargo de realizar la venta
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt; 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
//contructores


	public Venta() {
		super();
	}
	
	
	
	

	public Venta(String codigo, String valor, Integer cantidadProductos, String nombrePersonaCargo) {
		super();
		this.codigo = codigo;
		this.valor = valor;
		this.cantidadProductos = cantidadProductos;
		this.nombrePersonaCargo = nombrePersonaCargo;
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getCodigo() {
		return codigo;
	}





	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}





	public String getValor() {
		return valor;
	}





	public void setValor(String valor) {
		this.valor = valor;
	}





	public Integer getCantidadProductos() {
		return cantidadProductos;
	}





	public void setCantidadProductos(Integer cantidadProductos) {
		this.cantidadProductos = cantidadProductos;
	}





	public String getNombrePersonaCargo() {
		return nombrePersonaCargo;
	}





	public void setNombrePersonaCargo(String nombrePersonaCargo) {
		this.nombrePersonaCargo = nombrePersonaCargo;
	}

	
	@PrePersist 
	protected void onCreate(){
	this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	this.updatedAt = new Date();
	}
	
	

}
