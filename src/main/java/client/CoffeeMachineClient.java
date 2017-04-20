package client;

import clientui.CoffeeMachineUI;

/**
 * Adapted from the Project Sample on Moodle
 */
public class CoffeeMachineClient extends Client {
    
    private final String LATTE = "Latte";
    private final String AMERICANO = "Americano";
    private final String CAPPUCCINO = "Cappuccino";
    
    private boolean isBrewing = false;

    //constructor
    public CoffeeMachineClient() {
        super();
        serviceType = "_coffeemachine._udp.local.";
        ui = new CoffeeMachineUI(this);
        name = "CoffeeMachine";
    }

   //methods for each type of coffee
    public void latte() {
        if (!isBrewing) {
            String a = sendMessage(LATTE);
            if (a.equals(OK)) {
                isBrewing = true;
                ui.updateArea("Coffee Machine ready to make Latte");
               
            }
        } 
    }
    
    public void americano() {
        if (!isBrewing) {
            String a = sendMessage(AMERICANO);
            if (a.equals(OK)) {
                isBrewing = true;
                ui.updateArea("Coffee Machine ready to make Americano");
               
            }
        } 
    }
    
    public void cappuccino() {
        if (!isBrewing) {
            String a = sendMessage(CAPPUCCINO);
            if (a.equals(OK)) {
                isBrewing = true;
                ui.updateArea("Coffee Machine ready to make Cappuccino");
               
            }
        } 
    }

    @Override
    public void updatePoll(String msg) {
        if (msg.equals("Coffee Machine is finished")) {
            isBrewing = false;
            ui.updateArea("Coffee Machine done");
        }
    }

    @Override
    public void disable() {
        super.disable();
        ui = new CoffeeMachineUI(this);
        isBrewing = false;
    }
}


