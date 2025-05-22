package modelo;

public class Vota1 {
	
	
	private int secao1;
	private int codCandidato1;
	private int numEleitor1;
	
	public Vota1(){
		this(0,0,0);
	}
	
	public Vota1(int secaoVota1, int codCandidatoVota1, int numEleitorVota1) {
		secao1 = secaoVota1;
		codCandidato1 = codCandidatoVota1;
		numEleitor1 = numEleitorVota1;
	}
	
	public int getSecao1() {
		return secao1;
	}
	
	public void setSecao1(int secao1) {
		this.secao1 = secao1;
	}
	
	public int codCandidato1() {
		return codCandidato1;
	}
	
	public void setCodCandidato1(int codCandidato1) {
		this.codCandidato1 = codCandidato1;
	}
	
	public int getNumEleitor1() {
		return numEleitor1;
	}
	
	public void setNumEleitor1(int numEleitor1) {
		this.numEleitor1 = numEleitor1;
	}
}
