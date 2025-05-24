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
		
		Eleitor[] eleitores = new Eleitor[10];
		
		int opc = 0;
		
		while(opc != 9) {
			System.out.println("1- Cadastra Eleitor\n2- Cadastra Vota��o 1 e 2\n3- Agrupa Apuração\n4- Menu estatistica\n9- Fim");
			opc = dados.nextInt();
			
			switch(opc) {
				case 1:
					eleitores = ce.FgravaEleitor(eleitores);
					break;
				case 2:
					int opc2 = 0;
					while(opc2 != 9) {
						System.out.println("1- Cadastro Vota��o 1\n2-Cadastro Vota��o 2\n9- Fim");
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
								System.out.println("Op��o invalida");
								break;
						}
					}
				case 3:
					av.papuraVotacao();
					break;
				case 4:
					break;
				case 9:
					break;
				default:
					System.out.println("Op��o invalida");
			}
		}
	}

}
