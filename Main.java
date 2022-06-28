import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException
    {
        //printTime();
        //getMyIp();
        waitTimeout();
    }

    private static void waitTimeout() throws InterruptedException
    {
        long checkedtimes=0;
        long start=System.currentTimeMillis();
        while(true)
        {
            Thread.sleep(1000);
            
            long now=System.currentTimeMillis();
            if(now-start>1000*60*60*2)
            {
                System.out.println("good hold, 2 hrs passed, checked times="+checkedtimes);
                return;
            }
            checkedtimes++;
        }
    }

    private static void printTime()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS");
        LocalDateTime systime=LocalDateTime.parse("2022-06-21 14:46:38.80", formatter);

        System.out.println(systime.toString());
    }

    private static void getMyIp() throws IOException
    {
        java.net.URL url = new java.net.URL("https://www.whatismyip.com");
        java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();

        java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(connection.getInputStream()));
        String inputLine;

        int len=0;
        while ((inputLine = in.readLine()) != null) 
            len+=inputLine.length();
        in.close();

        System.out.println(len);
    }
}
