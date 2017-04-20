package services;

import java.util.Timer;
import java.util.TimerTask;
import com.google.gson.Gson;

import serviceui.ServiceUI;

/*
*  This Was Adapted from the project sample on moodle 
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
             
        } 
        
        else if (a.equals("Ignite1")) {
            timer.schedule(new RemindTask(), 0, 2000);
            sendBack("OK");
            ui.updateArea("Starting Hob 1");
        } 
        
        else if (a.equals("Ignite2")) {
            timer.schedule(new RemindTask2(), 0, 2000);
            sendBack("OK");
            ui.updateArea("Starting Hob 2");
        } 
        
        else if (a.equals("Ignite3")) {
            timer.schedule(new RemindTask3(), 0, 2000);
            sendBack("OK");
            ui.updateArea("Starting Hob 3");
        } 
        
        else if (a.equals("Ignite4")) {
            timer.schedule(new RemindTask4(), 0, 2000);
            sendBack("OK");
            ui.updateArea("Starting Hob 4");
        } 
        
        
        else {
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
               
        public String getStatus() 

        {
            return gson.toJson("Hob 1 is " + percentHot + "% finished.");
        }

    }
    
        class RemindTask2 extends TimerTask {

        @Override
        public void run() {
            if (percentHot < 100) {
                percentHot += 10;
                    
            }
        } 
               
        public String getStatus() 

        {
            return gson.toJson("Hob 2 is " + percentHot + "% finished.");
        }

    }
        
        class RemindTask3 extends TimerTask {

        @Override
        public void run() {
            if (percentHot < 100) {
                percentHot += 10;
                    
            }
        } 
               
        public String getStatus() 

        {
            return gson.toJson("Hob 3 is " + percentHot + "% finished.");
        }

    }
        
        class RemindTask4 extends TimerTask {

        @Override
        public void run() {
            if (percentHot < 100) {
                percentHot += 10;
                    
            }
        } 
               
        public String getStatus() 

        {
            return gson.toJson("Hob 4 is " + percentHot + "% finished.");
        }

    }
    
      
        public String getStatus() 

        {
            return gson.toJson("Hob 1 is " + percentHot + "% finished.");
        }

    
   
    public static void main(String[] args) {
        new StoveService("Stove");
    }
}






