package br.edu.sc.senac.demo.demoproject;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cliente")
public class ClienteService<ListClienteDTO> {

	private static final ClienteDTO[] DEFAULT_CLIENTES = new ClienteDTO[] {

			new ClienteDTO(Long.valueOf(0), "marciel", "1983-02-31", "marcielmcs@outlook.com"),
			// Spring instancia "new clienteDTO" faz uso de uma biblioteca(recurso chamado
			// de injecao de depedencia).

			new ClienteDTO(Long.valueOf(0), "sheila mello", "1980-01-02", "mello@Gmail.com"),

			new ClienteDTO(Long.valueOf(0), "He-man", "1970-02-31", "ventania@outllook.com"),

			new ClienteDTO(Long.valueOf(0), "carla vulcao", "2000-10-15", "erupcao@hotmail.com"),

			new ClienteDTO(Long.valueOf(0), "janaina carvalho", "2005-12-09", "jana@outlook.com"),

			new ClienteDTO(Long.valueOf(0), "kayo wanke", "1945-10-04", "wanky@hotmail.com") };

	private final ClienteController clienteController;

	ClienteService(final ClienteController clienteController) {
		this.clienteController = clienteController;
		Arrays.asList(ClienteService.DEFAULT_CLIENTES).forEach(dto -> this.clienteController.insertCliente(dto));

	}

	@GetMapping("/list")
	public List<ClienteDTO> list() {
		return this.clienteController.getAllClientes();

	}

	@GetMapping("/{id}/details")
	public ResponseEntity<ClienteDTO> getCliente(@PathVariable Long id) {
		ClienteDTO cliente = this.clienteController.getAllCliente(id);
		if (ClienteDTO.NULL_VALUE.equals(cliente)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ClienteDTO>(cliente, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteDTO> removeCliente(@PathVariable Long id) {
		ClienteDTO removecliente = this.clienteController.removeCliente(id);
		if (ClienteDTO.NULL_VALUE.equals(removecliente)) {

			return new ResponseEntity<ClienteDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ClienteDTO>(HttpStatus.OK);
	}

	/**
	 * 
	 * @deprecated exemplo didático "@requestParam" é um metodo pouco produtitvo
	 *             para o desenvolvedor, visto que para passar o parametro temos que
	 *             utilizar muitas linhas tornando o codigo dificil de maninular.Por
	 *             padrao usuamos o "@requestBody" efetuando um payload para o
	 *             cadastro e enviamos um json para o banco de dados.
	 * 
	 *
	 */

	@PostMapping("/add")
	public Long addCliente(@RequestParam("id") Long id, @RequestParam("nome") String nome,
			@RequestParam("dataNascimento") String dataNascimento, @RequestParam("email") String email) {
		ClienteDTO cliente = new ClienteDTO(id, nome, dataNascimento, email);
		return this.clienteController.addCliente(cliente);
	}

	@PostMapping("/addpayload")
	public Long addCliente(@RequestBody ClienteDTO cliente) {
		return this.clienteController.addCliente(cliente);

	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO updateCliente) {
		ClienteDTO oldCliente = this.clienteController.updateCliente(id, updateCliente);
		if (ClienteDTO.NULL_VALUE.equals(oldCliente)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

		return new ResponseEntity<>(updateCliente, HttpStatus.OK);
	}

}