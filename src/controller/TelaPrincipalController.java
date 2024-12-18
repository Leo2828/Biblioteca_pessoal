package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaPrincipalController {

    @FXML
    void detailsBtn(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/TelaDetalhes.fxml"));
            Pane telaDetalhes = loader.load();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(telaDetalhes));
            stage.setTitle("Detalhes");
            stage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}
