package mydesktop;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import interfaces.MyRMIServer;

public class Client {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		// MyRMIServer s = (MyRMIServer) Naming.lookup("//127.0.0.1/SayHello");
		MyRMIServer s = (MyRMIServer) Naming.lookup("//localhost/SeaBattle");

		// String message = s.hello("client 1");

		// System.out.println(message);

		Player player1 = new Player();
		player1.setName("петро");
		player1.start();

		player1.setNumberPlayer(s.connect(player1));
		System.out.println(player1.getNumberPlayer());
		// s.sendField(numberPlayer, masPlay);

	}

}
