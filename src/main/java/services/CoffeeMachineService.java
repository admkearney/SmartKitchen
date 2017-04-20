package services;

import java.util.Timer;
import java.util.TimerTask;
import com.google.gson.Gson;

import serviceui.ServiceUI;

/**
 * 
 */
public class CoffeeMachineService extends Service {

    private final Timer timer;
    private int progress;
    private String task, task2;
    Gson gson = new Gson(); 
    

    public CoffeeMachineService(String name) {
        super(name, "_coffeemachine._udp.local.");
        timer = new Timer();
        progress = 0;
        task = "";
        task2 ="";
        
        ui = new ServiceUI(this, name);
    }

    @Override
    public void performAction(String a) {
        if (a.equals("get_status")) {
            sendBack(getStatus());
        } else if (a.equals("Latte")) {
            timer.schedule(new RemindTask(), 0, 2000);
            sendBack("OK");
            ui.updateArea("Making Latte");
        } else if (a.equals("Americano")){ 
            timer.schedule(new RemindTaskAmericano(), 0, 14000);
            sendBack("OK");
            ui.updateArea("Making Americano");
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
    
    class RemindTaskAmericano extends TimerTask {

        @Override
        public void run() {
            if (progress < 25){
                task = "Grinding Coffee Beans";
                ui.updateArea("Added Task:" + task);
                progress += 25;
            } else if(progress < 50){
                task = "Heating Water";
                ui.updateArea("Added Task:" + task);
                progress += 25;
            } else if(progress < 75){
                task = "Brewing Coffee";
                ui.updateArea("Added Task:" + task);
                progress += 25;
            } else if(progress < 100){
                task = "Pouring Americano";
                ui.updateArea("Added Task:" + task);
                progress += 25;
            }
            
        }
    }

    @Override
    public String getStatus() {
            
        return gson.toJson("Current Task: " + task);
        
    }

    public static void main(String[] args) {
        new CoffeeMachineService("CoffeeMachine");
    }
}



