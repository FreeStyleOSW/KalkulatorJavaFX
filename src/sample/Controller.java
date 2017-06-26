package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


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

    int numDzialania;

    public void changeCurrTextField(ActionEvent event){
        // currText - Brakuje mi dojścia do aktualnego TextFielda
        System.out.println("Działa");
    }

    public void printButtonOnTextField(ActionEvent event){
        if (currText == null){
            currText = textFieldLiczba1;
        }
        String curr = currText.getText();
        String but = event.getSource().toString();
        String currButt = but.substring(14,15);
        currText.setText(curr+currButt);
    }

    public void dzielenie(){
        currText = textFieldLiczba2;
        labDzialanie.setText("/");
        numDzialania = 0;
    }
    public void mnozenie(){
        currText = textFieldLiczba2;
        labDzialanie.setText("*");
        numDzialania = 1;
    }
    public void odejmowanie(){
        currText = textFieldLiczba2;
        labDzialanie.setText("-");
        numDzialania = 2;
    }
    public void dodawanie(){
        currText = textFieldLiczba2;
        labDzialanie.setText("+");
        numDzialania = 3;
    }
    public void pierwiastkowanie(){
        currText = textFieldLiczba2;
        labDzialanie.setText("√");
        numDzialania = 4;
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
    public void rozwiazanie(){
        int liczba1 = Integer.valueOf(textFieldLiczba1.getText());
        int liczba2 = Integer.valueOf(textFieldLiczba2.getText());
        switch (numDzialania){
            case 0: labWynik.setText(""+(liczba1/liczba2));
                break;
            case 1: labWynik.setText(""+(liczba1*liczba2));
                break;
            case 2: labWynik.setText(""+(liczba1-liczba2));
                break;
            case 3: labWynik.setText(""+(liczba1+liczba2));
                break;
        }
    }
}
