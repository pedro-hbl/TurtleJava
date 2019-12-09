package controller;

import JTurtle.MenuPrincipal;
import educ.Respostas;
import Turtle.Turtle;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

// Classe que controla a resposta da atividade e mostra o seu desenho
public class RespostaController implements Initializable{
    @FXML private Label lblTitleResposta;
    @FXML private Label lbResposta;
    @FXML private Button btnMostrarResposta;
    private static int[][] excecoes = {{1,4}};
    private static final int WIDTH = MenuPrincipal.getScreenWidth();
    private static final int HEIGHT = MenuPrincipal.getScreenHeigth();
    private String lblTitleOfResposta;
    private static  Label lblResposta;
    private int faseAtual;
    private int atividadeAtual;
    
    // Incializando a tela de resposta
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblResposta = lbResposta;
        faseAtual = AtivController.getNumFaseAtual();
        atividadeAtual = AtivController.getNumAtivAtual(); 
        
        if(isInExcecao(faseAtual, atividadeAtual)){
            if(faseAtual == 0 && atividadeAtual == 0){
                Turtle t = new Turtle();
                Respostas.execute(faseAtual, atividadeAtual, t);
            }
            btnMostrarResposta.setVisible(false);
        } 
    }
    
    // Desenhando a resposta usando o turtle
    @FXML public void desenharResposta(ActionEvent e){
        Turtle t = new Turtle(new Group());
        Respostas.execute(faseAtual, atividadeAtual, t);
        Stage desenho = new Stage();
        Scene resp = new Scene(t.getShapesTurtle(), WIDTH, HEIGHT); 
        desenho.setScene(resp);
        desenho.setTitle("Desenho da resposta (Fase "+(faseAtual+1)+" - Atividade "+(atividadeAtual+1)+")");
        desenho.show();
    }
    
    // DObtendo o label que apresenta a resposta
    public static Label getLabelResposta(){
        return lblResposta;
    }
    
    // Definindo a fase atual
    public void setFaseAtual(int faseAtual){
        this.faseAtual = faseAtual;
    }
    
    // Identificando as fases que nao devem mostrar o desenho da resposta
    private boolean isInExcecao(int fase, int atividade){
        int i;
        for(i=0; i< excecoes.length; i++){
            if(excecoes[i][0] == fase && excecoes[i][1] == atividade){
                return true;
            }
        }
        return false;
    }
}
