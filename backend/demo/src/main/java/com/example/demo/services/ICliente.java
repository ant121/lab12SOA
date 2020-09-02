package com.example.demo.services;

import com.example.demo.models.Cliente;
import java.util.List;

public interface ICliente {
	Cliente create (Cliente c);
	
	Cliente update (Cliente c);
	
	Cliente findById (Integer id);
	
	List<Cliente> findall ();
	
	void delete(Integer id);
}	
