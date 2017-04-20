package client;

import clientui.StoveUI;


public class StoveClient extends Client {
    
    private final String IGNITE1 = "Ignite1";
    private final String IGNITE2 = "Ignite2";
    private final String IGNITE3 = "Ignite3";
    private final String IGNITE4 = "Ignite4";
  
    
    private boolean isOn = false;

    //constructor
    public StoveClient() {
        super();
        serviceType = "_stove._udp.local.";
        ui = new StoveUI(this);
        name = "Stove";
    }

    /**
     * sends a message to start the the hob
     */
    public void Hob1() {
        if (!isOn) {
            String a = sendMessage(IGNITE1);
            if (a.equals(OK)) {
                isOn = true;
                ui.updateArea("Hob 1 is on");
            }
        } else {
            ui.updateArea("Hob 1 is already on");
        }
    }
    
    public void Hob2() {
        if (!isOn) {
            String b = sendMessage(IGNITE2);
            if (b.equals(OK)) {
                isOn = true;
                ui.updateArea("Hob 2 is on");
            }
        } else {
            ui.updateArea("Hob 2 is already on");
        }
    }
        
    public void Hob3() {
        if (!isOn) {
            String c = sendMessage(IGNITE3);
            if (c.equals(OK)) {
                isOn = true;
                ui.updateArea("Hob 3 is on");
            }
        } else {
            ui.updateArea("Hob 3 is already on");
        }
    }
            
    public void Hob4() {
        if (!isOn) {
            String d = sendMessage(IGNITE4);
            if (d.equals(OK)) {
                isOn = true;
                ui.updateArea("Hob 4 is on");
            }
        } else {
            ui.updateArea("Hob 4 is already on");
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

