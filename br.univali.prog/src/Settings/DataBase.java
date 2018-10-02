package Settings;

import WFExceptions.STConstantURLException;
import java.net.URL;

public class DataBase {
    URL url;
    
    public DataBase() throws STConstantURLException{
        try {
            this.url = new URL(Constants.URL);    
        } catch (Exception e) {
            throw new STConstantURLException();
        }
        
    }
    
    public URL getUrl(){
        return url;
    }
}
