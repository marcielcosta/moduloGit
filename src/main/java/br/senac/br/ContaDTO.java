package br.senac.br;

public class ContaDTO {

	private Long id;
	private String titular;
	private Double saldo;
	private String numConta;

	public ContaDTO(Long id, String titular, String numConta, Double saldo) {
		this.id = id;
		this.titular = titular;
		this.saldo = saldo;
		titular = numConta;

	}

	public Long getId() {
		return id;
	}

	public String getNumConta() {
		return numConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public String getTitular() {
		return titular;
	}

}
