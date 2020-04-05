package br.edu.sc.senac.demo.demoproject;

public class ClienteDTO {

	public static final ClienteDTO NULL_VALUE = new ClienteDTO(Long.valueOf(0), "", "", "");

	private Long id;
	private String nome;
	private String dataNascimento;
	private String email;

	public ClienteDTO(Long id, String nome, String dataNascimento, String email) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;

	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public Long getId() {
		return id;
	}

}