package sisdist.threads;

public class MinhaTarefa {
	
	private String tarefa;
	private String tipo;
	
	public MinhaTarefa(String tarefa, String tipo) {
			this.tarefa = tarefa;
			this.tipo = tipo;
	}
	
	public void run() {
		System.out.println();
		System.out.println("O nome da tarefa é: " + this.tarefa);
		System.out.println("O tipo é..........: " + this.tipo);
		System.out.println();
	}	
	
}
