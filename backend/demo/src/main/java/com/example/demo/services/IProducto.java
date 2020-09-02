package com.example.demo.services;

import com.example.demo.models.Producto;
import java.util.List;

public interface IProducto {
	Producto create (Producto p);
	
	Producto update (Producto p);
	
	Producto findById (Integer id);
	
	List<Producto> findall ();
	
	void delete(Integer id);
}
