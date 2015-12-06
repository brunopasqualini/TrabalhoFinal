package formas;

import java.awt.Color;

/**
 * Classe que representa um círculo
 * @author Bruno
 */
public class Circulo extends Forma{
    
    /**
     * Diâmetro do círculo
     */
    private double diametro;
    
    /**
     * Construtor
     * @param descricao - Descrição do círculo
     * @param cor       - Cor do círculo
     * @param diametro  - Diâmetro do círculo
     */
    public Circulo(String descricao, Color cor, double diametro) {
        super(descricao, cor);
        this.diametro = diametro;
    }

    /**
     * Retorna o diâmetro do círculo
     * @return 
     */
    public double getDiametro() {
        return diametro;
    }

    /**
     * Seta o diâmetro do círculo
     * @param diametro 
     */
    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }
    
}
