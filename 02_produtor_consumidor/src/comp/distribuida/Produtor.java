package comp.distribuida;

public class Produtor implements java.lang.Runnable {

	private Valor valor;

	public Produtor(Valor valor) {
		this.valor = valor;
	}

	@Override
	public void run() {
		int tempo;

		for (int i = 1; i <= 100; i++) {
			tempo = (int) (Math.random() * 3000);
			valor.guardar(i);
			System.out.println("Produzindo... \t" + i + "\t" 
					+ tempo + "ms\t\t" + Thread.currentThread().getName());

			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				System.out.println("Erro na produção: " + e.getMessage());
			}
		}
	}

}
