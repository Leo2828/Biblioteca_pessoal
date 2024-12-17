package controller;

import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.*;
import utils.*;

public class TelaDetalhesController {
    @FXML
    private VBox divAno;

    @FXML
    private VBox divAutor;

    @FXML
    private VBox divDetalhes;

    @FXML
    private VBox divGenero;

    @FXML
    private VBox divNome;

    @FXML
    private VBox deleteDiv;

    List<Livro> livros = Arrays.asList(
        new Livro("wqeaaaaaa", "vccxvsla1", "a", 2),
        new Livro("fdgbbbbbbbbbb", "asdsla2", "b", 12),
        new Livro("xzcccccccccccc", "eqwesla3", "c", 3)
    );

    public void initialize() {
        for (Livro livro : livros) {
            Label labelAno = new Label(""+livro.getAno());
            divAno.getChildren().addAll(labelAno);

            Label labelNome = new Label(livro.getNome());
            divNome.getChildren().addAll(labelNome);

            Label labelAutor = new Label(livro.getAutor());
            divAutor.getChildren().addAll(labelAutor);

            Label labelGenero = new Label(livro.getGenero());
            divGenero.getChildren().addAll(labelGenero);

            Button btn = new Button("Apagar");
            deleteDiv.setId(livro.getNome()); 
        }
    }
    @FXML
    void orgAutor(ActionEvent event) {
        String[] nomes = new String[livros.size()];
        int i = 0;

        for (Livro livro : livros) {
            nomes[i] = livro.getAutor();
            i++;
        }
        MergeSortAlpha m = new MergeSortAlpha();

        m.mergeSort(nomes);

        divAno.getChildren().clear();
        divNome.getChildren().clear();
        divAutor.getChildren().clear();
        divGenero.getChildren().clear();

        for (String nome : nomes) {
            for(Livro livro : livros){
                if(livro.getAutor().equalsIgnoreCase(nome)){
                    Label labelAno = new Label(""+livro.getAno());
                    divAno.getChildren().addAll(labelAno);

                    Label labelNome = new Label(livro.getNome());
                    divNome.getChildren().addAll(labelNome);

                    Label labelAutor = new Label(livro.getAutor());
                    divAutor.getChildren().addAll(labelAutor);

                    Label labelGenero = new Label(livro.getGenero());
                    divGenero.getChildren().addAll(labelGenero);
                }
            }
        }
    }

    @FXML
    void orgAno(ActionEvent event) {
        int[] anos = new int[livros.size()];
        int i = 0;

        for (Livro livro : livros) {
            anos[i] = livro.getAno();
            i++;
        }
        MergerSortNumber m = new MergerSortNumber();

        m.sort(anos);

        divAno.getChildren().clear();
        divNome.getChildren().clear();
        divAutor.getChildren().clear();
        divGenero.getChildren().clear();

        for (int ano : anos) {
            for(Livro livro : livros){
                if(livro.getAno() == ano){
                    Label labelAno = new Label(""+livro.getAno());
                    divAno.getChildren().addAll(labelAno);

                    Label labelNome = new Label(livro.getNome());
                    divNome.getChildren().addAll(labelNome);

                    Label labelAutor = new Label(livro.getAutor());
                    divAutor.getChildren().addAll(labelAutor);

                    Label labelGenero = new Label(livro.getGenero());
                    divGenero.getChildren().addAll(labelGenero);
                }
            }
        }
    }
}
