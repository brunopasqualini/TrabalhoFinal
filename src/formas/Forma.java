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
     * Posição Y
     */
    private double y;
    
    /**
     * Cor da forma
     */
    private Color cor;
    
    /**
     * Descrição da forma
     */
    private String descricao;

    /**
     * Construtor
     * @param descricao - Descrição da forma
     * @param cor       - Cor da forma
     */
    public Forma(String descricao, Color cor) {
        this.descricao = descricao;
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
     */
    public void setX(double x) {
        this.x = x;
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
     */
    public void setY(double y) {
        this.y = y;
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
     */
    public void setCor(Color cor) {
        this.cor = cor;
    }

    /**
     * Retorna a descrição da forma
     * @return 
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Seta a descrição da forma
     * @param descricao 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
