package servico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import modelo.Eleitor;
public class ConsultaEstatistica {
	
	public void pconsultaPosicao(int [] votosApurados, int posicao) {
		
		
		if(posicao == 1) {
			if(votosApurados[0] > votosApurados[1]) {
				System.out.println("Vencedor: Joao | " + votosApurados[0] + " Votos.");
			}else {
				System.out.println("Vencedor: Maria | " + votosApurados[1] + " Votos.");
			}
		}
		
		if(posicao == 2) {
			if(votosApurados[0] > votosApurados[1]) {
				System.out.println("Segundo colocado: Maria | " + votosApurados[1] + " Votos.");
			}else {
				System.out.println("Segundo colocado: Joao | " + votosApurados[0] + " Votos.");
			}
		}
		
	}
	
	public void mostraBranco(int[] votosApurados) {
		System.out.println("Quantidade de brancos: " + votosApurados[2]);
	}
	
	public void mostraNulo(int[] votosApurados) {
		System.out.println("Quantidade de nulos: " + votosApurados[3]);
	}
	
	public void mostraEleitores(Eleitor[] eleitores)throws IOException {
		String fileEleitores = "Eleitor.txt";
		BufferedReader ler = new BufferedReader(new FileReader(fileEleitores));
		
		for(int i = 0; i < eleitores.length; i++) {
			System.out.println("Numero:" + ler.readLine());
			System.out.println("Nome:" + ler.readLine());
			System.out.println("Secao:" + ler.readLine() + "\n");
		}
	}
	
}
