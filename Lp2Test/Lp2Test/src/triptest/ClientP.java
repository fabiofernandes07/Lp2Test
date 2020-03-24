package triptest;

import java.io.*;
import java.net.*;

/**
 *
 * @author Miqueias
 */
public class ClientP {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Plane plane = new Plane("Jacarepagua");
        Socket s = new Socket("127.0.0.1", 4444);
        
        
        
           new Receiver(s).start();
           
           
    }

}
