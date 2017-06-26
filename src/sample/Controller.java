package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class Controller{

    @FXML
    TextField textFieldLiczba1;

    @FXML
    TextField textFieldLiczba2;

    @FXML
    Label labWynik;

    @FXML
    Label labDzialanie;

    TextField currText = textFieldLiczba1;

    int dzialanie;

    public void changeCurrTextField(ActionEvent event){
        // currText - Brakuje mi dojścia do aktualnego TextFielda
        System.out.println("Działa");
    }

    public void printButtonOnTextField(ActionEvent event){
        if (currText == null){
            currText = textFieldLiczba1;
        }
//        Nie moge przypisac do currText - textFieldLiczba1
//        currText = textFieldLiczba1;
        String curr = currText.getText();
        String but = event.getSource().toString();
        String currButt = but.substring(14,15);
        currText.setText(curr+currButt);
    }

    public void dzielenie(){
        currText = textFieldLiczba2;
        labDzialanie.setText("/");
        dzialanie = 0;
    }
    public void mnozenie(){
        currText = textFieldLiczba2;
        labDzialanie.setText("*");
        dzialanie = 1;
    }
    public void odejmowanie(){
        currText = textFieldLiczba2;
        labDzialanie.setText("-");
        dzialanie = 2;
    }
    public void dodawanie(){
        currText = textFieldLiczba2;
        labDzialanie.setText("+");
        dzialanie = 3;
    }
    public void pierwiastkowanie(){
        currText = textFieldLiczba2;
        labDzialanie.setText("√");
        dzialanie = 4;
    }
    public void deleteAll() {
        textFieldLiczba1.setText("");
        textFieldLiczba2.setText("");
        labWynik.setText("");
        currText = textFieldLiczba1;
    }
    public void delete(){
        String currString = currText.getText();
        currText.setText(currString.substring(0,currString.length()-1));
    }
}
