package sisdist.threads;

public class MinhaThread {
	
	public static void main(String[] args) {
		
		int nucleos = Runtime.getRuntime().availableProcessors();
		
		System.out.println();
		
		System.out.println("Thread principal: " + Thread.currentThread().getName());
		System.out.println("Nr. de núcleos: " + nucleos);
		
		System.out.println();
		
		for (int i = 0; i < nucleos; i++) {
			//cria uma Thread a cada interação
			new Thread("" + i) {
				public void run() {
					long soma = 0;
					System.out.println("Thread.........: " + getName() + " executando...");
					for (int i = 0; i < 10000; i++) {
						soma += i;
						System.out.println(i + "\t" + soma + "\t" + System.currentTimeMillis());
					}
				}
			}.run();
		}
		
	}
	
}
