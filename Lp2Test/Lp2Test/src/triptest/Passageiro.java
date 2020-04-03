package triptest;

import java.io.Serializable;

/**
*
* @author Miqueias
*/

public class Passageiro implements Serializable {
	
	private String nome;
	private String sobrenome;
	private String nacionalidade;
	private String dataNascimento;
	private String sexo; 
	private String rg;
	
	public Passageiro (String nome, String dataNascimento, String rg, String sobrenome, String nacionalidade, String sexo) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nacionalidade = nacionalidade;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.rg = rg;
	}
	
	public Passageiro() {
		nome = "vazio";
		sobrenome = "vazio";
		nacionalidade = "vazio";
		dataNascimento = "vazio";
		sexo = "vazio";
		rg = "vazio";
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	
}

