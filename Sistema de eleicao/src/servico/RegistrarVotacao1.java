package servico;

import modelo.*;
import java.io.*;
import javax.swing.*;
public class RegistrarVotacao1 {

	
	public void PgravaVotacao(Eleitor[] eleitores, int opc)throws IOException {
		String fileName = "Eleitor.txt";
		String fileWrite = "votacao" + opc + ".txt";
		
		Vota[] votacoes = new Vota[10];
		
		pleArquivoEleitores(opc,votacoes,fileName);
		pregistraCodCandidato(votacoes);
		pclassificaVota(votacoes);
		pgravaVotacao(votacoes, fileWrite);
		
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
	
	public void pgravaVotacao(Vota[] votacoes, String fileWrite)throws IOException {
		
		BufferedWriter gravar = new BufferedWriter(new FileWriter(fileWrite));
		
		for(int i = 0; i < 10; i++) {
			Vota v = votacoes[i];
			if(v.getSecao() != 0) {
				
				gravar.write(Integer.toString(v.getNumEleitor()));
				gravar.newLine();
				
				gravar.write(Integer.toString(v.getCodCandidato()));
				gravar.newLine();
				
				gravar.write(Integer.toString(v.getSecao()));
				gravar.newLine();
			}
		}
		System.out.println("Votação gravada com sucesso");
		gravar.close();
	}
	
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
	
	public void pclassificaVota(Vota[] votacoes) {
		int aux;
		for(int i = 0; i < votacoes.length-1;i++) {
			for(int j = (i+1); j < votacoes.length; j++) {
				Vota vi = votacoes[i];
				Vota vj = votacoes[j];
				if(vi.getCodCandidato() > vj.getCodCandidato()) {
					
					aux = vi.getCodCandidato();
					vi.setCodCandidato(vj.getCodCandidato());
					vj.setCodCandidato(aux);
					
					aux = vi.getNumEleitor();
					vi.setNumEleitor(vj.getNumEleitor());
					vj.setNumEleitor(aux);
					
					aux = vi.getSecao();
					vi.setSecao(vj.getSecao());
					vj.setSecao(aux);
				}
			}
		}
	}
	

	
	}
	
	

