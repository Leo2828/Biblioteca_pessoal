package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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
    private VBox divDelete;

    @FXML
    private VBox divEdit;

    List<Livro> livros = new ArrayList<>(Arrays.asList(
        new Livro("wqeaaaaaa", "vccxvsla1", "a", 2),
        new Livro("fdgbbbbbbbbbb", "asdsla2", "b", 12),
        new Livro("xzcccccccccccc", "eqwesla3", "c", 3)
    ));

    public void initialize() {
        for (Livro livro : livros) {

            Label labelAno = new Label(""+livro.getAno());
            labelAno.setId(""+livro.getAno());
            divAno.getChildren().addAll(labelAno);

            Label labelNome = new Label(livro.getNome());
            labelNome.setId(livro.getNome());
            divNome.getChildren().addAll(labelNome);

            Label labelAutor = new Label(livro.getAutor());
            labelAutor.setId(livro.getAutor());
            divAutor.getChildren().addAll(labelAutor);

            Label labelGenero = new Label(livro.getGenero());
            labelGenero.setId(livro.getGenero());
            divGenero.getChildren().addAll(labelGenero);

            Button btnDelete = new Button("X");
            btnDelete.setId(livro.getNome()); 
            divDelete.getChildren().addAll(btnDelete);

            Button btnEdit = new Button("E");
            btnEdit.setId(livro.getNome()); 
            divEdit.getChildren().addAll(btnEdit);

            btnDelete.setOnAction(e -> {
                for (int i = 0; i < livros.size(); i++) {
                    if (livros.get(i).getNome().equals(btnDelete.getId())) {
                        livros.remove(i);
                        removerLabelPorId(""+livro.getAno());
                        removerLabelPorId(livro.getNome());
                        removerLabelPorId(livro.getAutor());
                        removerLabelPorId(livro.getGenero());
                        divDelete.getChildren().remove(btnDelete);
                        divEdit.getChildren().remove(btnEdit);
                        break; // Quebra o loop após remover o item
                    }
                }
            });

            btnEdit.setOnAction(e -> {
                for (int i = 0; i < livros.size(); i++) {
                    if (livros.get(i).getNome().equals(btnEdit.getId())) {
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/TelaDetalhes.fxml"));
                            Pane telaDetalhes = loader.load();
                            
                            Stage stage = new Stage();
                            stage.setScene(new Scene(telaDetalhes));
                            stage.setTitle("Detalhes");
                            stage.show();
                        } catch (Exception err) {
                            err.printStackTrace();
                        }
                    }
                }
            });
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

    private void removerLabelPorId(String id) {
        // Iterar sobre os filhos do VBox (ou outro contêiner)
        for (int i = 0; i < divAno.getChildren().size(); i++) {
            if (divAno.getChildren().get(i) instanceof Label) {
                Label label = (Label) divAno.getChildren().get(i);
                if (label.getId().equals(id)) {
                    divAno.getChildren().remove(i); // Remover o Label
                    break; // Parar de procurar após remover
                }
            }
        }
    
        // Repetir o processo para os outros VBox
        for (int i = 0; i < divNome.getChildren().size(); i++) {
            if (divNome.getChildren().get(i) instanceof Label) {
                Label label = (Label) divNome.getChildren().get(i);
                if (label.getId().equals(id)) {
                    divNome.getChildren().remove(i);
                    break;
                }
            }
        }
    
        for (int i = 0; i < divAutor.getChildren().size(); i++) {
            if (divAutor.getChildren().get(i) instanceof Label) {
                Label label = (Label) divAutor.getChildren().get(i);
                if (label.getId().equals(id)) {
                    divAutor.getChildren().remove(i);
                    break;
                }
            }
        }
    
        for (int i = 0; i < divGenero.getChildren().size(); i++) {
            if (divGenero.getChildren().get(i) instanceof Label) {
                Label label = (Label) divGenero.getChildren().get(i);
                if (label.getId().equals(id)) {
                    divGenero.getChildren().remove(i);
                    break;
                }
            }
        }
    }
}
