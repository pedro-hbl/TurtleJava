package controller;

import JTurtle.MenuPrincipal;
import educ.Atividade;
import educ.Fase;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

// Classe que controla as funções dos botões na tela
public class AtivController implements Initializable{
    @FXML private Label lbAtivid;
    @FXML private Button btnProxima;
    @FXML private Button btnVoltar;
    @FXML private Label lbTitleAtiv;
    @FXML private Button btnDesenhar;
    @FXML private AnchorPane lbAtiv1;
    
    private static Label lblTitleAtiv;
    private static Button btnProximaAtiv;
    private static Label lblAtivid;
    private static Fase faseAtual;
    private static Atividade ativAtual;
    private static final int WIDTH = MenuPrincipal.getScreenWidth();
    private static final int HEIGHT = MenuPrincipal.getScreenHeigth();
    
    // Executando o botao "voltar"
    @FXML public void backScene(ActionEvent e) {
        faseAtual = MenuPrincipal.getEduc().getFaseAtual();
        int numAtivAnterior = faseAtual.getNumAtividadeAtual();
        faseAtual.anterior();
        setAtividade(faseAtual);
        if(numAtivAnterior == 0){
            MenuPrincipal.changeScene("fases");
            MenuPrincipal.getStage().setTitle("Menu de Fases");
        }
    }

    // Executando o botao "proxima"
    @FXML protected void nextLevel(ActionEvent e) {
        faseAtual = MenuPrincipal.getEduc().getFaseAtual();
        int numAtivAnterior = faseAtual.getNumAtividadeAtual();
        faseAtual.proximo();
        setAtividade(faseAtual);
        if(numAtivAnterior == faseAtual.getNumAtividades()-1){
            faseAtual.recomecar();
            MenuPrincipal.changeScene("fases");
            MenuPrincipal.getStage().setTitle("Menu de Fases");
        }
    }
        
    // Executando o botão "desenhar"
    @FXML protected void toDraw() throws IOException{
        Stage desenho = new Stage();
        Parent fxmlDrawing = FXMLLoader.load(getClass().getResource("/View/Drawing.fxml"));
        Scene scn = new Scene(fxmlDrawing, WIDTH+200, HEIGHT+200);
        desenho.setScene(scn);
        desenho.show();
    }
    
    // Executando o botão "resposta"
    @FXML protected void mostrarResposta(ActionEvent e) throws IOException{
        faseAtual = MenuPrincipal.getEduc().getFaseAtual();
        ativAtual = faseAtual.getAtividadeAtual();
        String resposta = ativAtual.getResposta();
        Stage window = new Stage();
        Parent fxmlResposta = FXMLLoader.load(getClass().getResource("/View/Resposta.fxml"));
        Scene resp = new Scene(fxmlResposta, WIDTH, HEIGHT);
        RespostaController.getLabelResposta().setText(resposta);
        window.setTitle("Resposta: Fase "+(MenuPrincipal.getEduc().getNumFaseAtual()+1)
                +" - Atividade "+(faseAtual.getNumAtividadeAtual()+1));
        window.setScene(resp);
        window.show();
        
    }
    
    // Definindo os valores dos componentes da janela de acordo com a tividade atual
    @FXML protected void setAtividade(Fase fase){
        int ativ = fase.getNumAtividadeAtual();
        lblTitleAtiv.setText("Atividade "+(ativ+1));
        lblAtivid.setText(fase.getAtividadeAtual().getEnunciado());
        MenuPrincipal.getStage().setTitle("Fase "+(MenuPrincipal.getEduc().getNumFaseAtual()+1)+" - Atividade "+(fase.getNumAtividadeAtual()+1));
        if(fase.getNumAtividadeAtual() == fase.getNumAtividades()){
            btnProximaAtiv.setText("Concluir");
        }
    }

    // Obtendo a fase atual
    public static int getNumFaseAtual(){
        return MenuPrincipal.getEduc().getNumFaseAtual();
    }
    
    // Obtendo a atividade atual
    public static int getNumAtivAtual(){
        return faseAtual.getNumAtividadeAtual();
    }

    // Função de inicialização da tela de atividades
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblTitleAtiv = lbTitleAtiv;
        btnProximaAtiv = btnProxima;
        lblAtivid = lbAtivid;
    }

}
