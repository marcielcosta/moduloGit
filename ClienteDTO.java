package br.edu.sc.senac.demo.demoproject;

public class ClienteDTO {

	private String nome;
	private String dataNascimento;
	private String email;

	public ClienteDTO(String nome, String dataNascimento, String email) {
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
}