package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.GridPane;
import sample.doWork;

/***********************************************************************************************************************
 * Author: Hadrian Buckner
 * Program: Tip Calculator
 * Date: Saturday October 15th 2017
 * Version 1.1
 */

public class Main extends Application {
    double test1 = 5;
    double test2 = 6;
    static double userInput;
    String tip;
    double newTip;
    static double newTotal;
    static double tip1 = .15;
    static double tip2 = .20;
    static double tip3 = .25;
    Stage window;
    ToggleButton RadioButton;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    static Label answerLabel = new Label("");
    final ToggleGroup group = new ToggleGroup();
    Button button;


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Tip Calculator");
        GridPane grid = new GridPane();
        GridPane grid2 = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);
        Scene scene1, scene2;
        doWork doWork = new doWork();

        //First scene

        //Bill amount label
        GridPane.setConstraints(answerLabel, 1, 7);
        Label nameLabel = new Label("Bill amount");
        GridPane.setConstraints(nameLabel, 0, 0);

        //bill amount input

        TextField billAmount = new TextField("0.00");
        GridPane.setConstraints(billAmount, 1, 0);

        //button 15%

        RadioButton rb1 = new RadioButton();
        rb1.setText("15%");
        GridPane.setConstraints(rb1, 1, 2);
        rb1.setToggleGroup(group);
        // rb1.setSelected(true);
        rb1.setUserData(tip1);

        //button 20%

        RadioButton rb2 = new RadioButton();
        rb2.setText("20%");
        GridPane.setConstraints(rb2, 1, 3);
        rb2.setToggleGroup(group);
        rb2.setUserData(tip2);

        //button 25%
        RadioButton rb3 = new RadioButton();
        rb3.setText("25%");
        GridPane.setConstraints(rb3, 1, 4);
        rb3.setToggleGroup(group);
        rb3.setUserData(tip3);

        //calculate
        button = new Button("calculate");
        GridPane.setConstraints(button, 1, 6);
        //button.setOnAction(e->isDouble(billAmount, billAmount.getText()),scene2);


        //add to scene
        grid.getChildren().addAll(nameLabel, billAmount, rb1, rb2, rb3, answerLabel, button);
        scene1 = new Scene(grid, 300, 200);
        window.setScene(scene1);
        window.show();
        //search for radio button pressed
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle toggle, Toggle new_toggle) {
                if (group.getSelectedToggle() != null) {
                    tip = group.getSelectedToggle().getUserData().toString();
                    newTip = Double.parseDouble(tip);

                }
            }
        });
        //button actions
        button.setOnAction(e -> {
            isDouble(billAmount, billAmount.getText());
            newTotal = doWork.Total(userInput, newTip);
            answerLabel.setText("your total is $" +Double.toString(newTotal));
        });

    }

    public boolean isDouble(TextField input, String message) {
        try {
            userInput = Double.parseDouble(message);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("not a double");
            return false;
        }
    }

}
