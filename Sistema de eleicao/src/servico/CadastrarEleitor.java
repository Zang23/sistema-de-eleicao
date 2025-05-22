package servico;
import java.util.Random;
import java.io.*;
import modelo.Eleitor;
import javax.swing.*;
public class CadastrarEleitor {

	public Eleitor[] FgravaEleitor(Eleitor[] eleitor)throws IOException {
		String fileName = "Eleitor.txt";
		BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));
		
		Random random = new Random();
		
		String[] nomes = {
	            "Ana", "Bruno", "Carlos", "Daniela", "Eduardo", 
	            "Fernanda", "Gabriel", "Helena", "Igor", "Juliana"
	    };
		
		for(int i = 0; i < 10; i++) {
			eleitor[i] = new Eleitor();
		}
		
		for(int i = 0; i < 10; i++) {
				
				int numAleatorio = random.nextInt(15);
				//int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite seu numero de eleitor: "));
				eleitor[i].setNumero(numAleatorio+1);
				gravar.write(Integer.toString(eleitor[i].getNumero()));
				gravar.newLine();
				
				//String nome = JOptionPane.showInputDialog("Insira seu nome: ");
				eleitor[i].setNome(nomes[i]);
				gravar.write(eleitor[i].getNome());
				gravar.newLine();
				
				
				
				int secao = verificaSecao(i);
				eleitor[i].setSecao(secao);
				gravar.write(Integer.toString(eleitor[i].getSecao()));
				gravar.newLine();
		}
		
		System.out.println("Gravação feita com sucesso!");
		gravar.close();
		return eleitor;
		
		
		
	}
	
	public int verificaSecao(int i) {
		boolean verificado = false;
		Random random = new Random();
		
		
		int secao = 0;
		while(!verificado) {
			secao = random.nextInt(11);
			//secao = Integer.parseInt(JOptionPane.showInputDialog("Eleitor: "+ (i+1)+ "Digite sua seção: "));
			if(secao == 1 || secao == 3 || secao == 4 || secao == 5 || secao == 9 || secao == 10) {
				verificado = true;
				break;
			}
		}
		return secao;
	}
}
