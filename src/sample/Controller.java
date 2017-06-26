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

    @FXML
    Label labError;

    TextField currText = textFieldLiczba1;

    int numDzialania=0;

    public void changeCurrTextField(){
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
    public void rozwiazanie() throws RuntimeException{
        try{
            int liczba1 = Integer.valueOf(textFieldLiczba1.getText());
            int liczba2 = Integer.valueOf(textFieldLiczba2.getText());
            switch (numDzialania){
                case 0: labError.setText("Nie wybrano działania !");
                    break;
                case 1:
                    labWynik.setText(""+(liczba1/liczba2));
                    labError.setText("");
                    break;
                case 2:
                    labWynik.setText(""+(liczba1*liczba2));
                    labError.setText("");
                    break;
                case 3:
                    labWynik.setText(""+(liczba1-liczba2));
                    labError.setText("");
                    break;
                case 4:
                    labWynik.setText(""+(liczba1+liczba2));
                    labError.setText("");
                    break;
            }
        }catch (RuntimeException exc){
            labWynik.setText("Coś poszło nie tak !");
            labError.setText("Popraw pola liczbowe !");
        }
    }
}
