package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Livro;

public class TelaFormController {

    @FXML
    private TextField anoField;

    @FXML
    private TextField autorField;

    @FXML
    private TextField generoField;

    @FXML
    private TextField nomeField;

    @FXML
    void enviarBtn(ActionEvent event) {
        int anoText = Integer.parseInt(anoField.getText());
        String nomeText = nomeField.getText();
        String autorText = autorField.getText();
        String generoText = generoField.getText();
        Livro livro = new Livro(nomeText, autorText, generoText, anoText);

        TelaDetalhesController.getInstance().adicionarLivro(livro);

        Stage stage = (Stage) nomeField.getScene().getWindow();
        stage.close();
    }

    public void preencherCampos(Livro livro) {
        anoField.setText(String.valueOf(livro.getAno()));
        nomeField.setText(livro.getNome());
        autorField.setText(livro.getAutor());
        generoField.setText(livro.getGenero());
    }
}
