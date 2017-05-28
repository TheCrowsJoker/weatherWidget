
package IT6260_Assignment2_2161665;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUI extends Application{
        
//    Put the location in the parentheses for location based weather
    Weather weather = new Weather("upper-hutt");
    
    BorderPane root;
    TabPane tabPane;
    Tab tabToday;
    Tab tabTomorrow;
    Tab tabWeek;
    ScrollPane scrollPane;
    Scene scene;
    File file;
    String fileURI;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new BorderPane();  
        
//        Create tabpane and stop tabs from being closed
        tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        
//        Today tab
        tabToday = new Tab();
        tabToday.setText("Today");
        tabToday.setContent(weather.todaysWeather());

//        Tomorrow tab
        tabTomorrow = new Tab();       
        tabTomorrow.setText("Tomorrow");       
        tabTomorrow.setContent(weather.tomorrowsWeather());

//        Scrollpane for weeks tab
        scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setPrefSize(115, 500);
        
//        Weeks tab
        scrollPane.setContent(weather.weeksWeather());   
        tabWeek = new Tab();       
        tabWeek.setText("Week");       
        tabWeek.setContent(scrollPane);

//        Add tabs to tabPane
        tabPane.getTabs().addAll(tabToday, tabTomorrow, tabWeek); 

        root.setTop(tabPane);
        primaryStage.setResizable(false);
        scene = new Scene(root, 800, 545);

//        Add css file
        file = new File("src/IT6260_Assignment2_2161665/style.css");
        fileURI = file.toURI().toString();
        scene.getStylesheets().clear();
        scene.getStylesheets().add(fileURI);
        
//        Display
        primaryStage.setScene(scene);
        primaryStage.setTitle("Weather Widget");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
