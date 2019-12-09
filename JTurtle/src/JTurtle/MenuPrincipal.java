package JTurtle;

import Screen.Screen;
import java.io.IOException;
import controller.MenuPrincipalController;
import educ.Configuracoes;
import educ.Educ;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MenuPrincipal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static Educ TurtleGame;
    private static Stage stage;
    private static Scene menuPrincipalScene;
    private static Scene fasesScene;
    private static Scene atividade;
    private static final Screen SCREEN = new Screen(600, 400);

    // Inicializando o menu inicial
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        MenuPrincipalController.setStage(stage);
        primaryStage.setTitle("Menu Inicial");

        Parent fxmlMenuPrincipal = FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
        menuPrincipalScene = new Scene(fxmlMenuPrincipal, 600, 400);

        Parent fxmlFases = FXMLLoader.load(getClass().getResource("/View/menuFases.fxml"));
        fasesScene = new Scene(fxmlFases, 600, 400);

        Parent fxmlAtividade = FXMLLoader.load(getClass().getResource("/View/FaseAtividade.fxml"));
        atividade = new Scene(fxmlAtividade, 600, 400);
        
        // Chamada da função MontaJogo, que carrega as fases e a tela
        TurtleGame = Configuracoes.MontaJogo(menuPrincipalScene, stage);

        primaryStage.setScene(menuPrincipalScene);
        primaryStage.show();
    }

    // Método para a mudança de cenas de forma dinâmica na janela
    public static void changeScene(String scn) {
        switch (scn) {
            case "principal":
                stage.setScene(menuPrincipalScene);
                break;
            case "fases":
                stage.setScene(fasesScene);
                break;
            case "atividade":
                stage.setScene(atividade);
                break;
        }
    }

    // Funcao para fechar a janela
    public static void close() {
        stage.close();
    }

    // Funcao que obtem a cena atual
    protected static Scene getFasesScene() {
        return fasesScene;
    }

    // Funcao que obtem a janela atual
    public static Stage getStage() {
        return stage;
    }

    // Funcao que obtem o jogo que foi instanciado na função main
    public static Educ getEduc() {
        return TurtleGame;
    }
    
    // Obtendo o comprimento da janela do menu principal
    public static int getScreenWidth(){
        return SCREEN.getWidth();
    }
    
    // Obtendo a altura da janela do menu principal
    public static int getScreenHeigth(){
        return SCREEN.getHeigth();
    }
}
