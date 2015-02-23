package control;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Francesco
 */
public class Controller implements Initializable {

    public void initialize(URL url, ResourceBundle rb) {
        //
    }
    
    //bottoni
    @FXML Button btn1;
    @FXML Button btn2;
    @FXML Button btn3;  
    //label
    @FXML Label lVoS;
    @FXML Label lVinte;
    @FXML Label lPerse;
    @FXML Label lGiocate;
    @FXML Label lPercVittorie;
    
    Random r = new Random();
    
    int cartaVincente = 0;
    int giocate = 0;
    int vinte = 0;
    int perse = 0;
    float percVittorie = 0;
    
    @FXML
    public void replay(ActionEvent ae) {
        cartaVincente = r.nextInt(3);
        btn1.setText("???");
        btn2.setText("???");
        btn3.setText("???");
        btn1.setDisable(false);
        btn2.setDisable(false);
        btn3.setDisable(false);
        btn1.setStyle("-fx-base: #E6E6E6;");
        btn2.setStyle("-fx-base: #E6E6E6;");
        btn3.setStyle("-fx-base: #E6E6E6;");      
    }   
        
    @FXML
    public void primoPulsante() {
        if (cartaVincente == 0) {
            btn1.setText("si!");
            btn1.setDisable(true);
            btn2.setDisable(true);
            btn3.setDisable(true);
            btn1.setStyle("-fx-base: #47FF88;");
            this.giocate++;
            this.vinte++;
            refreshStatistics();
            lVoS.setText("HAI VINTO!");
        } else {
            btn1.setText("no!");
            btn1.setDisable(true);
            btn2.setDisable(true);
            btn3.setDisable(true);
            btn1.setStyle("-fx-base: #FF4747;");
            this.giocate++;
            this.perse++;
            refreshStatistics();
            lVoS.setText("HAI PERSO!");
        }
    }
    
    @FXML
    public void secondoPulsante() {
        if (cartaVincente == 1) {
            btn2.setText("si!");
            btn1.setDisable(true);
            btn2.setDisable(true);
            btn3.setDisable(true);
            btn2.setStyle("-fx-base: #47FF88;");
            this.giocate++;
            this.vinte++;
            refreshStatistics();
            lVoS.setText("HAI VINTO!");
        } else {
            btn2.setText("no!");
            btn1.setDisable(true);
            btn2.setDisable(true);
            btn3.setDisable(true);
            btn2.setStyle("-fx-base: #FF4747;");
            this.giocate++;
            this.perse++;
            refreshStatistics();
            lVoS.setText("HAI PERSO!");
        }    
    }
    
    @FXML
    public void terzoPulsante() {
        if (cartaVincente == 2) {
            btn3.setText("si!");
            btn1.setDisable(true);
            btn2.setDisable(true);
            btn3.setDisable(true);
            btn3.setStyle("-fx-base: #47FF88;");
            this.giocate++;
            this.vinte++;
            refreshStatistics();
            lVoS.setText("HAI VINTO!");
        } else {
            btn3.setText("no!");
            btn1.setDisable(true);
            btn2.setDisable(true);
            btn3.setDisable(true);
            btn3.setStyle("-fx-base: #FF4747;");
            this.giocate++;
            this.perse++;
            refreshStatistics();
            lVoS.setText("HAI PERSO!");
        }    
    }
    
    public void refreshStatistics() {
        lVinte.setText(Integer.toString(this.vinte));
        lPerse.setText(Integer.toString(this.perse));
        lGiocate.setText(Integer.toString(this.giocate));
        if (this.giocate == 0) {
            percVittorie = this.vinte*100;
            lPercVittorie.setText(Float.toString(this.percVittorie));
        } else {
            percVittorie = this.vinte*100/this.giocate;
            lPercVittorie.setText(Float.toString(this.percVittorie));
        }
    }
}