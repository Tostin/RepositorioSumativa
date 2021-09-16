package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.everis.data.models.Usuario;
import com.everis.data.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	

	private final UsuarioRepository uR;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		
		this.uR = usuarioRepository;
	}
	
	
	public List<Usuario> findAll() {


		return uR.findAll();
	}
	

	public void insertarUsuario(@Valid Usuario usuarito) {
		
		
		System.out.println("Ingresar usuario: " + usuarito.getNombre());
		uR.save(usuarito);
	}

	
	public Usuario buscarUsuario(Long id) {
		Optional<Usuario> oUsuario = uR.findById(id);
		
		if(oUsuario.isPresent()) {
			return oUsuario.get();
		}
		
		
		return null;
	}


	public void modificarUsuario(@Valid Usuario usuarito) {

		uR.save(usuarito);
		
	}


	public void eliminarUsuario(Long id) {

		uR.deleteById(id);
		
	}
	
	
	

}
