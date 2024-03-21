package comp.distribuida;

public class Consumidor implements java.lang.Runnable {

	private Valor valor;

	public Consumidor(Valor valor) {
		this.valor = valor;
	}

	@Override
	public void run() {
		int tempo;
		for (int i = 1; i <= 100; i++) {

			tempo = (int) (Math.random() * 3000);

			System.out.println("Consumindo...\t" + valor.exibir() + "\t" 
				    + tempo + "ms\t\t" + Thread.currentThread().getName());

			System.out.println();

			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				System.out.println("Erro no consumo: " + e.getMessage());
			}
		}
	}

}
