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
        } else{
            ui.updateArea("Coffee Machine is already brewing");
        }
    }
    
    public void americano() {
        if (!isBrewing) {
            String a = sendMessage(AMERICANO);
            if (a.equals(OK)) {
                isBrewing = true;
                ui.updateArea("Coffee Machine ready to make Americano");
               
            }
        } else{
            ui.updateArea("Coffee Machine is already brewing");
        }
    }
    
    public void cappuccino() {
        if (!isBrewing) {
            String a = sendMessage(CAPPUCCINO);
            if (a.equals(OK)) {
                isBrewing = true;
                ui.updateArea("Coffee Machine ready to make Cappuccino");
               
            }
        } else{
            ui.updateArea("Coffee Machine is already brewing");
        }
    }

    @Override
    public void updatePoll(String msg) {
        //stop the machine once the final task of each of the methods is printed
        if (msg.equals("\"Current Task: Pouring Americano\"")||(msg.equals("\"Current Task: Pouring Latte\""))||(msg.equals("\"Current Task: Pouring Cappuccino\"")) ){
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


