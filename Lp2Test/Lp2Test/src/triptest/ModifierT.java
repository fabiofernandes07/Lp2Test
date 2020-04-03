package triptest;

import java.io.*;
import java.net.*;

public class ModifierT extends Thread {

	ObjectInputStream input;
	ObjectOutputStream output; //

	int idSeat = 0; // O numero do assento
	int comando = 0; // Comandos: 1 = setFree ; 2 = setInProcess ; 3 = setPurchase
	String Nome, dataNasc, Rg, Sobrenome, Nacionalidade, Sexo;

	public ModifierT(Socket modifierSocket, int idSeat, int comando) throws IOException {
		input = new ObjectInputStream(modifierSocket.getInputStream());
		output = new ObjectOutputStream(modifierSocket.getOutputStream());
		this.idSeat = idSeat;
		this.comando = comando;
	}

	public ModifierT(Socket modifierSocket,int idSeat, String Nome, String dataNasc, String Rg, String Sobrenome,
			String Nacionalidade, String Sexo) throws IOException {

		input = new ObjectInputStream(modifierSocket.getInputStream());
		output = new ObjectOutputStream(modifierSocket.getOutputStream());
		this.Nome = Nome;
		this.dataNasc = dataNasc;
		this.Rg = Rg;
		this.Sobrenome = Sobrenome;
		this.Nacionalidade = Nacionalidade;
		this.Sexo = Sexo;
		this.idSeat = idSeat;
	}

	@Override
	public void run() {

		try {
			String s = "Modifier";
			output.writeObject(s);
			Object read = input.readObject();
			if (read instanceof Seat[]) {
				Seat[] modfT = (Seat[]) read;

				if (comando != 0) {
					switch (comando) {

					case 1:
						modfT[idSeat].setFree();
						System.out.println(idSeat);
						break;
					case 2:
						modfT[idSeat].setInProcess();
						System.out.println(idSeat);
						break;
					case 3:
						modfT[idSeat].setPurchased();
						System.out.println(idSeat);
						break;
					default:
						break;
					}

					output.writeObject(modfT);
					System.out.println("foi if");	
				}
				
				else {
					
					Passageiro p = new Passageiro(Nome, dataNasc, Rg, Sobrenome, Nacionalidade, Sexo);
					modfT[idSeat].setPassageiro(p);
					output.writeObject(modfT);
					System.out.println("foi else");					
				}
				
			}

		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		try {
//			Thread.sleep(2500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Socket s = new Socket("127.0.0.1", 4444);
		//Socket ns = new Socket("127.0.0.1", 4444);

		new ModifierT(s, 18, 3).start();
		
		//new ModifierT(s, 18, "Predo", "02/02/02","2673182", "Rodrigues", "Bresiulero", "nem sei").start();

		// }
		// s.close();
	}

}
