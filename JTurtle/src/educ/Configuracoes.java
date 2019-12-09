package educ;

import javafx.scene.*;
import javafx.stage.Stage;

// Classe que configura o jogo
public class Configuracoes {

    // FunÃ§Ã£o que define as fases, atividades e respostas do jogo
    public static Educ MontaJogo(Scene inicio, Stage stage) {
        Atividade atividade;
        Educ jogo = new Educ();
        // Instanciando as fases
        Fase fase0 = new Fase();
        Fase fase1 = new Fase();
        Fase fase2 = new Fase();
        
        //Instanciando as atividades
        //comandos bÃ¡sicos
        fase0.addAtividade(new Atividade("Desenhe uma linha de 100 pixels para direita partindo da origem.",
                "tart.forward(100);"));
        fase0.addAtividade(new Atividade("Desenhe uma linha de 100 pixels para esquerda partido da origem.",
                "tart.backward(100);"));
        fase0.addAtividade(new Atividade("Teste os comandos 'left' e 'right' para fechar uma figura.",
                "tart.forward(100);\ntart.left(120);\ntart.forward(100);\ntart.left(120);\ntart.forward(100);"));
        //poligonos
        fase1.addAtividade(new Atividade("Desenhe um quadrado de lado 100 partindo da origem.",
                "tart.forward(100);\ntart.left(90);\ntart.forward(100);\ntart.left(90);\ntart.forward(100);\ntart.left(90);\ntart.forward(100);"));
        fase1.addAtividade(new Atividade("Desenhe um triângulo equilátero de lado 100 partindo da origem com base\n no eixo das abcissas.",
                "tart.forward(100);\ntart.left(120);\ntart.forward(100);\ntart.left(120);\ntart.forward(100);"));
        fase1.addAtividade(new Atividade("Desenhe um pentágono de lado 100 partindo da origem com base \nno eixo das abcissas.",
                "tart.forward(100);\ntart.left(72);\ntart.forward(100);\ntart.left(72);"
                + "\ntart.forward(100);\ntart.left(72);\ntart.forward(100);\ntart.left(72);\ntart.forward(100);"));
        fase1.addAtividade(new Atividade("Desenhe um hexágono de lado 100 partindo da origem com base\n no eixo das abcissas.",
                "tart.forward(100);\ntart.left(60);\ntart.forward(100);\ntart.left(60);\ntart.forward(100);\ntart.left(60);"
                + "\ntart.forward(100);\ntart.left(60);\ntart.forward(100);\ntart.left(60);\ntart.forward(100);"));
        fase1.addAtividade(new Atividade("Proponha um código genérico para um polígono de n lados de lado "
                + "100 partindo \nda origem com base no eixo das abcissas.",
                "public void draw_poligon(n,tart){\n"
                + "    int ainterno=(n-2)*180/n;\n"
                + "    for(int i=0;i<n;i+=1){\n"
                + "        tart.forward(100);\n"
                + "        tart.left(180-ainterno);\n"
                + "    }\n"
                + "}"));
        fase1.addAtividade(new Atividade("Diminua o valor do lado proposto e aproxime um círculo por um polígono de\n 50 lados.",
                "public void draw_poligon(n,tart){\n"
                + "    int ainterno=(n-2)*180/n;\n"
                + "    for(int i=0;i<n;i+=1){\n"
                + "        tart.forward(1);\n"
                + "        tart.left(180-ainterno);\n"
                + "    }\n"
                + "}\n\n"
                + "No botão 'Mostrar resposta', temos a execução do código para n = 50."));
        //estrelas
        fase2.addAtividade(new Atividade("Proponha um código genérico para uma estrela de n pontas",
                "public void make_star(int n, Turtle tart, int lado){\n"
                + "    int ainterno=(n-2)*180/n;\n"
                + "    int ainscrito=180/n;\n"
                + "    tart.left((180-ainterno)/2)\n"
                + "    for(int i=0;i<n;i+=1){\n"
                + "        tart.forward(lado);\n"
                + "        tart.left(180-ainscrito);\n"
                + "    }\n"
                + "}\n\n"
                + "No botão 'Mostrar resposta', temos a execução do código para n = 5 e lado = 150."));
        fase2.addAtividade(new Atividade("Use o código da estrela do exercício anterior para desenhar um sol (estrela de 33 pontas)",
                "public void make_star(int n, Turtle tart, int lado){\n"
                + "    int ainterno=(n-2)*180/n;\n"
                + "    int ainscrito=180/n;\n"
                + "    tart.left((180-ainterno)/2)\n"
                + "    for(int i=0;i<n;i+=1){\n"
                + "        tart.forward(lado);\n"
                + "        tart.left(180-ainscrito);\n"
                + "    }\n"
                + "}\nmake_star(33,tart,150);"
                ));
        // Adicionando as fases ao jogo
        jogo.addFase(fase0);
        jogo.addFase(fase1);
        jogo.addFase(fase2);
        return jogo;
    }
}
