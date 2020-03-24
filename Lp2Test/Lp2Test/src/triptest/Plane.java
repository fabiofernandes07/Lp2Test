package triptest;


import java.io.*;
import javax.swing.JFrame;
import java.util.Scanner;

/**
 *
 * @author Miqueias
 */
public class Plane implements Serializable {

    private Seat[] seats;
    private String destino;

    public Plane(String destino) {
        seats = new Seat[20];
        this.destino = destino;
        for (int i = 0; i < seats.length; i++) {
        	seats[i] = new Seat();
                
        }

    }

    

    public String getDestino() {
        return destino;
    }

    public Seat[] getSeats() {
        return seats;
    }
    
    public void setSeats(Seat[] nSeats) {
    	
    	seats =  nSeats;
    	
    }


}
