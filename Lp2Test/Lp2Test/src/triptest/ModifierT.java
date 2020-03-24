package triptest;

import java.io.*;
import java.net.*;


public class ModifierT extends Thread {
	
	ObjectInputStream input;
	ObjectOutputStream output; // 
	
	int idSeat; // O numero  do  assento
	int comando; // Comandos: 1 = setFree ; 2 = setInProcess ; 3 = setPurchase
	
	public ModifierT(Socket modifierSocket, int idSeat, int comando) throws IOException {
		input = new ObjectInputStream(modifierSocket.getInputStream());
		output = new ObjectOutputStream(modifierSocket.getOutputStream());
		this.idSeat = idSeat;
		this.comando = comando;
	}
	
	@Override
	public void run() {
		
		
		try {
			String s = "VLAAV";
			output.writeObject(s);
			Object read = input.readObject();
			if(read instanceof Seat[]) {
				Seat[] modfT = (Seat[]) read;
				switch(comando) {
					
				case 1: 
					modfT[idSeat].setFree();
					System.out.println(idSeat);
					break;
				case  2:
					modfT[idSeat].setInProcess();
					System.out.println(idSeat);
					break;
				case 3:
					modfT[idSeat].setPurchased();
					System.out.println(idSeat);
					break;
				}
				
				output.writeObject(modfT);
			}
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        Socket s = new Socket("127.0.0.1", 4444);
        
        
        	   new ModifierT(s, 0, 3).start();
           
        //}
        //s.close();
    }
	
	

}
