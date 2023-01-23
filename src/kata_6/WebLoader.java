package kata_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
public class WebLoader {
    public String getFrom(String input) {
        URL url = this.getURL(input);
        try (InputStream inputStream = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder result = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) result.append((char) c);
            return result.toString();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    private URL getURL(String input) {
        URL url = null;
        try {
            url = new URL(input);
        } catch (MalformedURLException e) {
            e.getMessage();
        }
        return url;
    }
}