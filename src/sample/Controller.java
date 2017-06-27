package sample;
/**
 * Źle pokazuje wynik przy 0.3333 - 0.3331
 *  - Zmienić ilość miejsc po przecinku
 *  - Po zmianie TextField'a można wydrukować kropka (tak nie powinno być !)
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.text.DecimalFormat;


public class Controller{

    @FXML
    TextField textFieldLiczba1;

    @FXML
    TextField textFieldLiczba2;

    @FXML
    Label labWynik;

    @FXML
    Label labDzialanie;

    @FXML
    Label labError;

    TextField currText = textFieldLiczba1;

    int numDzialania = 0;

    public void changeCurrTextField(MouseEvent ev){
        currText = (TextField) ev.getSource();
    }
    public void printButtonOnTextField(ActionEvent event){
        if (currText == null) currText = textFieldLiczba1;
        Button currButt = (Button) event.getSource();
        currText.setText(currText.getText() + currButt.getText());
    }
    public void dzielenie(){
        currText = textFieldLiczba2;
        labDzialanie.setText("/");
        numDzialania = 1;
    }
    public void mnozenie(){
        currText = textFieldLiczba2;
        labDzialanie.setText("*");
        numDzialania = 2;
    }
    public void odejmowanie(){
        currText = textFieldLiczba2;
        labDzialanie.setText("-");
        numDzialania = 3;
    }
    public void dodawanie(){
        currText = textFieldLiczba2;
        labDzialanie.setText("+");
        numDzialania = 4;
    }
    public void deleteAll() {
        textFieldLiczba1.setText("");
        textFieldLiczba2.setText("");
        labWynik.setText("");
        currText = textFieldLiczba1;
    }
    public void delete(){
        if (currText.getText().length() > 0){
            currText.setText(currText.getText().substring(0,currText.getText().length()-1));
        }
    }
    public void kropka()throws RuntimeException{
        try {
            if (!currText.getText().contains(".")) {
                currText.setText(currText.getText() + ".");
            }
        }catch (RuntimeException exc){
            labError.setText("Kropka w tym miejscu się nie przyda !");
        }
    }
    public void rozwiazanie() throws RuntimeException{
        try{
            Double liczba1 = Double.valueOf(textFieldLiczba1.getText());
            Double liczba2 = Double.valueOf(textFieldLiczba2.getText());
            DecimalFormat df = new DecimalFormat();
            df.setMinimumFractionDigits(0);
            df.setMaximumFractionDigits(10);
            switch (numDzialania){
                case 0: labError.setText("Nie wybrano działania !");
                    break;
                case 1:
                    labWynik.setText(""+df.format(liczba1/liczba2));
                    labError.setText("");
                    break;
                case 2:
                    labWynik.setText(""+df.format(liczba1*liczba2));
                    labError.setText("");
                    break;
                case 3:
                    labWynik.setText(""+df.format(liczba1-liczba2));
                    labError.setText("");
                    break;
                case 4:
                    labWynik.setText(""+df.format(liczba1+liczba2));
                    labError.setText("");
                    break;
            }
        }catch (RuntimeException exc){
            labError.setText("Coś poszło nie tak ! Popraw pola liczbowe !");
        }
    }
}
