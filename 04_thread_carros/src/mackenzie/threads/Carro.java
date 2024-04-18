package mackenzie.threads;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;

public class Carro extends Thread {

	private int id; // identificador da thread
	private static int numCarros = 0; // nº de carros criados
	private Panel canvas; // representa o desenho do carro
	private Color cor; // cor do carro
	private int pos = 0; // posição na corrida
	private static int N = 1000; // nº de iterações

	public Carro(Panel canvas, Color cor) {
		id = numCarros++;
		this.canvas = canvas;
		this.cor = cor;
	}

	public void desenharCarro() {

		Graphics g = canvas.getGraphics();
		Dimension d = canvas.getSize();
		int largura = d.height;
		int x = pos * d.width / N;

		g.setColor(cor);
		g.fillOval(x, largura / 2 - 10, 40, 20);
		g.setColor(Color.white);
		g.drawString(String.valueOf(id), x + 20, largura / 2 + 6);
		g.setColor(Color.black);
		g.fillOval(x + 10, largura / 2 - 10, 6, 4);
		g.fillOval(x + 10, largura / 2 + 6, 6, 4);
		g.fillOval(x + 24, largura / 2 - 10, 6, 4);
		g.fillOval(x + 24, largura / 2 + 6, 6, 4);
	}

	public void apagarCarro() {
		Graphics g = canvas.getGraphics();
		Dimension d = canvas.getSize();
		Color background = canvas.getBackground();
		int largura = d.height;
		int x = pos * d.width / N;

		g.setColor(background);
		g.fillOval(x, largura / 2 - 10, 6, 40);
		g.setColor(Color.black);
		g.drawLine(x, largura / 2, d.width, largura / 2);
	}

	public void mover() {
		apagarCarro();
		pos++;
		desenharCarro();
	}

	@Override
	public void run() {
		desenharCarro();
		while (pos < N) {
			try {
				Thread.sleep(5); // em milisegundos
				 for (int i = 1; i < 5; i++) {
					 mover();
				 }
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Chegada: " + id);
	}

}
