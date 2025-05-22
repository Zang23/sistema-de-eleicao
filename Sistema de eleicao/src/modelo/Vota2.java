package modelo;

public class Vota2 {
	
	
	private int secao2;
	private int codCandidato2;
	private int numEleitor2;
	
	public Vota2(){
		this(0,0,0);
	}
	
	public Vota2(int secaoVota2, int codCandidatoVota2, int numEleitorVota2) {
		secao2 = secaoVota2;
		codCandidato2 = codCandidatoVota2;
		numEleitor2 = numEleitorVota2;
	}
	
	public int getSecao2() {
		return secao2;
	}
	
	public void setSecao2(int secao2) {
		this.secao2 = secao2;
	}
	
	public int codCandidato2() {
		return codCandidato2;
	}
	
	public void setCodCandidato2(int codCandidato2) {
		this.codCandidato2 = codCandidato2;
	}
	
	public int getNumEleitor2() {
		return numEleitor2;
	}
	
	public void setNumEleitor2(int numEleitor2) {
		this.numEleitor2 = numEleitor2;
	}
}
