package mackenzie.threads;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

public class Principal {
	
	private static Carro[] carros;
	private static Panel[] pistas;
	private static int N = 10;
	
	public static void main(String[] args) {
		
		Janela janela = new Janela("Corrida com Concorrência");
		janela.setLayout(new GridLayout(N, 1));
		carros = new Carro[N];
		pistas = new Panel[N];
		
		//configura os carros e suas cores:
		Color cores[] = {
				Color.red, 
				Color.yellow, 
				Color.blue, 
				Color.magenta,
				Color.black,
				Color.gray,
				Color.orange,
				Color.green,
				Color.cyan,
				Color.pink
		};
		
		for (int i = 0; i < N; i++ ) {
			pistas[i] = new Panel();
			janela.add(pistas[i]);
			carros[i] = new Carro(pistas[i], cores[i]);
		}
		
		janela.setVisible(true);
		
		//int j = (int)(10 * Math.random());
		//carros[j].setPriority(1);
		
		carros[3].setPriority(1); //mais baixa
		carros[7].setPriority(9); //mais alta
		
		for (int i = 0; i < N; i++ ) {
			System.out.println("Iniciado Thread: " 
				+ i + " carro: " + carros[i].getName() 
				+ " prioridade: " + carros[i].getPriority());
			carros[i].start();
		}
				
		//System.out.println("Carro com maior prioridade: " + carros[j].getName());
	}
	
}
