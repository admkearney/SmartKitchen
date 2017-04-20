package services;

import java.util.Timer;
import java.util.TimerTask;
import com.google.gson.Gson;

import serviceui.ServiceUI;

/**
 * The Class StoveService.
 */
public class StoveService extends Service {

    private final Timer timer;
    private int percentHot;
    Gson gson = new Gson();

    public StoveService(String name) {
        super(name, "_stove._udp.local.");
        timer = new Timer();
        percentHot = 0;
        ui = new ServiceUI(this, name);
    }

    @Override
    public void performAction(String a) {
        if (a.equals("get_status")) {
            sendBack(getStatus());
        } else if (a.equals("Ignite")) {
            timer.schedule(new RemindTask(), 0, 2000);
            sendBack("OK");
            ui.updateArea("Starting Hob");
        } else {
            sendBack(BAD_COMMAND + " - " + a);
        }
    }

    class RemindTask extends TimerTask {

        @Override
        public void run() {
            if (percentHot < 100) {
                percentHot += 10;
            }
        }
    }

    @Override
    public String getStatus() {
        return gson.toJson("Hob is " + percentHot + "% finished.");
    }
    
    
    
    public static void main(String[] args) {
        new StoveService("Stove");
    }
}






