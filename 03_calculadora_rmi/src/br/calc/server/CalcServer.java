package br.calc.server;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;

public class CalcServer {
	
	public static void main(String[] args) {
		try {
			
			//porta padrão do RMI = 1099
			Registry r = LocateRegistry.createRegistry(2300);
			r.rebind("Calculadora", new CalcRmi());
			System.out.println("Servidor conectado!");
			
		} catch (RemoteException e) {
			System.out.println("Servior não conectado....: " + e.getMessage());
		}
	}
	
}
