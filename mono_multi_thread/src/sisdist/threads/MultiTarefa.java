package sisdist.threads;

public class MultiTarefa {
	public static void main(String[] args) {
		
		//três instâncias de "MinhaTarefa"
		MinhaTarefa tarefa1 = new MinhaTarefa("Listar", "Produtos");
		MinhaTarefa tarefa2 = new MinhaTarefa("Atualizar", "Produtos");
		MinhaTarefa tarefa3 = new MinhaTarefa("Excluir", "Usuário");
		
		//Execução individial de cada instância
		tarefa1.run();
		tarefa2.run();
		tarefa3.run();
		
	}
}
