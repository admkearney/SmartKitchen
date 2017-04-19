package client;

import clientui.MicrowaveUI;


public class MicrowaveClient extends Client {
    
    private final String COOK = "Cook";
    private final String DONT = "Dont";
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
    public void cook(String time) {
        if (!isCooking) {
            String a = sendMessage(COOK);
            if (a.equals(OK)) {
                isCooking = true;
                ui.updateArea("Microwave is on");
                ui.updateArea(time + "Seconds");
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
        ui = new MicrowaveUI(this);
        isCooking = false;
    }
}

