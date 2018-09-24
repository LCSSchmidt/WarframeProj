package Settings;

import java.net.URL;

public class DataBase {
    URL url;
    
    public DataBase() {
        try {
            String url = Constants.URL;
        } catch (Exception e) {
        }
    }
    
    public URL getUrl(){
        return url;
    }
}
