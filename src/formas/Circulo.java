package formas;

import java.awt.Color;

/**
 * Classe que representa um círculo
 * @author Bruno
 */
public class Circulo extends Forma{
    
    /**
     * Raio do círculo
     */
    private double raio;
    
    /**
     * Construtor
     * @param cor       - Cor do círculo
     * @param raio      - Raio do círculo
     */
    public Circulo(Color cor, double raio) {
        super(cor);
        this.raio = raio;
    }

    /**
     * Retorna o diâmetro do círculo
     * @return 
     */
    public double getRaio() {
        return raio;
    }

    /**
     * Seta o diâmetro do círculo
     * @param raio 
     */
    public void setRaio(double raio) {
        this.raio = raio;
    }
    
}
