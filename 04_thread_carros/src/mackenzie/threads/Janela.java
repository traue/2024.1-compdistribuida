package mackenzie.threads;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Janela extends Frame {

	private static final long serialVersionUID = 1L;

	public Janela(String titulo) {
		super(titulo);
		setSize(800, 600);
		addWindowListener(new Terminator());
	}

	class Terminator extends WindowAdapter {

		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

	}

}
