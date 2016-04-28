package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.MyRMIServer;
import mydesktop.Player;

public class RMIServerImpl extends UnicastRemoteObject implements MyRMIServer {

	private Player playerOne;
	private Boolean playerOneReady = false;
	private Player playerTwo;
	private Boolean playerTwoReady = false;

	public RMIServerImpl() throws RemoteException {
	}

	public String hello(String s) throws RemoteException {
		System.out.println(s);
		return s + "Hello from server!";
	}

	@Override
	public int connect(Player player) throws RemoteException {
		if (playerOne == null) {
			playerOne = player;
			playerOne.setNumberPlayer(1);
			System.out.println("playerOne connect");
			return 1;
		}
		if (playerTwo == null) {
			playerTwo = player;
			playerTwo.setNumberPlayer(2);
			System.out.println("playerTwo connect");
			return 2;
		}
		return 0;
	}

	@Override
	public void sendField(int numberPlayer, int[][] masPlay) throws RemoteException {
		if (numberPlayer == 1) {
			playerOne.setMasPlay(masPlay);
			System.out.println("playerOne Ready");

			playerOneReady = true;
		}
		if (numberPlayer == 2) {
			playerTwo.setMasPlay(masPlay);
			System.out.println("playerTwo Ready");
			playerTwoReady = true;
		}
	}

	@Override
	public int[][] getPlayerField(int numberPlayer) throws RemoteException {
		switch (numberPlayer) {
		case 1: {
			if (playerTwo != null) {
				int[][] massTwo = playerTwo.getMasPlay();
				return massTwo;
			}
		}
		case 2: {
			if (playerOne != null) {
				int[][] massOne = playerOne.getMasPlay();
				return massOne;
			}
		}
		default:
			return null;
		}
	}

}
