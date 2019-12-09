package educ;

// Função que define o enunciado e a resposta de uma atividade
public class Atividade {
    String enunciado;
    private String resposta;

    // Contrutor do objeto atividade
    public Atividade(String enunciado, String resposta) {
        this.enunciado = enunciado;
        this.resposta = resposta;
    }

    // Obtendo o enunciado da atividade
    public String getEnunciado() {
        return enunciado;
    }

    // Definindo o enunciado da atividade
    private void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }
    
    // Obtendo a resposta da atividade
    public String getResposta() {
        return this.resposta;
    }

    // Definindo a resposta da atividade
    private void setResposta(String resposta) {
        this.resposta = resposta;
    }
    
}
