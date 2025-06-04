package main;


import modelo.*;
import servico.*;


import java.io.*;
import java.util.Scanner;
public class main {

	public static void main(String[] args)throws IOException {
		Scanner dados = new Scanner(System.in);
		CadastrarEleitor ce = new CadastrarEleitor();
		RegistrarVotacao1 rv = new RegistrarVotacao1();
		ApuraVotacao av = new ApuraVotacao();
		ConsultaEstatistica e = new ConsultaEstatistica();
		
		Eleitor[] eleitores = new Eleitor[10];
		int[] votosApurados = new int[4];
		
		int opc = 0;
		
		while(opc != 9) {
			System.out.println("1- Cadastra Eleitor\n2- Cadastra Votaï¿½ï¿½o 1 e 2\n3- Agrupa ApuraÃ§Ã£o\n4- Menu estatistica\n9- Fim");
			opc = dados.nextInt();
			
			switch(opc) {
				case 1:
					eleitores = ce.FgravaEleitor(eleitores);
					break;
				case 2:
					int opc2 = 0;
					while(opc2 != 9) {
						System.out.println("1- Cadastro Votaï¿½ï¿½o 1\n2-Cadastro Votaï¿½ï¿½o 2\n9- Fim");
						opc2 = dados.nextInt();
						switch(opc2) {
							case 1:
								rv.PgravaVotacao(eleitores, opc2);
								break;
							case 2:
								rv.PgravaVotacao(eleitores, opc2);
								break;
							case 9:
								break;
							default:
								System.out.println("Opï¿½ï¿½o invalida");
								break;
						}
					}
				case 3:
					 votosApurados = av.fapuraVotacao();
					break;
				case 4:
					int opc3 = 0;
					while(opc != 9) {
						System.out.println("1- Vencedor\n2- Segundo Colocado\n3- Quantidade de votos em branco\n4- Quantidade de votos nulos\n5- Mostra Eleitores\n6- Mostra Apuração\n9- FIM" );
						opc3 = dados.nextInt();
						switch(opc3) {
							case 1:
								e.pconsultaPosicao(votosApurados, 1);
								break;
							case 2:
								e.pconsultaPosicao(votosApurados, 2);
								break;
							case 3:
								e.mostraBranco(votosApurados);
								break;
							case 4:
								e.mostraNulo(votosApurados);
								break;
							case 5:
								e.mostraEleitores(eleitores);
								break;
							case 9:
								break;
							default:
								System.out.println("Opção invalida");
						}
					}
					break;
				case 9:
					break;
				default:
					System.out.println("Opï¿½ï¿½o invalida");
			}
		}
	}

}
