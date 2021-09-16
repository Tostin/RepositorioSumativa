package com.everis.data.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Usuario;
import com.everis.data.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService uS;
	
	@RequestMapping("")
	public String index(@ModelAttribute("usuario") Usuario usuarito, Model model) {
		
		List<Usuario> lista_usuarios = uS.findAll();
		model.addAttribute("lista_usuarios", lista_usuarios);
		
		System.out.println("Works usuario");
		
		return "usuario.jsp";
	}
	
	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("usuario") Usuario usuarito) {
		System.out.println("crear "+ usuarito);
	
		//    validacion      //
		
		
		
		//	   validacion      //
		
		uS.insertarUsuario(usuarito);
		
		return "redirect:/usuario";
		
	}
	
	@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id,Model model) {
		
		System.out.println("actualizar id: "+ id);
		
		Usuario usuarito = uS.buscarUsuario(id);
		model.addAttribute("usuario",usuarito);
		
		return "editar_usuario.jsp";
		}
	
	
	@RequestMapping(value="/modificar", method = RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("usuario") Usuario usuarito) {
		
		
		
		
		//    validacion      //
		
		
		
		//	  validacion      //		
		
		
		uS.modificarUsuario(usuarito);
		
		return "redirect:/usuario";
	}
	
	@RequestMapping(value="/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id) {
		
	System.out.println("Eliminar id de usuario: "+ id);
	
	uS.eliminarUsuario(id);
	return "redirect:/usuario";
	}
	
	

}
