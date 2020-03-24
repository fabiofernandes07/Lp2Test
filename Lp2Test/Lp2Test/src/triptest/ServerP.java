package triptest;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

/**
 *
 * @author Miqueias
 */
public class ServerP {

        
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Plane plane = new Plane("Jacarepagua");
        Executor exec = Executors.newCachedThreadPool();
        ServerSocket s = new ServerSocket(4444);
        
        while (true) {
            Socket ns = s.accept();
            
            	exec.execute(new Sending(ns, plane));
        }
        //s.close();
    }

}
