import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException
    {
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS");
        //LocalDateTime systime=LocalDateTime.parse("2022-06-21 14:46:38.80", formatter);

        //System.out.println(systime.toString());

        java.net.URL url = new java.net.URL("http://www.whatismyip.com");
        java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", 
        "application/x-www-form-urlencoded");

        connection.setRequestProperty("Content-Length", Integer.toString(0));
        connection.setRequestProperty("Content-Language", "en-US");  

        connection.setUseCaches(false);
        connection.setDoOutput(true);

        //Send request
        java.io.DataOutputStream wr = new java.io.DataOutputStream (connection.getOutputStream());
        wr.writeBytes("");
        wr.close();

        //Get Response  
        java.io.InputStream is = connection.getInputStream();
        java.io.BufferedReader rd = new java.io.BufferedReader(new java.io.InputStreamReader(is));
        StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
        String line;
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();

        System.out.println(response.length());
    }
}
