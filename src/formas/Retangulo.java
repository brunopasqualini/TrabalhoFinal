package formas;

import java.awt.Color;

/**
 * Classe que representa um retângulo
 * @author Bruno
 */
public class Retangulo extends Forma{
    
    /**
     * Altura do retângulo
     */
    private double altura;
    
    /**
     * Largura do retângulo
     */
    private double largura;
    
    /**
     * Construtor
     * @param cor       - Cor do retângulo
     * @param altura    - Largura do retângulo
     * @param largura   - Largura do retângulo
     */
    public Retangulo(Color cor, double altura, double largura) {
        super(cor);
        this.altura = altura;
        this.largura = largura;
    }

    /**
     * Retorna a altura do retângulo
     * @return 
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Seta a altura do retângulo
     * @param altura 
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * Retorna a largura do retângulo
     * @return 
     */
    public double getLargura() {
        return largura;
    }

    /**
     * Seta a largura do retângulo
     * @param largura 
     */
    public void setLargura(double largura) {
        this.largura = largura;
    }
    
}
