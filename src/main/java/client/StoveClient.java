package client;

import clientui.StoveUI;


public class StoveClient extends Client {
    
    private final String COOK = "Cook";
    private boolean isCooking = false;

    //constructor
    public StoveClient() {
        super();
        serviceType = "_stove._udp.local.";
        ui = new StoveUI(this);
        name = "Stove";
    }

    /**
     * sends a message to start the microwave
     */
    public void cook() {
        if (!isCooking) {
            String a = sendMessage(COOK);
            if (a.equals(OK)) {
                isCooking = true;
                ui.updateArea("Stove is on");
            }
        } else {
            ui.updateArea("Stove is already on");
        }
    }

    @Override
    public void updatePoll(String msg) {
        if (msg.equals("Stove is finished")) {
            isCooking = false;
            ui.updateArea("Stove done");
        }
    }

    @Override
    public void disable() {
        super.disable();
        ui = new StoveUI(this);
        isCooking = false;
    }
}

