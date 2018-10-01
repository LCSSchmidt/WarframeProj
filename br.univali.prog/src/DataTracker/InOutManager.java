package DataTracker;


import Settings.DataBase;
import WFExceptions.DTDataGatherException;
import WFExceptions.DTGettingAlertsException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class InOutManager {
    BufferedReader bin;
    String worldData;
    DataBase dataBase;
    public InOutManager(){
        try {
            dataBase = new DataBase();
            this.bin = new BufferedReader(new InputStreamReader(dataBase.getUrl().openStream()));
        } catch (Exception e){
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
        worldData = "";
    }
    
    public void dataGather() throws DTDataGatherException{
        int bitlindo = -1;
        try {
            do{
                bitlindo = bin.read();
                if(bitlindo != -1){
                worldData += String.valueOf((char)bitlindo);
                }
            }while(bitlindo >= 0);
            bin.close();
        } catch (Exception e) {
            throw new DTDataGatherException();
        }
    }
    
    public String getAlerts()throws DTGettingAlertsException{
        String alerts = "";
        try {
            alerts = worldData.substring(worldData.indexOf("Alerts\":["), worldData.indexOf("}}]"));
        } catch (Exception e) {
            throw new DTGettingAlertsException();
        }
        return alerts;
    }
    
    
}
