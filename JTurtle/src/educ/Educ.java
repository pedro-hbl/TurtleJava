package educ;

// Classe que estabelece o jogo e suas transição de fases
public class Educ implements Actions {

    private static final int MAXFASES = 9;
    private static int numFases;
    private int faseAtual = 0;
    private Fase[] fases = new Fase[MAXFASES];

    // Reiniciando para a primeira fase e primeira atividade
    @Override
    public void recomecar() {
        getFaseAtual().atividadeAtual = 0;
        this.faseAtual = 0;
    }

    // Fazendo a transição para a próxima fase
    @Override
    public void proximo() {
        if (this.getFaseAtual().atividadeAtual == this.getFaseAtual().numAtividades - 1) {
            if (faseAtual == numFases - 1) {
                return;
            } else {
                this.fases[faseAtual].atividadeAtual = 0;
                ++this.faseAtual;
                getFaseAtual().proximo();
            }

        } else {
            getFaseAtual().proximo();
        }
    }

   // Fazendo a transição para a fase anterior
    @Override
    public void anterior() {
        if (faseAtual == 0) {
            if (getFaseAtual().atividadeAtual == 0) {
                recomecar();
            } else {
                fases[faseAtual].anterior();
            }
        } else if (getFaseAtual().atividadeAtual == 0) {
            --faseAtual;
            fases[faseAtual].atividadeAtual = fases[faseAtual].numAtividades;
            fases[faseAtual].anterior();
        } else {
            fases[faseAtual].anterior();
        }
    }

    // Obtendo a fase atual
    public Fase getFaseAtual() {
        return this.fases[faseAtual];
    }

    // Obtendo a fase em um determinado índice
    public Fase getFase(int index) {
        return this.fases[index];
    }

    // Obtendo o número da fase atual
    public int getNumFaseAtual() {
        return faseAtual;
    }

    // Definindo o número da fase atual
    public void setNumFaseAtual(int num) {
        if (num <= numFases) {
            this.faseAtual = num;
        }
    }

    // Adicionando nova fase ao vetor de fases do jogo
    protected void addFase(Fase novaFase) {
        if (numFases == MAXFASES - 1) {
            return;
        }
        this.fases[numFases++] = novaFase;
    }
}
