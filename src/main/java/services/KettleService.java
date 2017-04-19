package services;

import java.util.Timer;
import java.util.TimerTask;
import com.google.gson.Gson;

import serviceui.ServiceUI;

/**
 * The Class KettleService.
 */
public class KettleService extends Service {

    private final Timer timer;
    private int percentHot;
    Gson gson = new Gson(); 
    

    public KettleService(String name) {
        super(name, "_kettle._udp.local.");
        timer = new Timer();
        percentHot = 0;
        ui = new ServiceUI(this, name);
    }

    @Override
    public void performAction(String a) {
        if (a.equals("get_status")) {
            sendBack(getStatus());
        } else if (a.equals("Boil")) {
            timer.schedule(new RemindTask(), 0, 2000);
            sendBack("OK");
            ui.updateArea("Boiling kettle");
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
        return gson.toJson("Kettle is " + percentHot + "% boiled.");
    }

    public static void main(String[] args) {
        new KettleService("Kettle");
    }
}

