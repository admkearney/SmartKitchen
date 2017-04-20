package client;

import clientui.StoveUI;


public class StoveClient extends Client {
    
    private final String IGNITE = "Ignite";
    private boolean isOn = false;

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
    public void Hob1() {
        if (!isOn) {
            String a = sendMessage(IGNITE);
            if (a.equals(OK)) {
                isOn = true;
                ui.updateArea("Hob 1 is on");
            }
        } else {
            ui.updateArea("Hob 1 is already on");
        }
    }
    

    @Override
    public void updatePoll(String msg) {
        if (msg.equals("Stove is finished")) {
            isOn = false;
            ui.updateArea("Stove done");
        }
    }

    @Override
    public void disable() {
        super.disable();
        ui = new StoveUI(this);
        isOn = false;
    }
}

