package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.demo.models.Cliente;
import com.example.demo.repositories.ClienteRepository;

@Service
public class ClienteService implements ICliente{
	
	@Autowired
	private ClienteRepository clienteRepo;

	@Override
	public Cliente create(Cliente c) {
		return clienteRepo.save(c);
	}

	@Override
	public Cliente update(Cliente c) {
		return clienteRepo.save(c);
	}

	@Override
	public Cliente findById(Integer id) {
		Optional<Cliente> clienteOpcional = clienteRepo.findById(id);	
		return clienteOpcional.orElse(null);
	}

	@Override
	public List<Cliente> findall() {
		return clienteRepo.findAll();
	}

	@Override
	public void delete(Integer id) {
		clienteRepo.deleteById(id);
		
	}
	
}
