/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triptest;

/**
 *
 * @author Miqueias
 */

public class Passagem {
	
	private String dataExpedicao;
	private String validade;
	private String autoridade;
	private String numero;
	private String tipo;
	private String paisEmissor;
	private Passageiro passageiro;
	
	public Passagem (String dataExpedicao, String validade, String autoridade, String numero, String tipo, String paisEmissor, Passageiro passageiro) {
		this.dataExpedicao = dataExpedicao;
		this.validade = validade;
		this.autoridade = autoridade;
		this.numero = numero;
		this.tipo = tipo;
		this.paisEmissor = paisEmissor;
		this.passageiro = passageiro;
	}

	public String getDataExpedicao() {
		return dataExpedicao;
	}

	public void setDataExpedicao(String dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public String getAutoridade() {
		return autoridade;
	}

	public void setAutoridade(String autoridade) {
		this.autoridade = autoridade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPaisEmissor() {
		return paisEmissor;
	}

	public void setPaisEmissor(String paisEmissor) {
		this.paisEmissor = paisEmissor;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	

}

