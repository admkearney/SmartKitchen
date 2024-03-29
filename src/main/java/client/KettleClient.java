package client;

import clientui.KettleUI;



/*
*  This Was Adapted from the project sample on moodle 
*/

public class KettleClient extends Client {
    
    private final String BOIL = "Boil";
    private boolean isBoiling = false;
    private final String POWER = "power"; // For determining if the kettle has power
    private boolean isOn = false; // 

    //constructor
    public KettleClient() {
        super();
        serviceType = "_kettle._udp.local.";
        ui = new KettleUI(this);
        name = "Kettle";
    }

       // Determing if the kettle has power or not. 
    
    public void power(){
        if(!isOn){
            isOn = true;
                ui.updateArea("Kettle has power.");
                
        }
        
        else {
            
            isOn = false;
            ui.updateArea("Kettle does not have power.");
            
        }
    }
    
    
    
    /**
     * This 
     */
    public void boil() {
        if (isOn == true) {
        if (!isBoiling) {
            String a = sendMessage(BOIL);
            if (a.equals(OK)) {
                isBoiling = true;
                ui.updateArea("Kettle is boiling");
            }
        } else {
            ui.updateArea("Kettle is already boiling");
        }
        } 
        else{
            
            ui.updateArea("Please turn the power on."); // User is told to turn on the power before the kettle boils
        }
    }
      // When the boiling process stops a message is displayed 
        
    @Override
    public void updatePoll(String msg) {
        if (msg.equals("Kettle is 100% boiled.")) {
            isBoiling = false;
            ui.updateArea("Kettle is finished boiling");
        }
    }
      
    
    // Disables the UI When you exit out
    @Override
    public void disable() {
        super.disable();
        ui = new KettleUI(this);
        isBoiling = false;
        isOn = false;
    }
}
