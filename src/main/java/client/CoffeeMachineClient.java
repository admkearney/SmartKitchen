package client;

import clientui.CoffeeMachineUI;


public class CoffeeMachineClient extends Client {
    
    private final String COOK = "Cook";
    
    private boolean isCooking = false;

    //constructor
    public CoffeeMachineClient() {
        super();
        serviceType = "_coffeemachine._udp.local.";
        ui = new CoffeeMachineUI(this);
        name = "CoffeMachine";
    }

    /**
     * sends a message to start the microwave
     */
    public void cook() {
        if (!isCooking) {
            String a = sendMessage(COOK);
            if (a.equals(OK)) {
                isCooking = true;
                ui.updateArea("Microwave is on");
               
            }
        } 
    }

    @Override
    public void updatePoll(String msg) {
        if (msg.equals("Microwave is finished")) {
            isCooking = false;
            ui.updateArea("Microwave done");
        }
    }

    @Override
    public void disable() {
        super.disable();
        ui = new CoffeeMachineUI(this);
        isCooking = false;
    }
}


