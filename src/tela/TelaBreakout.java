package tela;

import formas.Circulo;
import formas.Retangulo;
import java.awt.event.KeyEvent;

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
     * Cria as forma na tela
     */
    @Override
    protected void criaFormas() {
        this._circle    = new Circulo("circle", 0.05);
        this._bottomBar = new Retangulo("bottom_bar", 0.055, 0.25);
        this.addForma(this._circle)
            .addForma(this._bottomBar);
    }

    /**
     * Imprime os elementos na tela
     */
    @Override
    protected void imprime() {
        while(true){
            
        }
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
