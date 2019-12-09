package educ;

import Turtle.Turtle;

// Classe responsável por gerenciar a resposta de cada atividade
public class Respostas {

    // Escolhendo a resposta de uma determinada atividade para executar
    public static void execute(int faseatual, int atividadeatual, Turtle tart) {
        String nivel = Integer.toString(faseatual) + Integer.toString(atividadeatual);
        switch (nivel) {
            case "00":
                Fase0Atividade0(tart);
                break;
            case "01":
                Fase0Atividade1(tart);
                break;
            case "02":
                Fase0Atividade2(tart);
                break;
            case "10":
                Fase1Atividade0(tart);
                break;
            case "11":
                Fase1Atividade1(tart);
                break;
            case "12":
                Fase1Atividade2(tart);
                break;
            case "13":
                Fase1Atividade3(tart);
                break;
            case "14":
                Fase1Atividade4(tart);
                break;
            case "15":
                Fase1Atividade5(tart);
                break;
            case "20":
                Fase2Atividade0(tart);
                break;
            case "21":
            	Fase2Atividade1(tart);
            	break;
            default:
                System.out.println("Fase n�o encontrada");
        }
    }
    
    // Funções que executam as respostas de cada atividade utilizando o turtle
    
    private static void Fase0Atividade0(Turtle tart) {
        tart.forward(100);
    }

    private static void Fase0Atividade1(Turtle tart) {
        tart.backward(100);
    }

    private static void Fase0Atividade2(Turtle tart) {
        tart.forward(100);
        tart.left(120);
        tart.forward(100);
        tart.left(120);
        tart.forward(100);
    }

    private static void Fase1Atividade0(Turtle tart) {
        tart.forward(100);
        tart.left(90);
        tart.forward(100);
        tart.left(90);
        tart.forward(100);
        tart.left(90);
        tart.forward(100);
    }

    private static void Fase1Atividade1(Turtle tart) {
        tart.forward(100);
        tart.left(120);
        tart.forward(100);
        tart.left(120);
        tart.forward(100);
    }

    private static void Fase1Atividade2(Turtle tart) {
        tart.forward(100);
        tart.left(72);
        tart.forward(100);
        tart.left(72);
        tart.forward(100);
        tart.left(72);
        tart.forward(100);
        tart.left(72);
        tart.forward(100);
    }

    private static void Fase1Atividade3(Turtle tart) {
        tart.forward(100);
        tart.left(60);
        tart.forward(100);
        tart.left(60);
        tart.forward(100);
        tart.left(60);
        tart.forward(100);
        tart.left(60);
        tart.forward(100);
        tart.left(60);
        tart.forward(100);
    }

    private static void Fase1Atividade4(Turtle tart) {
        draw_poligon(4, tart, 100);
    }

    private static void Fase1Atividade5(Turtle tart) {
        draw_poligon(50, tart, 10);
    }

    private static void Fase2Atividade0(Turtle tart) {
        make_star(5, tart, 150);

    }
    private static void Fase2Atividade1(Turtle tart) {
        make_star(21, tart, 150);

    }

    // Código para desenhar um polígono de n lados
    private static void draw_poligon(int n, Turtle tart, int lado) {
        int ainterno = (n - 2) * 180 / n;
        for (int i = 0; i < n; i += 1) {
            tart.forward(lado);
            tart.left(180 - ainterno);
        }
    }

    // Codigo para desenhar um estrela de n lados
    private static void make_star(int n, Turtle tart, int lado) {
        int ainterno = (n - 2) * 180 / n;
        int ainscrito = 180 / n;
        tart.left((180 - ainterno) / 2);
        for (int i = 0; i < n; i += 1) {
            tart.forward(lado);
            tart.left(180 - ainscrito);
        }
    }
}
