package com.university.ta;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    public TextField numberField;
    @FXML
    public TextArea numbersArea;

    public void onFindPrimeFactorsClick(ActionEvent actionEvent) {
        numbersArea.clear();
        int number = Integer.parseInt(numberField.getText());
        AlgorithmRealization.printPrimeFactors(number, numbersArea);
    }
}