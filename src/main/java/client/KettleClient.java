package client;

import clientui.KettleUI;


public class KettleClient extends Client {
    
    private final String BOIL = "Boil";
    private boolean isBoiling = false;

    //constructor
    public KettleClient() {
        super();
        serviceType = "_kettle._udp.local.";
        ui = new KettleUI(this);
        name = "Kettle";
    }

    /**
     * sends a message to warm the bed.
     */
    public void boil() {
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

    @Override
    public void updatePoll(String msg) {
        if (msg.equals("Kettle is 100% boiled.")) {
            isBoiling = false;
            ui.updateArea("Kettle is finished boiling");
        }
    }

    @Override
    public void disable() {
        super.disable();
        ui = new KettleUI(this);
        isBoiling = false;
    }
}
