package me.uwu.fu.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import me.uwu.fu.utils.FileUtilities;
import me.uwu.fu.utils.WebUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Controller {

    public static Controller instance;

    public ScrollPane scrollOptn;
    public AnchorPane controls;
    public Label optionNone;

    public JFXButton dateButton;
    public JFXButton option2Button;
    public JFXButton option3Button;
    public JFXButton option4Button;
    public JFXButton option5Button;
    public JFXButton option6Button;
    public JFXButton option7Button;
    public JFXButton option8Button;

    public JFXDatePicker datePicker;
    public JFXTimePicker timePicker;


    public void credits(MouseEvent mouseEvent) throws URISyntaxException {
        WebUtils.openWebpage(new URI("https://github.com/UwUDev"));
    }

    public void loadDate(MouseEvent mouseEvent) {
        clear();
        optionNone.setVisible(false);

        datePicker = new JFXDatePicker(FileUtilities.getFileDate("a.gif"));
        datePicker.setDefaultColor(Color.web("#870fff"));
        controls.getChildren().add(datePicker);

        timePicker= new JFXTimePicker(LocalTime.now());
        timePicker.setIs24HourView(true);
        timePicker.setLayoutY(40);
        timePicker.setDefaultColor(Color.web("#870fff"));
        controls.getChildren().add(timePicker);
    }

    public void clear(){
        controls.getChildren().clear();
    }

    public void loadOption2(MouseEvent mouseEvent) {
        clear();
    }

    public void loadOption3(MouseEvent mouseEvent) {
        clear();
    }

    public void loadOption4(MouseEvent mouseEvent) {
        clear();
    }

    public void loadOption5(MouseEvent mouseEvent) {
        clear();
    }

    public void loadOption6(MouseEvent mouseEvent) {
        clear();
    }

    public void loadOption7(MouseEvent mouseEvent) {
        clear();
    }

    public void loadOption8(MouseEvent mouseEvent) {
        clear();
    }

    public void onSave(MouseEvent mouseEvent) throws ParseException {
        LocalDate localDate = datePicker.getValue();
        System.out.println(localDate);
        FileUtilities.editFileDate("a.gif", datePicker.getValue().toString(), timePicker.getValue().toString());
    }
}
