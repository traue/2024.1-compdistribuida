package br.calc.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcRmi extends UnicastRemoteObject implements CalcInterface {
	
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	
	public CalcRmi() throws RemoteException {
		this.usuario = "Não informado";
	}
		
	@Override
	public String getUsuario() {
		return usuario;
	}

	@Override
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public float soma(float a, float b) throws RemoteException {
		System.out.println("Soma solicitada por: " + this.usuario);
		return a + b;
	}

	@Override
	public float subtrai(float a, float b) throws RemoteException {
		System.out.println("Subtrção solicitada por: " + this.usuario);
		return a - b;
	}

	@Override
	public float multiplica(float a, float b) throws RemoteException {
		System.out.println("Multiplicação solicitada por: " + this.usuario);
		return a * b;
	}

	@Override
	public float divide(float a, float b) throws RemoteException {
		System.out.println("Divisão solicitada por: " + this.usuario);
		if (b == 0)
			return Float.NaN;
		
		return a / b;
	}
	
}
