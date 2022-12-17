package ca.durhamcollege.oop3200f2021javalab5;

// Name : Valentine Sah
// Student ID : 100757000
// Date : December 16, 2022
// File : MainController.java

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MainController
{

    @FXML
    public void initialize()
    {
        GridPane gridPane = new GridPane();
        // Add other nodes to the grid pane
        Scene scene = new Scene(gridPane, 420, 240);
        // Set the scene on the stage

        heightField.setPromptText("Enter height in inches");
        String height = heightField.getText();

        weightField.setPromptText("Enter weight in pounds");

        heightField.setOnKeyReleased(event ->
        {
            String text = heightField.getText();
            if (text.startsWith("-"))
            {
                heightField.setText("");
            }
        });

        weightField.setOnKeyReleased(event ->
        {
            String text = weightField.getText();
            if (text.startsWith("-"))
            {
                weightField.setText("");
            }
        });
    }

    @FXML
    private TextField heightField;

    @FXML
    private TextField weightField;

    @FXML
    private TextField bmiField;

    @FXML
    protected void onCalculateBMIClick()
    {
        String weightString = weightField.getText();

        if (weightString.isEmpty())
        {
            // Show an error message
            bmiField.setText("Please enter a weight.");
            return;
        }

        double weight = Double.parseDouble(weightString);

        String heightString = heightField.getText();
        if (heightString.isEmpty())
        {
            // Show an error message
            bmiField.setText("Please enter a height.");
            return;
        }

        double height = Double.parseDouble(heightString);

        double bmi = (weight / (height * height)) * 703;

        bmiField.setText(String.format("%.1f", bmi));

        if (bmi < 18.5)
        {
            bmiCategoryLabel.setText("You are UNDERWEIGHT");
        }
        else if (bmi < 25.0)
        {
            bmiCategoryLabel.setText("You are a NORMAL WEIGHT");
        }
        else if (bmi < 30.0)
        {
            bmiCategoryLabel.setText("You are OVERWEIGHT");
        }
        else
        {
            bmiCategoryLabel.setText("You are OBESE");
        }
    }

    @FXML
    private Label bmiCategoryLabel;
}