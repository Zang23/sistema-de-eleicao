package servico;

import modelo.*;
import java.io.*;
import javax.swing.*;
public class RegistrarVotacao1 {

	
	public void PgravaVotacao(Eleitor[] eleitores, int opc)throws IOException {
		String fileName = "Eleitor.txt";
		String fileWrite = "votacao" + opc + ".txt";
		
		
		Vota[] votacoes = new Vota[10];
		int[][] matrizVotacao = new int[2][4];
		
		pleArquivoEleitores(opc,votacoes,fileName);
		pregistraCodCandidato(votacoes);
		
		//codVotacao = fgravaVotacao(votacoes, fileWrite, opc, codVotacao);
		//matrizVotacao = fpreencheMatrizVotacao(codVotacao, matrizVotacao);
		pclassificaMatriz(matrizVotacao);
		
		/*for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.println(matrizVotacao[i][j]);
			}
		}*/
		
	}
	
	
	
	public int fverificaSecao(int secao, int opc) {
		
		if(opc == 1) {
			if(secao == 1 || secao == 3 || secao == 4) {
				return secao;
			}else {
				return 0;
			}
		}else {
			if(secao == 5 || secao == 9 || secao == 10) {
				return secao;
			}else {
				return 0;
			}
		}
	}
	
	public void pleArquivoEleitores(int opc, Vota[] votacoes, String fileName)throws IOException {
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		
		int secaoVerificada = 0;
		int numEleitor = 0;
		for(int i = 0; i < 10; i++) {
			if(opc == 1) {
				numEleitor = Integer.parseInt(ler.readLine());
				ler.readLine();
				secaoVerificada = fverificaSecao(Integer.parseInt(ler.readLine()), opc);
				
			}else {
				numEleitor = Integer.parseInt(ler.readLine());
				ler.readLine();
				secaoVerificada = fverificaSecao(Integer.parseInt(ler.readLine()), opc);
			}
			
			votacoes[i] = new Vota(secaoVerificada, 0 ,numEleitor);
		}
		ler.close();
	}
	
	public int fverificaCandidato(int codVotacao, Vota[] votacoes) {
		JFrame frame = new JFrame();
		frame.setAlwaysOnTop(true);
		
		boolean verificado = false;
		Vota v;
		
		while(!verificado) {
			int codCandidato = Integer.parseInt(JOptionPane.showInputDialog(frame, "1---Jose\n2---Maria\n3---Branco\n4---Nulo"));
			
			if(codCandidato == 1 || codCandidato == 2 || codCandidato == 3 || codCandidato == 4) {
				return codCandidato;
			}
		}
		
		return 0;
	}
	
	/*public int[] fgravaVotacao(Vota[] votacoes, String fileWrite, int opc, int[] codVotos )throws IOException {
		
		BufferedWriter gravar = new BufferedWriter(new FileWriter(fileWrite));
		
		int candidato = 0;
		for(int i = 0; i < 10; i++) {
			Vota v = votacoes[i];
			if(v.getSecao() != 0) {
				gravar.write(Integer.toString(v.getNumEleitor()));
				gravar.newLine();
				
				int codCandidato = fverificaCandidato(0, codVotos);
				v.setCodCandidato(codCandidato);
				gravar.write(Integer.toString(codCandidato));
				gravar.newLine();
				
				gravar.write(Integer.toString(v.getSecao()));
				gravar.newLine();
			}
		}
		System.out.println("Votação: " + opc + " gravada com sucesso");
		gravar.close();
		return codVotos;
	}*/
	
	public void pregistraCodCandidato(Vota[] votacoes) {
		
		int codCandidato = 0;
		for(int i = 0; i < 10; i++) {
			Vota v = votacoes[i];
			codCandidato = fverificaCandidato(codCandidato,votacoes );
			v.setCodCandidato(codCandidato);
		}
	}
	
	
	public int[][] fpreencheMatrizVotacao(int[] codVotacao, int[][] matrizVotacao) {
		
		for(int i = 0; i < 4; i++) {
			matrizVotacao[0][i] = codVotacao[i];
			matrizVotacao[1][i] = i+1;
		}
		
		return matrizVotacao;
			
		
	}
	
	public void pclassificaMatriz(int[][] matriz) {
		int aux;
		for(int i = 0; i < (matriz[0].length-1);i++) {
			for(int j = (i+1); j < matriz[0].length; j++) {
				if(matriz[0][i] < matriz[0][j]   ) {
					aux = matriz[0][i];
					matriz[0][i] = matriz[0][j];
					matriz[0][j] = aux;
					
					aux = matriz[1][i];
					matriz[1][i] = matriz[1][j];
					matriz[1][j] = aux;
					
				}
			}
		}
	}

	
	}
	
	

