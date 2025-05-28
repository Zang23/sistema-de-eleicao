package servico;

import java.io.*;
import modelo.*;

public class ApuraVotacao {

	public void papuraVotacao()throws IOException {
		String fileVotacao1 = "votacao1.txt";
		String fileVotacao2 = "votacao2.txt";
		
		int c1 = 0;
		int c2= 0;
		
		c1 = fleLinhaArquivo(fileVotacao1, c1);
		Apuracao[] apurado1 = new Apuracao[c1];
		
		c2 = fleLinhaArquivo(fileVotacao2, c2);
		Apuracao[] apurado2 = new Apuracao[c2];
		
		pleArquivo(apurado1, c1, fileVotacao1);
		
		
	}
	
	public int fleLinhaArquivo(String fileName, int contador)throws IOException {
		
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		
		while(ler.readLine() != null) {
			contador++;
		}
		System.out.println(contador);
		
		return contador;
	}
	
	
	public void pleArquivo(Apuracao[] apurado, int tamanhoVetor, String fileName)throws IOException {
		
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		
		int numEleitor = 0;
		int secao = 0;
		int codCandidato = 0;
		
		for (int i = 0; i < tamanhoVetor; i++) {
			numEleitor = Integer.parseInt(ler.readLine());
			codCandidato = Integer.parseInt(ler.readLine());
			secao = Integer.parseInt(ler.readLine());
		}
	}
	
}
