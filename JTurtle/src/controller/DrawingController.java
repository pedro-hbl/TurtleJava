package controller;

import Screen.Screen;
import Turtle.Turtle;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

// Classe que controla as funcoes dos botÃµes na tela de desenhar
public class DrawingController implements Initializable {
    private static final Screen SCREEN = new Screen(500, 400);
    private final Group shapes = new Group();
    private Turtle t = new Turtle(shapes, SCREEN.getWidth(), SCREEN.getHeigth());
    private static String executedFunctions;// posicao, angulo;
    private Scene desenhoAtual;
    @FXML private Button btnSetAngle;
    @FXML private Button btnDraw;
    @FXML private Button btnForward;
    @FXML private Button btnLeft;
    @FXML private Button btnDelete;
    @FXML private TextArea txtArea;
    @FXML private Button btnPen;
    @FXML private Text txtAngulo;
    @FXML private Text txtPosicao;
    @FXML private Button btnBackward;
    @FXML private Button btnRight;
    @FXML private Text txtPen;

    // Incializando a tela de desenhar
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtAngulo.setText("Ângulo: Âº");
        txtPosicao.setText("Posição: (x,y)");
        txtPen.setText("Pen down: true");

        // Executando o botao forward 
        btnForward.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                double parametro = 0;
                try {
                    parametro = Double.parseDouble(JOptionPane.showInputDialog("Digite a distância a ser percorrida(em pixels):"));
                } catch (NumberFormatException exception) {
                    parametro = Double.parseDouble(JOptionPane.showInputDialog("Opção inválida! Digite um valor numérico:\n"
                            + "Digite a distância a ser percorrida(em pixels):"));
                    System.out.println("Opção inválida!" + exception);
                }
                executarFuncao("forward", parametro);
                imprimirFuncao("forward", parametro);
                txtArea.setText(executedFunctions);
                atualizaDadosTurtle();
            }
        });

        // Executando o botao backward 
        btnBackward.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                double parametro = 0;
                try {
                    parametro = Double.parseDouble(JOptionPane.showInputDialog("Digite a distância a ser percorrida(em pixels):"));
                } catch (NumberFormatException exception) {
                    parametro = Double.parseDouble(JOptionPane.showInputDialog("Opção inválida!! Digite um valor numérico:\n"
                            + "Digite a distância a ser percorrida(em pixels):"));
                    System.out.println("Opção inválida!" + exception);
                }
                executarFuncao("backward", parametro);
                imprimirFuncao("backward", parametro);
                txtArea.setText(executedFunctions);
                atualizaDadosTurtle();
            }
        });

        // Executando o botao set angle
        btnSetAngle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                double parametro = 0;
                try {
                    parametro = Double.parseDouble(JOptionPane.showInputDialog("Digite o ângulo em relação ao eixo das abcissas (eixo x):"));
                } catch (NumberFormatException exception) {
                    parametro = Double.parseDouble(JOptionPane.showInputDialog("Opção inválida! Digite um valor numérico:\n"
                            + "Digite o ângulo em relação ao eixo das abcissas (eixo x):"));
                    System.out.println("Opção inválida!" + exception);
                }
                executarFuncao("set_angle", parametro);
                imprimirFuncao("set_angle", parametro);
                txtArea.setText(executedFunctions);
                atualizaDadosTurtle();
            }
        });

        // Executando o botao right
        btnRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                double parametro = 0;
                try {
                    parametro = Double.parseDouble(JOptionPane.showInputDialog("Digite o ângulo a ser rotacionado para a direita:"));
                } catch (NumberFormatException exception) {
                    parametro = Double.parseDouble(JOptionPane.showInputDialog("Opção inválida! Digite um valor numérico:\n"
                            + "Digite o ângulo a ser rotacionado para a direita:"));
                    System.out.println("Opção inválida!" + exception);
                }
                executarFuncao("right", parametro);
                imprimirFuncao("right", parametro);
                txtArea.setText(executedFunctions);
                atualizaDadosTurtle();
            }
        });

        // Executando o botao left
        btnLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                double parametro = 0;
                try {
                    parametro = Double.parseDouble(JOptionPane.showInputDialog("Digite o ângulo a ser rotacionado para a direita:"));
                } catch (NumberFormatException exception) {
                    parametro = Double.parseDouble(JOptionPane.showInputDialog("Opção inválida!! Digite um valor numérico:\n"
                            + "Digite o ângulo a ser rotacionado para a direita:"));
                    System.out.println("Opção inválida!" + exception);
                }
                executarFuncao("left", parametro);
                imprimirFuncao("left", parametro);
                txtArea.setText(executedFunctions);
                atualizaDadosTurtle();
            }
        });

        // Executando o botÃ£o pen
        btnPen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                double parametro = 0;
                try {
                    int entradaInvalida = 0;
                    do{
                        if(entradaInvalida == 1){
                            parametro = Double.parseDouble(JOptionPane.showInputDialog("Opção inválida! Escolha apenas uma das opções abaixo: \n"
                            + "1) Digite 0 para Pen Down (Rabo para baixo)\n2) Digite 1 para Pen Up (Rabo pra cima)"));
                        } else {
                            parametro = Double.parseDouble(JOptionPane.showInputDialog("Escolha um dos comandos:\n" 
                            + "1) Digite 0 para Pen Down (Rabo para baixo)\n2) Digite 1 para Pen Up (Rabo pra cima)"));
                        }
                        entradaInvalida = 1;
                    } while(parametro != 0.0 && parametro != 1.0);
                } catch (NumberFormatException exception) {
                    parametro = Double.parseDouble(JOptionPane.showInputDialog("Opção inválida!! Digite um valor numérico:\n"
                            + "Escolha um dos comandos:\n1) Digite 0 para Pen Down (Rabo para baixo)\n2) Digite 1 para Pen Up (Rabo pra cima)"));
                    System.out.println("Opção inválida!" + exception);
                }
                executarFuncao("pen", parametro);
                imprimirFuncao("pen", parametro);
                txtArea.setText(executedFunctions);
                atualizaDadosTurtle();
            }
        });

        // Deletando as funcies do turtle utilizadas pelo usuario
        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                t.resetShapesTurtle();
                txtArea.setText("");
                desenhoAtual = null;
                atualizaDadosTurtle();
                executedFunctions = null;
            }
        });

        // Desenhando os comandos do usuaio e mostrando em uma janela
        btnDraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage desenho = new Stage();
                if (desenhoAtual == null) {
                    desenhoAtual = new Scene(t.getShapesTurtle(), SCREEN.getWidth(), SCREEN.getHeigth());
                }
                desenho.setScene(desenhoAtual);
                desenho.show();
            }
        });

    }

    // FunÃ§Ã£o que executa funcoes do turtle
    private void executarFuncao(String function, double parameter) {
        switch (function) {
            case "forward":
                t.forward(parameter);
                break;
            case "backward":
                t.backward(parameter);
                break;
            case "set_angle":
                t.set_angle(parameter);
                break;
            case "left":
                t.left(parameter);
                break;
            case "right":
                t.right(parameter);
                break;
            case "pen":
                if (parameter == 1) {
                    t.pen_up();
                } else {
                    t.pen_down();
                }
                break;
        }
    }

    // FunÃ§Ã£o que imprime a funÃ§Ã£o utilizada para o usuÃ¡rio na Ã¡rea de texto
    @SuppressWarnings("empty-statement")
    private void imprimirFuncao(String function, double parameter) {
        String executedFunction = function + "("+Double.toString(parameter)+")";
        if (executedFunctions == null) {
            executedFunctions = executedFunction + ";";
        } else {
            executedFunctions = executedFunctions + "\n" + executedFunction + ";";
        }
    }

    // Atualizando os dados do turtle na tela
    public void atualizaDadosTurtle() {
        txtPosicao.setText("Posição: ("+(int)t.getX()+", "+(int)t.getY()+")");
        txtAngulo.setText("Ângulo: "+(int)t.get_angle()+"Âº");
        txtPen.setText("Pen down: "+t.getPenDown());
    }

}
