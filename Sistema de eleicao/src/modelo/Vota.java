package modelo;

public class Vota{
	
	private int secao;
	private int codCandidato;
	private int numEleitor;
	
	public Vota(){
		this(0,0,0);
	}
	
	public Vota(int secaoVota, int codCandidatoVota, int numEleitorVota) {
		secao = secaoVota;
		codCandidato = codCandidatoVota;
		numEleitor = numEleitorVota;
	}
	
	public int getSecao() {
		return secao;
	}
	
	public void setSecao(int secao) {
		this.secao = secao;
	}
	
	public int getCodCandidato() {
		return codCandidato;
	}
	
	public void setCodCandidato(int codCandidato) {
		this.codCandidato = codCandidato;
	}
	
	public int getNumEleitor() {
		return numEleitor;
	}
	
	public void setNumEleitor(int numEleitor) {
		this.numEleitor = numEleitor;
	}
}
