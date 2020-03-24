package triptest;

/**
*
* @author Miqueias
*/

public class Passageiro {
	
	private String nome;
	private String sobrenome;
	private String nacionalidade;
	private String dataNascimento;
	private String sexo;
	private String naturalidade;
	private String rg;
	private Passagem passagem;
	
	public Passageiro (String nome, String sobrenome, String nacionalidade, String dataNascimento, String sexo, String naturalidade, String rg, Passagem passagem) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nacionalidade = nacionalidade;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.naturalidade = naturalidade;
		this.rg = rg;
		this.passagem = passagem;
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

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Passagem getPassagem() {
		return passagem;
	}

	public void setPassagem(Passagem passagem) {
		this.passagem = passagem;
	}
}

