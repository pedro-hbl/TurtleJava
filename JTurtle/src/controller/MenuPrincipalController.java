package controller;

import java.io.IOException;
import JTurtle.MenuPrincipal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

// Classe que controla os botoees dos menus
public class MenuPrincipalController {
    private final AtivController ativControl = new AtivController();
    private static Stage stage;
    
    //Mudando o menu de selecao de fases
    @FXML
    protected void btnChangeScene(ActionEvent e){
        MenuPrincipal.changeScene("fases");
    }
    
     // Executando a mudanca de cena para as atividades da fase 1
    @FXML protected void btnFase1(ActionEvent e) throws IOException {
    	MenuPrincipal.changeScene("atividade");
        MenuPrincipal.getEduc().setNumFaseAtual(0); 
        ativControl.setAtividade(MenuPrincipal.getEduc().getFase(0));
    }
    
     // Executando a mudanca de cena para as atividades da fase 2
    @FXML protected void btnFase2(ActionEvent e) {
        MenuPrincipal.changeScene("atividade");
        MenuPrincipal.getEduc().setNumFaseAtual(1); 
        ativControl.setAtividade(MenuPrincipal.getEduc().getFase(1));
    }
    
    // Executando a mudanca de cena para as atividades da fase 3
    @FXML protected void btnFase3(ActionEvent e) {
        MenuPrincipal.changeScene("atividade");
        MenuPrincipal.getEduc().setNumFaseAtual(2); 
        ativControl.setAtividade(MenuPrincipal.getEduc().getFase(2));
    }
    
    // Função para fechar a janela
    public static void close(){
        MenuPrincipal.close();
    }
    
    //Função para obter a janela do menu principal
    public static void setStage(Stage stage){
        MenuPrincipalController.stage = stage;
    }  
    
}
