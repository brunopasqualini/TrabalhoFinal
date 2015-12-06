package formas;

import java.awt.Color;

/**
 * Classe que possui os comportamentos básico da forma
 * @author Bruno
 */
public abstract class Forma {
    
    /**
     * Posição X
     */
    private double x;
    
    /**
     * Velocidade horizontal
     */
    private double velocidadeX;
    
    /**
     * Posição Y
     */
    private double y;
    
    /**
     * Velocidade vertical
     */
    private double velocidadeY;
    
    /**
     * Cor da forma
     */
    private Color cor;

    /**
     * Construtor
     * @param cor       - Cor da forma
     */
    public Forma(Color cor) {
        this.cor       = cor;
    }

    /**
     * Retorna a posição X da forma
     * @return 
     */
    public double getX() {
        return x;
    }

    /**
     * Seta a posição X da forma
     * @param x 
     * @return this
     */
    public Forma setX(double x) {
        this.x = x;
        return this;
    }

    /**
     * Retorna a velocidade horizontal da forma
     * @return 
     */
    public double getVelocidadeX() {
        return velocidadeX;
    }

    /**
     * Seta a velocidade horizontal da forma
     * @param velocidade 
     * @return this
     */
    public Forma setVelocidadeX(double velocidade) {
        this.velocidadeX = velocidade;
        return this;
    }

    /**
     * Retorna a posição Y da forma
     * @return 
     */
    public double getY() {
        return y;
    }

    /**
     * Seta a posição Y da forma
     * @param y
     * @return this
     */
    public Forma setY(double y) {
        this.y = y;
        return this;
    }

    /**
     * Retorna a velocidade vertical da forma
     * @return 
     */
    public double getVelocidadeY() {
        return velocidadeY;
    }

    /**
     * Seta a velocidade vertical da forma
     * @param velocidade 
     * @return this
     */
    public Forma setVelocidadeY(double velocidade) {
        this.velocidadeY = velocidade;
        return this;
    }
    
    /**
     * Retorna a cor da forma
     * @return 
     */
    public Color getCor() {
        return cor;
    }

    /**
     * Seta a cor da forma
     * @param cor 
     * @return this
     */
    public Forma setCor(Color cor) {
        this.cor = cor;
        return this;
    }
    
}
