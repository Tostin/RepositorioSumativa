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

import com.everis.data.models.Producto;
import com.everis.data.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService pS;
	
	
	@RequestMapping("")
	public String index(@ModelAttribute("producto") Producto productito, Model model) {
		
		List<Producto> lista_productos = pS.findAllProductos();
		model.addAttribute("lista_productos", lista_productos);
		
		
		System.out.println("Works producto");
		return "producto.jsp";
	}
	
	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("producto") Producto productito) {
		System.out.println("crear "+ productito);
	
		//    validacion      //
		
		
		
		//	   validacion      //
		
		pS.insertarProducto(productito);
		
		return "redirect:/producto";
		
	}
	
	@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id,Model model) {
		
		System.out.println("actualizar id: "+ id);
		
		Producto productito = pS.buscarproductito(id);
		model.addAttribute("producto",productito);
		
		return "editar_producto.jsp";
		}
	
	
	@RequestMapping(value="/modificar", method = RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("producto") Producto productito) {
		
		
		
		
		//    validacion      //
		
		
		
		//	  validacion      //		
		
		
		pS.modificarProducto(productito);
		
		return "redirect:/producto";
	}
	
	@RequestMapping(value="/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id) {
		
	System.out.println("Eliminar id de producto: "+ id);
	
	pS.eliminarProducto(id);
	return "redirect:/producto";
	}
	
	
	
	
}
