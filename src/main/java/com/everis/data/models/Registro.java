package com.everis.data.models;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;




@Entity //representacion de entidad modelo
@Table(name="registros")
public class Registro {


//id
	@Id //clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto incrementar
	private Long id;
	private String rut;
	private String nombre;
	private String apellido;
	private Integer edad;
	private String email;
	private String password; //Para el login
	
  @Column(updatable=false)
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date createdAt;
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date updatedAt;
	
  
 
  
  
	
	public Registro() {
		super();
	}

	public Registro(String rut, String nombre, String apellido, Integer edad, String email, String password) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRut() {
		return rut;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String cargo) {
		this.password = password;
	} 
	
	

	
  @PrePersist//se ejecuta antes de que sea insertado
  protected void onCreate(){
      this.createdAt = new Date();
  }
  @PreUpdate // se ejecuta antes de que sea actualizado
  protected void onUpdate(){
      this.updatedAt = new Date();
  } 
}