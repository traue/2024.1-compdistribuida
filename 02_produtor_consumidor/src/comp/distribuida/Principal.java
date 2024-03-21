package comp.distribuida;

public class Principal {
	
	public static void main(String[] args) {
		
		Valor valor = new Valor();
		System.out.println("Processadores: " + Runtime.getRuntime().availableProcessors());
		System.out.println("Iniciando as Threads - Produtor e Consumidor...\n");
		
		new Thread(new Produtor(valor)).start();
		new Thread(new Consumidor(valor)).start();
	}
	
}
