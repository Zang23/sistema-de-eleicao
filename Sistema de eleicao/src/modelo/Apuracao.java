package modelo;

public class Apuracao {
	
	private int secao;
	private int codCandidato;
	private int numEleitor;
	
	
	public Apuracao() {
		this(0,0,0);
	}
	
	
	public Apuracao (int secaoApurada, int codCandidatoApurado, int numEleitorApurado) {
		secao = secaoApurada;
		codCandidato = codCandidatoApurado;
		numEleitor = numEleitorApurado;
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
		this.codCandidato = codCandidato ;
	}
	
	public int getNumEleitor() {
		return numEleitor;
	}
	
	public void setNumEleitor(int numEleitor) {
		this.numEleitor = numEleitor;
	}
}
