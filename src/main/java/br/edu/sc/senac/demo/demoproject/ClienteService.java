package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
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
public class ClienteService {

	private List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();

	@PostMapping("/add-Default")
	public void addDefault() {

		ClienteDTO cliente = new ClienteDTO("marciel", "1983-02-31", "marcielmcs@outlook.com");
		clientes.add(cliente);

		cliente = new ClienteDTO("sheila mello", "1980-01-02", "mello@Gmail.com");
		clientes.add(cliente);

		cliente = new ClienteDTO("He-man", "1970-02-31", "ventania@outllook.com");
		clientes.add(cliente);

		cliente = new ClienteDTO("carla vulcao", "2000-10-15", "erupcao@hotmail.com");
		clientes.add(cliente);

		cliente = new ClienteDTO("janaina carvalho", "2005-12-09", "jana@outlook.com");
		clientes.add(cliente);

		cliente = new ClienteDTO("kayo wanke", "1945-10-04", "wanky@hotmail.com");
		clientes.add(cliente);

	}

	@GetMapping("/list")
	public List<ClienteDTO> list() {
		return clientes;

	}

	@GetMapping("/{id}/details")
	public ResponseEntity<ClienteDTO> getCliente(@PathVariable Long id) {

		if (id >= clientes.size() || id < 0) {

			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		int index = id.intValue();
		ClienteDTO cliente = clientes.get(index);

		return new ResponseEntity<ClienteDTO>(cliente, HttpStatus.OK); // "cliente" é o objeto transformado em json
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteDTO> removeCliente(@PathVariable Long id) {

		if (id >= clientes.size() || id < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		int index = id.intValue();
		ClienteDTO cliente = clientes.remove(index);

		return new ResponseEntity<>(cliente, HttpStatus.OK);

	}
	/**
	 * @deprecated exemplo didático "@requestParam" é um metodo pouco produtitvo para o
	 *             desenvolvedor, visto que para passar o parametro temos que
	 *             utilizar muitas linhas tornando o codigo dificil de maninular.Por padrao usuamos o "@requestBody"  
	 *             efetuando um payload para o cadastro e enviamos um json para o banco de dados.
	 * 			
	 *
	 */
	
	@PostMapping("/add")
	public Long addCliente(@RequestParam("nome") String nome, @RequestParam("dataNascimento") String dataNascimento,
			@RequestParam("email") String email) {
		ClienteDTO cliente = new ClienteDTO(nome, dataNascimento, email);
		clientes.add(cliente);
		Long id = Long.valueOf(clientes.size() - 1);
		return id;

	}

	@PostMapping("/addpayload")
	public Long addCliente(@RequestBody ClienteDTO cliente) {

		clientes.add(cliente);
		Long id = Long.valueOf(clientes.size() - 1);
		return id;
	}

	@PutMapping("/{id}")
	public  ResponseEntity<ClienteDTO> update(@PathVariable Long id , @RequestBody ClienteDTO updatedCliente){
		if (id >= clientes.size() || id < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		int index = id.intValue();
		ClienteDTO oldCliente = clientes.remove(index);
		clientes.add(index,updatedCliente);
		
		return  new ResponseEntity<>(oldCliente,HttpStatus.OK);
		
		
	}
}