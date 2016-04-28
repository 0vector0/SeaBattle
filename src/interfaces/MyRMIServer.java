package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import mydesktop.Player;

public interface MyRMIServer extends Remote

{

	public String hello(String s) throws RemoteException;

	int connect(Player player) throws RemoteException;

	void sendField(int numberPlayer, int[][] masPlay) throws RemoteException;

	public int[][] getPlayerField(int numberPlayer) throws RemoteException;

}
