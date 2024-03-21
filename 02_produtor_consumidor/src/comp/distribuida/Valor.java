package comp.distribuida;

public class Valor {

	int valor;
	private boolean bloqueado;

	public Valor() {
		this.bloqueado = false;
	}

	public synchronized void guardar(int valor) {

		while (bloqueado) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Erro guardando valores: " + e.getMessage());
			}
		}

		this.valor = valor;
		this.bloqueado = true;
		notify();

	}

	public synchronized int exibir() {
		while (!bloqueado) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Erro acessando o valor: " + e.getMessage());
			}
		}
		this.bloqueado = false;
		notify();
		return this.valor;
	}

}
