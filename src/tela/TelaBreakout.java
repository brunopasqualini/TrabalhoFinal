package tela;

import formas.Circulo;
import formas.Forma;
import formas.Retangulo;
import java.awt.event.KeyEvent;
import util.NumberUtil;

/**
 * Classe que representa o jogo do Atari TelaBreakout
 * @author Bruno
 */
public class TelaBreakout extends Tela{
    
    /**
     * Tempo para próxima renderização em millisegundos
     */
    private int tempoRenderizacao;
    
    /**
     * Círculo
     */
    private Circulo _circle;
    
    /**
     * Barra inferior
     */
    private Retangulo _bottomBar;

    /**
     * Cria as formas iniciais na tela
     */
    @Override
    protected void criaFormas() {
        this._circle    = new Circulo("circle", StdDraw.BLUE, 0.05);
        this._bottomBar = new Retangulo("bottom_bar", StdDraw.RED, 0.055, 0.25);
        this.addForma(this._circle)
            .addForma(this._bottomBar);
    }

    /**
     * Imprime os elementos na tela
     */
    @Override
    public void imprime() {
        //Seta as posições inicias
        this._bottomBar.setY(-0.999);
        double X = NumberUtil.round(NumberUtil.random(escalaX[0] + _circle.getDiametro(), escalaX[1] - _circle.getDiametro()), 3),
               Y = NumberUtil.round(NumberUtil.random(escalaY[0] + _bottomBar.getAltura() + _circle.getDiametro(), escalaY[1] - _circle.getDiametro()), 3);
        this._circle.setX(X);
        this._circle.setY(Y);        
        
        while(true){
            //Tecla esquerda
            if(this.isLeftKeyPressed() && this.canBarMoveHorizontal())
                this._bottomBar.setX(this._bottomBar.getX() - 0.02);
            //Tecla Direita
            else if(this.isRightKeyPressed() && this.canBarMoveHorizontal())
                this._bottomBar.setX(this._bottomBar.getX() +  0.02);
            
            StdDraw.clear();
            for (Forma forma : formas) {
                this.imprimeForma(forma);
            }
            StdDraw.show(20);
        }
    }
    
    /**
     * Verifica se pode mover o círculo para cima
     * @return 
     */
    private boolean canCircleMoveUp(){
        return Math.abs(this._circle.getY()) < this.escalaY[1] - this._circle.getDiametro();
    }
    
    /**
     * Verifica se pode mover o círculo horizontalmente
     * @return 
     */
    private boolean canCircleMoveHorizontal(){
        return Math.abs(this._circle.getX()) < this.escalaX[1] - this._circle.getDiametro();
    }
    
    /**
     * Verifica se pode mover a barra inferior horizontalmente
     * @return 
     */
    private boolean canBarMoveHorizontal(){
        if(this._bottomBar.getX() <= 0)
            return this._bottomBar.getX() >= this.escalaX[0] + this._bottomBar.getLargura();
        else 
            return this._bottomBar.getX() <= this.escalaX[1] - this._bottomBar.getLargura();
    }
    
    /**
     * Verifica se a seta esquerda está sendo pressionada
     * @return 
     */
    private boolean isLeftKeyPressed(){
        return StdDraw.isKeyPressed(KeyEvent.VK_LEFT) || StdDraw.isKeyPressed(KeyEvent.VK_A);
    }
    
    /**
     * Verifica se a seta direita está sendo pressionada
     * @return 
     */
    private boolean isRightKeyPressed(){
        return StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) || StdDraw.isKeyPressed(KeyEvent.VK_D);
    }
}
