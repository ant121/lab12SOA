package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Producto;
import com.example.demo.services.ProductoService;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoservice;

	@GetMapping
	public List<Producto> findAll(){
		return productoservice.findall();
	}
	
	@PostMapping
	public Producto create ( @RequestBody Producto p) {
		return productoservice.create(p);
	}
	
	
		
	@GetMapping("/{id}")
	public  Producto findById (@PathVariable("id") Integer id) {
		return productoservice.findById(id);
	}
	
	
	@PutMapping ("/{id}")
	public Producto update ( @RequestBody Producto p, @PathVariable("id") Integer id) {
		p.setIdProducto(id);
		return productoservice.update(p);
	}
	
	
	
	@DeleteMapping ("/{IdProducto}")
	public void delete (@PathVariable("IdProducto") Integer IdProducto) {
		productoservice.delete(IdProducto);
	}

}
