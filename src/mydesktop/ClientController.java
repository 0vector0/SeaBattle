package mydesktop;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import interfaces.MyRMIServer;

public class ClientController {

	public static MyRMIServer s;

	public ClientController() {
		try {
			s = (MyRMIServer) Naming.lookup("//localhost/SeaBattle");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int connect(Player player) {
		try {
			return s.connect(player);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 10;
	}

	public int[][] getPlayerField(int numberPlayer) {
		try {
			return s.getPlayerField(numberPlayer);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void sentField(int numberPlayer, int[][] masPlay) {
		try {
			s.sendField(numberPlayer, masPlay);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
