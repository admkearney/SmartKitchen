package client;

import clientui.MicrowaveUI;


public class MicrowaveClient extends Client {
    
    private final String COOK = "Cook";
    private boolean isCooking = false;

    //constructor
    public MicrowaveClient() {
        super();
        serviceType = "_microwave._udp.local.";
        ui = new MicrowaveUI(this);
        name = "Microwave";
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
        } else {
            ui.updateArea("Microwave is already on");
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
        ui = new MicrowaveUI(this);
        isCooking = false;
    }
}

