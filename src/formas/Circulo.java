package formas;

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
     */
    public Circulo() {}
    
    /**
     * Construtor
     * @param raio - Raio do círculo
     */
    public Circulo(double raio) {
        this.raio = raio;
    }

    /**
     * Retorna o raio do círculo
     * @return 
     */
    public double getRaio() {
        return raio;
    }

    /**
     * Seta o raio do círculo
     * @param raio 
     */
    public void setRaio(double raio) {
        this.raio = raio;
    }
    
}
