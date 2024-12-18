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
import javafx.scene.control.TextField;
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

    @FXML
    void adicionarLivro(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/TelaForm.fxml"));
            Pane telaForm = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(telaForm));
            stage.setTitle("Formulário de Adição");
            stage.show();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    private static TelaDetalhesController instance;

    public static TelaDetalhesController getInstance() {
        return instance;
    }

    List<Livro> livros = new ArrayList<>(Arrays.asList(
        new Livro("Bunny", "Mona Awad", "humor humor/ácido", 2019),
        new Livro("Imperfeitos", "Christina Lauren", "humor/romance", 2022),
        new Livro("Jantar secreto", "Raphael Montes", "suspense/ficção", 2016),
        new Livro("A hora da estrela", "Clarice Lispector", "romance psicológico", 1977),
        new Livro("O hobbit", "J. R. R. Tolkien", "literatura fantástica", 1937)
    ));

    private void atualizarTela() {
        // Limpar os VBox
        divAno.getChildren().clear();
        divNome.getChildren().clear();
        divAutor.getChildren().clear();
        divGenero.getChildren().clear();
        divDelete.getChildren().clear();
        divEdit.getChildren().clear();
    
        // Adicionar novamente as Labels e Buttons com as ações corretas
        for (Livro livro : livros) {
            Label labelAno = new Label(""+livro.getAno());
            labelAno.setId(""+livro.getAno());
            divAno.getChildren().add(labelAno);
    
            Label labelNome = new Label(livro.getNome());
            labelNome.setId(livro.getNome());
            divNome.getChildren().add(labelNome);
    
            Label labelAutor = new Label(livro.getAutor());
            labelAutor.setId(livro.getAutor());
            divAutor.getChildren().add(labelAutor);
    
            Label labelGenero = new Label(livro.getGenero());
            labelGenero.setId(livro.getGenero());
            divGenero.getChildren().add(labelGenero);
    
            Button btnDelete = new Button("X");
            btnDelete.setId(livro.getNome());
            divDelete.getChildren().add(btnDelete);
    
            Button btnEdit = new Button("E");
            btnEdit.setId(livro.getNome());
            divEdit.getChildren().add(btnEdit);
    
            // Adicionar eventos aos botões
            btnDelete.setOnAction(e -> {
                // Remover o livro e atualizar a tela
                for (int i = 0; i < livros.size(); i++) {
                    if (livros.get(i).getNome().equals(btnDelete.getId())) {
                        livros.remove(i);
                        atualizarTela();
                        break;
                    }
                }
            });
    
            btnEdit.setOnAction(e -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/TelaForm.fxml"));
                    Pane telaForm = loader.load();
    
                    TelaFormController formController = loader.getController();
    
                    for (Livro l : livros) {
                        if (l.getNome().equals(btnEdit.getId())) {
                            livros.remove(l);
                            atualizarTela();
                            formController.preencherCampos(l);
                            break;
                        }
                    }
    
                    Stage stage = new Stage();
                    stage.setScene(new Scene(telaForm));
                    stage.setTitle("Formulário de Edição");
                    stage.show();
                } catch (Exception err) {
                    err.printStackTrace();
                }
            });
        }
    }

    public void initialize() {
        instance = this;
        atualizarTela();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        atualizarTela();
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

        List<Livro> livrosOrdenados = new ArrayList<>();
        for (String nome : nomes) {
            for (Livro livro : livros) {
                if (livro.getAutor().equalsIgnoreCase(nome)) {
                    livrosOrdenados.add(livro);
                }
            }
        }

        livros = livrosOrdenados;
        atualizarTela();

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

        List<Livro> livrosOrdenados = new ArrayList<>();
        for (int ano : anos) {
            for (Livro livro : livros) {
                if (livro.getAno() == ano) {
                    livrosOrdenados.add(livro);
                }
            }
        }

        livros = livrosOrdenados;
        atualizarTela();
    }

}
