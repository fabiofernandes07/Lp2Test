package triptest;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miqueias
 */
public class Receiver extends Thread {

	ObjectInputStream input; // comunicação
	ObjectOutputStream output; // bidirecional
	//Seat[] seat;
	int a;
	
	

	public Receiver(Socket socketCliente) throws IOException {
		input = new ObjectInputStream(socketCliente.getInputStream());
		output = new ObjectOutputStream(socketCliente.getOutputStream());
		//new Vlaav(socketCliente).start();
		

	}

	@Override
	public void run() {
		while (true) {
			try {
				String c = "FON";
				output.writeObject(c);
				Object lido = input.readObject();
				if (lido instanceof Seat[]) {
					Seat[] seat = (Seat[]) lido;
					
					for (int i = 0; i < seat.length; i++) {
						if (seat[i].isFree()) {
							System.out.println(i + " ta livre");
						}
						else if(seat[i].isPurchased()) {
							
							System.out.println(i + " foi comprado");
						}
					}
					//seat[a].setPurchased();
					//output.writeObject(seat);
					//a++;
					
				}

			} catch (IOException | ClassNotFoundException ex) {
				Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
				break;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ex) {
				Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
			}

		}
	}
}