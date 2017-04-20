package services;

import java.util.Timer;
import java.util.TimerTask;
import com.google.gson.Gson;

import serviceui.ServiceUI;

/**
 * Adapted from the Project Sample on Moodle
 */
public class CoffeeMachineService extends Service {

    private final Timer timer;
    private int progress;
    private String task;
    Gson gson = new Gson(); 
    
    public CoffeeMachineService(String name) {
        super(name, "_coffeemachine._udp.local.");
        timer = new Timer();
        progress = 0;
        task = "";    
        ui = new ServiceUI(this, name);
    }

    @Override
    public void performAction(String a) {
        if (a.equals("get_status")) {
            sendBack(getStatus());    
        } else if (a.equals("Latte")) {
            ui.updateArea("Making Latte");
            timer.schedule(new RemindTaskLatte(), 0, 14000);
            sendBack("OK");
        } else if (a.equals("Americano")){ 
            ui.updateArea("Making Americano");
            timer.schedule(new RemindTaskAmericano(), 0, 14000);
            sendBack("OK");
        } else if (a.equals("Cappuccino")){
            ui.updateArea("Making Cappuccino");
            timer.schedule(new RemindTaskCappuccino(), 0, 14000);
            sendBack("OK");
        } else {
            sendBack(BAD_COMMAND + " - " + a);
        }
    }

    class RemindTaskLatte extends TimerTask {

        @Override
        public void run() {
            //change the task as the progress continues 
            if (progress < 20){
                task = "Grinding Coffee Beans";
                ui.updateArea("Added Task:" + task);
                progress += 20;
            } else if(progress < 40){
                task = "Heating Water";
                ui.updateArea("Added Task:" + task);
                progress += 20;
            } else if(progress < 60){
                task = "Brewing Coffee";
                ui.updateArea("Added Task:" + task);
                progress += 20;
            } else if(progress < 80){
                task = "Adding Milk";
                ui.updateArea("Added Task:" + task);
                progress += 20;
            } else if(progress < 100){
                task = "Pouring Latte";
                ui.updateArea("Added Task:" + task);
                progress += 25;
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
    
    class RemindTaskCappuccino extends TimerTask {

        @Override
        public void run() {
            if (progress < 20){
                task = "Grinding Coffee Beans";
                ui.updateArea("Added Task:" + task);
                progress += 20;
            } else if(progress < 40){
                task = "Heating Water";
                ui.updateArea("Added Task:" + task);
                progress += 20;
            } else if(progress < 60){
                task = "Brewing Coffee";
                ui.updateArea("Added Task:" + task);
                progress += 20;
            } else if(progress < 80){
                task = "Adding Foam";
                ui.updateArea("Added Task:" + task);
                progress += 20;
            } else if(progress < 100){
                task = "Pouring Latte";
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



