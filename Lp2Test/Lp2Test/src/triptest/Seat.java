package triptest;

import java.io.Serializable;

/**
 *
 * @author Miqueias
 */
public class Seat implements Serializable{

    private boolean purchased, inProcess, free;
    private Passageiro passageiro;

    public Seat() {
        purchased = false;
        inProcess = false;
        free = true;
        passageiro = new Passageiro();
        
    }
    
    public void setPurchased(){
        purchased = true;
        inProcess = false;
        free = false;
        
    }
    
    public synchronized void setInProcess(){
    	inProcess = true;
    	purchased = false;
        free = false;
        
    }
    
    public void setFree(){
        purchased = false;
        inProcess = false;
        free = true;
        
    }
    
    public boolean isPurchased(){
        return purchased;
    }
    
    public boolean isInProcess(){
        return inProcess;
    }
    
    public boolean isFree(){
        return free;
    }
    
    
    
    public void setPassageiro(Passageiro p){
        passageiro = p;
        
    }

    public Passageiro getPassageiro(){
        return passageiro;
    }
    
    
}