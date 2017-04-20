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
    public void Hob1() {
        if (!isCooking) {
            String a = sendMessage(COOK);
            if (a.equals(OK)) {
                isCooking = true;
                ui.updateArea("Hob 1 is on");
            }
        } else {
            ui.updateArea("Hob 1 is already on");
        }
    }
    
        public void Hob2() {
        if (!isCooking) {
            String a = sendMessage(COOK);
            if (a.equals(OK)) {
                isCooking = true;
                ui.updateArea("Hob 2 is on");
            }
        } else {
            ui.updateArea("Hob 2 is already on");
        }
    }
        
            public void Hob3() {
        if (!isCooking) {
            String a = sendMessage(COOK);
            if (a.equals(OK)) {
                isCooking = true;
                ui.updateArea("Hob 3 is on");
            }
        } else {
            ui.updateArea("Hob 3 is already on");
        }
    }
            
                public void Hob4() {
        if (!isCooking) {
            String a = sendMessage(COOK);
            if (a.equals(OK)) {
                isCooking = true;
                ui.updateArea("Hob 4 is on");
            }
        } else {
            ui.updateArea("Hob 4 already on");
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

