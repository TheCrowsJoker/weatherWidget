
package myPackage;

import java.util.Arrays;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



/**
 *
 * @author liam.sharpe
 */
public class MainScreen extends Application {
    Label welcome;
    Button tab1;
    Button tab2;
    Button tab3;
    Label screenID;    

    @Override
    public void start(Stage primaryStage) throws Exception {
        welcome = new Label("Welcome to the weather and train app");
        tab1 = new Button("Weather");
        tab2 = new Button("Trains");
        tab3 = new Button("Other");
        screenID = new Label("Weather");
        
        //Setup grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        //Add components
        grid.add(welcome, 0, 0, 3, 1);
        grid.add(tab1, 0, 1);
        grid.add(tab2, 1, 1);
        grid.add(tab3, 2, 1);
        grid.add(screenID, 1, 2, 3, 1);
        
        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
