package Settings;

import java.net.URL;

public class DataBase {
    static URL url;
    
    public DataBase() {
        try {
            url = new URL("http://content.warframe.com/dynamic/worldState.php");
        } catch (Exception e) {
        }
    }

    public static URL getUrl() {
        return url;
    }
}
