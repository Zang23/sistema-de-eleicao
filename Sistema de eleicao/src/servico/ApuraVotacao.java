package servico;

import java.io.*;
import modelo.*;

public class ApuraVotacao {
	public int[] fapuraVotacao()throws IOException {
		String fileVotacao1 = "votacao1.txt";
		String fileVotacao2 = "votacao2.txt";
		
		
		int c1 = fleLinhaArquivo(fileVotacao1);
		Apuracao[] v1 = new Apuracao[c1];
		
		int c2 = fleLinhaArquivo(fileVotacao2);
		Apuracao[] v2 = new Apuracao[c2];
		
		int[] votosApurados = new int[4];
		
		pleArquivo(v1, fileVotacao1);
		pleArquivo(v2, fileVotacao2);
		
		return votosApurados = fapuraVotos(v1,v2);
		
		
	}
	
	
	public int fleLinhaArquivo(String fileName)throws IOException {
		
		int contador = 0;
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		
		while(ler.readLine() != null) {
			contador++;
		}
		
		contador /=3;
		return contador;
	}
	
	
	public void pleArquivo(Apuracao[] apurado, String fileName)throws IOException {
		
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		
		int numEleitor = 0;
		int secao = 0;
		int codCandidato = 0;
		
		for (int i = 0; i < apurado.length; i++) {
			numEleitor = Integer.parseInt(ler.readLine());
			codCandidato = Integer.parseInt(ler.readLine());
			secao = Integer.parseInt(ler.readLine());
			
			apurado[i] = new Apuracao(secao, codCandidato, numEleitor);
		}
		
		
	}
	
	public int[] fapuraVotos(Apuracao[] v1, Apuracao[] v2) {
		int[] votosApurados = new int[4];
		Apuracao[] v3 = new Apuracao[v1.length + v2.length];
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < v1.length && j < v2.length) {
			if(v1[i].getCodCandidato() < v2[j].getCodCandidato() ) {
				v3[k++] = v1[i++];
			}else {
				v3[k++] = v2[j++];
			}
		}
		
		while(i < v1.length) {
			v3[k++] = v1[i++];
		}
		
		while(j < v2.length) {
			v3[k++] = v2[j++];
		}
		
		votosApurados = fcontaVotos(v3);
		
		return votosApurados;
	}
	
	
	public int[] fcontaVotos(Apuracao[] v3) {
		int[] votosApurados = new int [4];
		int codCandidato = 1;
		for(int i = 0; i < v3.length;i++) {
			if(v3[i].getCodCandidato() == codCandidato) {
				votosApurados[codCandidato-1]++;
			}else {
				votosApurados[codCandidato]++;
				codCandidato++;
			}
		}
		
		return votosApurados;
	}
	
}
