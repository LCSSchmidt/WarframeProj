package DataTracker;


import Settings.DataBase;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InOutManager {
    BufferedReader bin;
    String worldData;
    DataBase dataBase;
    public InOutManager(){
        try {
            dataBase = new DataBase();
            this.bin = new BufferedReader(new InputStreamReader(dataBase.getUrl().openStream()));
        } catch (Exception e){
        }
    }
    
    public void dataGather() throws Exception{
        int bitlindo = -1;
        
        while(bitlindo != - 1){
            bitlindo = bin.read();
            worldData = Integer.toString(bitlindo);
        }
    }
    
    public String getAlerts(){
        String alerts = "";
        alerts = worldData.substring(worldData.indexOf("Alerts\":["), worldData.indexOf("\"]}}}]"));
        return alerts;
    }
    
    
}
