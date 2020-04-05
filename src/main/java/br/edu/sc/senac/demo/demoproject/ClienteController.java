package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
public class ClienteController {

	 private List<ClienteDTO> clientes = new ArrayList<>();

	Long insertCliente(ClienteDTO cliente) {

		clientes.add(cliente);
		Long id = Long.valueOf(clientes.size() - 1);
		return id;
	}

	ClienteDTO getAllCliente(Long id) {

		if (id >= clientes.size() || id < 0) {

			return ClienteDTO.NULL_VALUE;

		}
		int index = id.intValue();
		ClienteDTO cliente = clientes.get(index);
		return cliente;

	}

	List<ClienteDTO> getAllClientes() {
		return clientes;
	}

}
