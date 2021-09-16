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
@Table(name= "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String rut;
	private String nombre;
	private String apellido;
	private String email;
	private String username;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt; 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
//Contructores
	
	
	public Usuario() {
		super();
	} 
	
	
	public Usuario(String rut, String nombre, String apellido, String email, String username) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.username = username;
	}

//Getter y setters
	
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRut() {
		return rut;
	}


	public void setRut(String rut) {
		this.rut = rut;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}




	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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
