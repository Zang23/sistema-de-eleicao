package modelo;

public class Eleitor {
	
	
	private int numero;
	private String nome;
	private int secao;
	
	public Eleitor() {
		this(0,"",0);
	}
	
	public Eleitor(int numeroEleitor, String nomeEleitor, int secaoEleitor) {
		numero = numeroEleitor;
		nome = nomeEleitor;
		secao = secaoEleitor;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getSecao() {
		return secao;
	}
	
	public void setSecao(int secao) {
		this.secao = secao;
	}
	
}
