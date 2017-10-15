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


public class Main extends Application  {
    double userInput;
    String tip;
    double newTip;
    static double tip1=.15;
   static double tip2=.20;
   static double tip3=.25;
    Stage window;
    ToggleButton RadioButton;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;

    final ToggleGroup group = new ToggleGroup();


    Button button;




    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("Tip Calculator");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);


        //Bill amount label

        Label nameLabel = new Label("Bill amount");
        GridPane.setConstraints(nameLabel,0,0);

        //bill amount input

        TextField billAmount = new TextField("0.00");
        GridPane.setConstraints(billAmount,1,0);

        //button 15%

        RadioButton rb1 = new RadioButton();
        rb1.setText("15%");
        GridPane.setConstraints(rb1,1,2);
        rb1.setToggleGroup(group);
       // rb1.setSelected(true);
        rb1.setUserData(tip1);

        //button 20%

       RadioButton rb2 = new RadioButton();
        rb2.setText("20%");
        GridPane.setConstraints(rb2,1,3);
        rb2.setToggleGroup(group);
        rb2.setUserData(tip2);

        //button 25%
        RadioButton rb3 = new RadioButton();
        rb3.setText("25%");
        GridPane.setConstraints(rb3,1,4);
        rb3.setToggleGroup(group);
        rb3.setUserData(tip3);

        //calculate
        button = new Button("calculate");
        GridPane.setConstraints(button,1,6);
        button.setOnAction(e->isDouble(billAmount, billAmount.getText()));


        //add to scene
        grid.getChildren().addAll(nameLabel,billAmount,rb1,rb2,rb3,button);
        Scene scene=new Scene(grid,300,200);
        window.setScene(scene);
        window.show();



        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle toggle, Toggle new_toggle) {
                if (group.getSelectedToggle() != null) {
                    tip = group.getSelectedToggle().getUserData().toString();
                    newTip = Double.parseDouble(tip);

                }
            }
        });

    }

public boolean isDouble(TextField input, String message){
        try{
            double userInput = Double.parseDouble(message);

            System.out.println(Total(userInput,newTip));
            return true;
        }

        catch(NumberFormatException e)
                {
                    System.out.println("not a double");
                    return false;
                }

}
    public double Total(double payment, double tip){
        double newTotal = (payment*tip)+payment;
        System.out.println(newTotal);
        return newTotal;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
