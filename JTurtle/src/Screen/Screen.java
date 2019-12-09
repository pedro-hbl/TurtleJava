package Screen;

import Turtle.Shapes;

// Classe utilizada para padronizar o tamanho da janela para as diferentes cenas
public class Screen {
    private int width = 300, height = 300;
    
    // Instanciando uma screen
    public Screen(int width, int height){
        setDimensions(width, height);
    }

    // Definindo as dimensões de uma screen
    private void setDimensions(int width, int heigth) {
        if (width > 0 && heigth > 0) {
            setWidth(width);
            setHeigth(heigth);
        }
    }

    // Obtendo o comprimento
    public int getWidth() {
        return this.width;
    }

    // Definindo o comprimento
    private void setWidth(int width) {
        this.width = width;
    }

    // Obtendo a altura
    public int getHeigth() {
        return this.height;
    }

    // Definindo a altura
    private void setHeigth(int heigth) {
        this.height = heigth;
    }

}
