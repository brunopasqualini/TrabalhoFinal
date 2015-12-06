package tela;

import formas.Circulo;
import formas.Forma;
import formas.Retangulo;
import java.util.ArrayList;

/**
 * Classe que manipula diferentes formas para renderização
 * @author Bruno
 */
public abstract class Tela {

    /**
     * Lista de formas que vão ser renderizadas na tela
     */
    protected ArrayList<Forma> formas;

    /**
     * Escala X da tela[min, max]
     */
    protected final double[] escalaX;

    /**
     * Escala Y da tela[min, max]
     */
    protected final double[] escalaY;

    /**
     * Construtor
     */
    public Tela() {
        this.formas  = new ArrayList();
        this.escalaX = new double[]{-1.0, 1.0};
        this.escalaY = new double[]{-1.0, 1.0};
        this.setEscala();
        this.criaFormas();
    }

    /**
     * Método para renderizar os elementos na tela
     */
    public abstract void imprime();

    /**
     * Método que é chamado quando a tela é criada.
     * Aqui deve ser criado as formas iniciais.
     */
    protected abstract void criaFormas();

    /**
     * Adiciona uma forma na lista
     * @param forma
     * @return this
     */
    public Tela addForma(Forma forma){
        this.formas.add(forma);
        return this;
    }
    
    /**
     * Busca uma forma pela sua descrição
     * @param descricao - Descrição da forma
     * @return 
     */
    public Forma getForma(String descricao){
        for (Forma forma : this.formas) {
            if(forma.getDescricao().equals(descricao)) return forma;
        }
        return null;
    }

    /**
     * Seta a escala/proporção da tela
     */
    private void setEscala(){
        StdDraw.setXscale(this.escalaX[0], this.escalaX[1]);
        StdDraw.setYscale(this.escalaY[0], this.escalaY[1]);
    }
    
    /**
     * Desenha a forma na tela
     * @param forma 
     */
    protected void imprimeForma(Forma forma){
        StdDraw.setPenColor(forma.getCor());
        if(forma instanceof Retangulo){
            Retangulo retangulo = (Retangulo) forma;
            StdDraw.filledRectangle(forma.getX(), forma.getY(), retangulo.getLargura(), retangulo.getAltura());
        }
        else if(forma instanceof Circulo){
            Circulo circulo = (Circulo) forma;
            StdDraw.filledCircle(forma.getX(), forma.getY(), circulo.getDiametro());
        }
    }
}
