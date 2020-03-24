package triptest;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miqueias
 */
public class Sending extends Thread{
    ObjectInputStream input;   // comunicaçãos
    ObjectOutputStream output; // bidirecional
    
    Plane plane;
    
    
    public Sending(Socket socketServer, Plane plane) throws IOException, ClassNotFoundException {
        
        output = new ObjectOutputStream(socketServer.getOutputStream());
        input = new ObjectInputStream(socketServer.getInputStream());
        this.plane = plane;
        

    }
        
    @Override
    public void run() {
        while(true){
        try {
            
        	Object mod = input.readObject();
			if(mod instanceof Seat[]) {
	        	Seat[] sts = (Seat[]) mod;
	        	plane.setSeats(sts);
	        }
			else if(mod instanceof String) {
				String s = (String) mod;
				System.out.println(s);
			}
            
        	output.writeObject(plane.getSeats());
            
            
        } catch (IOException ex) {
            //Logger.getLogger(Sending.class.getName()).log(Level.SEVERE, null, ex);
            break;
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        
		
        
       
        
        
        
        
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Sending.class.getName()).log(Level.SEVERE, null, ex);
//        }
        

    }
    }
    
}