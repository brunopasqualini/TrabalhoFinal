package formas;

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
}
