
package myPackage;

import java.io.InputStreamReader;
import java.net.URL;
import com.google.gson.Gson;
import java.io.File;
import java.util.List;

import javafx.application.*;
import java.text.*;
import java.util.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.stage.*;
import javafx.scene.control.TabPane.TabClosingPolicy;

public class WeatherWidget extends Application{
    
    @Override
    public void start(Stage stage) throws Exception{
        
//        To change the location, uncomment the one you would like and comment the others
//        Upper Hutt
        URL url = new URL("http://www.metservice.com/publicData/localForecastupper-hutt");
        
//        Lower Hutt
//        URL url = new URL("http://www.metservice.com/publicData/localForecastlower-hutt");

//        Wellington
//        URL url = new URL("http://www.metservice.com/publicData/localForecastwellington");

        InputStreamReader reader = new InputStreamReader(url.openStream());
        Metservice metservice = new Gson().fromJson(reader, Metservice.class);

//        for (Days d : metservice.days) {
//            System.out.println(d.dow + " " + d.date);
//            System.out.println("High: " + d.max + "\u00b0  Low: " + d.min + "\u00b0");
//            System.out.println(d.forecast);
//            System.out.println();
//        }

        BorderPane root = new BorderPane();
        
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        
//        Today view
        Tab tabToday = new Tab();
        tabToday.setText("Today");
        tabToday.setContent(
            new Label(
                "Today's Weather \n\n" +
                metservice.days.get(0).dow + " " + metservice.days.get(0).date + "\n" +  
                "High: " + metservice.days.get(0).max + "\u00b0 " +
                "Low: " + metservice.days.get(0).min + "\u00b0 \n" +
                metservice.days.get(0).forecast
            )
        );
        
//        Tomorrow view
        Tab tabTomorrow = new Tab();       
        tabTomorrow.setText("Tomorrow");       
        tabTomorrow.setContent(
            new Label(
                metservice.days.get(1).dow + " " + metservice.days.get(1).date + "\n" +  
                "High: " + metservice.days.get(1).max + "\u00b0 " +
                "Low: " + metservice.days.get(1).min + "\u00b0 \n" +
                metservice.days.get(1).forecast
            )               
        );
        
//        Week view
        Label weekLabel = new Label();        
        for (int i = 0; i < 7; i++) {
            weekLabel.setText(
                weekLabel.getText() +
                metservice.days.get(i).dow + " " + metservice.days.get(i).date + "\n" +  
                "High: " + metservice.days.get(i).max + "\u00b0 " +
                "Low: " + metservice.days.get(i).min + "\u00b0 \n" +
                metservice.days.get(i).forecast +  "\n \n"
            );
        }       
        Tab tabWeek = new Tab();       
        tabWeek.setText("Week");       
        tabWeek.setContent(weekLabel);
        
//        Add tabs to tabPane
        tabPane.getTabs().addAll(tabToday, tabTomorrow, tabWeek);
 
        Label footer = new Label("Developed by Liam Sharpe (2161665) - Data provided by metservice");
        
        root.setTop(tabPane);
        root.setBottom(footer);
        
        Scene scene = new Scene(root, 700, 800);

//        Add css file
        File f = new File("src/myPackage/style.css");
        String fileURI = f.toURI().toString();
        scene.getStylesheets().clear();
        scene.getStylesheets().add(fileURI);
        
        stage.setScene(scene);
        stage.setTitle("Title");
        stage.show();
      }

    public static void main(String[] args) throws Exception {       
        launch(args);
    }

    private static class Metservice {
        String _usage;
        List<Days> days;
    }
    
    private static class Days {
        String date;
        String dow;
        int max;
        int min;
        String forecast;
    }
}