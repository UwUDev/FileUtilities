package me.uwu.fu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("UwU.fxml"));
        primaryStage.setTitle("File Utilities by UwU#0001");
        primaryStage.setScene(new Scene(root, 1270, 710));
        primaryStage.getScene().getStylesheets().add(String.valueOf(getClass().getResource("style.css")));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(1058);
        primaryStage.show();
        primaryStage.resizableProperty().set(true);
    }

    public static void main(String[] args) throws ParseException {
        test();
        launch(args);
    }

    public static void test() throws ParseException {
        File file = new File("a.gif");

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");

        // print the original Last Modified date
        System.out.println("Original Last Modified Date : "
                + dateFormat.format(file.lastModified()));

        // set this date
        String newLastModifiedString = "01/31/2021 10:13";

        // we have to convert the above date to milliseconds...
        Date newLastModifiedDate = dateFormat.parse(newLastModifiedString);
        file.setLastModified(newLastModifiedDate.getTime());

        // print the new Last Modified date
        System.out.println("Lastest Last Modified Date : "
                + dateFormat.format(file.lastModified()));
    }
}
