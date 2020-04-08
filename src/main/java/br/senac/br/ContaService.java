package br.senac.br;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/c1/conta")
public class ContaService {

	private HashMap<String, ContaDTO> contas = new HashMap<>();

	@GetMapping("/cadastro")
	public void list() {

		contas.put("0", new ContaDTO(Long.valueOf(1), "sheila mello", "sm/0128-0", Double.valueOf(950000)));
		contas.put("1", new ContaDTO(Long.valueOf(2), "jacare", "j/0128-1", Double.valueOf(3080000)));
		contas.put("2", new ContaDTO(Long.valueOf(3), "compadre washiton", "cw/0128-2", Double.valueOf(180000)));
		contas.put("3", new ContaDTO(Long.valueOf(4), "carla perez", "cp/0128-3", Double.valueOf(2000000)));
		contas.put("4", new ContaDTO(Long.valueOf(4), "beto jamaica", "bj/0128-4", Double.valueOf(400000)));

	}

	@GetMapping("/list")
	public HashMap<String, ContaDTO> getlist() {

		return contas;

	}

}