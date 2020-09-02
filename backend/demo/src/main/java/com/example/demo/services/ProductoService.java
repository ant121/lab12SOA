package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.demo.models.Producto;
import com.example.demo.repositories.ProductoRepository;

@Service
public class ProductoService implements IProducto{
	
	@Autowired
	private ProductoRepository productoRepo;

	@Override
	public Producto create(Producto p) {
		return productoRepo.save(p);
	}

	@Override
	public Producto update(Producto p) {
		return productoRepo.save(p);
	}

	@Override
	public Producto findById(Integer id) {
		Optional<Producto> productoOpcional = productoRepo.findById(id);
		return productoOpcional.orElse(null);
	}

	@Override
	public List<Producto> findall() {
		return productoRepo.findAll();
	}

	@Override
	public void delete(Integer id) {
		productoRepo.deleteById(id);;
	}

}
