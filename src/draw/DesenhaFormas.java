package draw;

import formas.Forma;
import java.util.ArrayList;

/**
 * Classe que manipula diferentes formas para renderização
 * @author Bruno
 */
public abstract class DesenhaFormas {
    
    /**
     * Tempo para próxima renderização em milesegundos
     */
    protected int tempoRenderizacao;
    
    /**
     * Lista de formas que vão ser renderizadas
     */
    protected ArrayList<Forma> formas;

    /**
     * Construtor
     */
    public DesenhaFormas() {
        this.formas = new ArrayList();
    }
    
    /**
     * Adiciona uma forma na lista
     * @param forma 
     */
    public void addForma(Forma forma){
        this.formas.add(forma);
    }
    
    /**
     * Método para renderizar as formas
     */
    protected abstract void imprime();
}
