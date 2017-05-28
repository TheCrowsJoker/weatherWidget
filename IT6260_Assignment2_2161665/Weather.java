
package IT6260_Assignment2_2161665;

import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.URL;
import javafx.scene.control.Label;

public class Weather {
    
    private String tempURL;
    private URL url;
    private InputStreamReader reader;
    private Metservice metservice;
        
    public Weather(String city)  {        
        try {
            tempURL = "http://www.metservice.com/publicData/localForecast" + city;
            url = new URL(tempURL);      
            reader = new InputStreamReader(url.openStream());
            metservice = new Gson().fromJson(reader, Metservice.class);
        } catch(Exception e) {
            System.out.println("\n\n\nIncorrect city entered or unable to connect to the internet\n\n\n");
        }
    }       
    
    public Label todaysWeather() {
        return new Label(
            "Today's Weather \n\n" +
            metservice.days.get(0).dow + " " + metservice.days.get(0).date + "\n" +  
            "High: " + metservice.days.get(0).max + "\u00b0 " +
            "Low: " + metservice.days.get(0).min + "\u00b0 \n" +
            metservice.days.get(0).forecast
        );
    }
    
    public Label tomorrowsWeather() {
        return new Label(
            "Tomorrow's Weather \n\n" +
            metservice.days.get(1).dow + " " + metservice.days.get(1).date + "\n" +  
            "High: " + metservice.days.get(1).max + "\u00b0 " +
            "Low: " + metservice.days.get(1).min + "\u00b0 \n" +
            metservice.days.get(1).forecast
        );
    }
    
    public Label weeksWeather() {
        Label weekLabelContent = new Label("This week's Weather \n\n");        
        for (int i = 0; i < 7; i++) {
            weekLabelContent.setText(
                weekLabelContent.getText() +
                metservice.days.get(i).dow + " " + metservice.days.get(i).date + "\n" +  
                "High: " + metservice.days.get(i).max + "\u00b0 " +
                "Low: " + metservice.days.get(i).min + "\u00b0 \n" +
                metservice.days.get(i).forecast +  "\n\n"
            );
        }
        return weekLabelContent;
    }
}
