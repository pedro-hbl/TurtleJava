package educ;

// Classe que controla as transições das atividades em uma fase
public class Fase implements Actions {

    public static final int MAXATIVS = 9;
    public int numAtividades = 0;
    public Atividade[] atividades = new Atividade[MAXATIVS];
    public int atividadeAtual = 0;

    // Adicionando uma atividade ao vetor de atividades associado a uma fase
    public void addAtividade(Atividade novaAtiv) {
        if (numAtividades < MAXATIVS) {
            atividades[++numAtividades - 1] = novaAtiv;
        }
    }

    // Retornando para a primeira atividade
    @Override
    public void recomecar() {
        atividadeAtual = 0;
    }

    // Fazendo transição para a próxima atividade
    @Override
    public void proximo() {
        if (atividadeAtual < numAtividades - 1) {
            atividadeAtual++;

        }
    }

    // Fazendo a transição apara a fase anterior
    @Override
    public void anterior() {
        if (atividadeAtual > 0) {
            atividadeAtual--;
        }
    }

    // Obtendo a atividade atual
    public Atividade getAtividadeAtual() {
        return this.atividades[atividadeAtual];
    }

    // Obtendo o número da atividade atual
    public int getNumAtividadeAtual() {
        return atividadeAtual;
    }

    // Obtendo o número de atividade de uma determinada fase
    public int getNumAtividades() {
        return numAtividades;
    }

}
