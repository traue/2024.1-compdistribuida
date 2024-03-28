package br.calc.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalcInterface extends Remote {

	public float soma(float x, float y) throws RemoteException;

	public float subtrai(float x, float y) throws RemoteException;

	public float multiplica(float x, float y) throws RemoteException;

	public float divide(float x, float y) throws RemoteException;

	public void setUsuario(String usuario) throws RemoteException;

	public String getUsuario() throws RemoteException;

}
