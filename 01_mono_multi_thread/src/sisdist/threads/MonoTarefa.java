package sisdist.threads;

public class MonoTarefa {
	
	public static void main(String[] args) {
		
		//instância da classe MinhaTarefa, cahamada tarefa1
		MinhaTarefa tarefa1 = new MinhaTarefa("Listar", "Produtos");
		
		//executa a tarefa1
		tarefa1.run();
		
		//recriação da tarefa
		tarefa1 = new MinhaTarefa("Criar", "Usuário admin");
		
		//reexecução da tarefa
		tarefa1.run();
	}
	
}
