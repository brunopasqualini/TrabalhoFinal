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
    private int renderTime;

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
        //Formas iniciais
        this.addForma(this._bottomBar = new Retangulo(StdDraw.RED, 0.055, 0.25))
            .addForma(this._circle    = this.getNewCirculo());

        this._bottomBar.setY(-0.999);
        this._circle.setCor(StdDraw.BLUE).setVelocidadeX(0.015).setVelocidadeY(0.023);
    }

    /**
     * Imprime os elementos na tela
     */
    @Override
    public void imprime() {
        this.renderTime = 15;
        loopPrincipal:
        while(true){
            //Tecla esquerda
            if(this.canBarMoveLeft())
                this._bottomBar.setX(this._bottomBar.getX() - 0.05);
            //Tecla Direita
            else if(this.canBarMoveRight())
                this._bottomBar.setX(this._bottomBar.getX() +  0.05);

            for (Forma forma : this.getFormasByType("circulo")) {
                Circulo c = (Circulo) forma;
                //Verifica colisão com a parede
                if(this.canCircleMoveHorizontal(c))
                    c.setVelocidadeX(-c.getVelocidadeX());
                //Verifica colisão com o teto
                if(this.canCircleMoveUp(c))
                    c.setVelocidadeY(-c.getVelocidadeY());
                //Verifica colisão com a barra
                else if(this.checkCollisionCircleBar(c)){
                    c.setVelocidadeY(-c.getVelocidadeY());
                    this.renderTime -= 0.5;
                    this.addForma(this.getNewCirculo());
                }
                //Verifica colisão com o chão
                else if(!this.canCircleMoveDown(c)){
                    break loopPrincipal;
                }
                c.setX(c.getX() + c.getVelocidadeX()).setY(c.getY() + c.getVelocidadeY());
            }
            StdDraw.clear(formas.size() % (NumberUtil.random(4, 20)) == 0 ? StdDraw.getRandomColor() : StdDraw.WHITE);
            for (Forma forma : formas) {
                this.imprimeForma(forma);
            }
            StdDraw.show(this.renderTime);
        }
        StdDraw.picture(0, 0, "res/efeito.png", 2, 1.2);
        StdDraw.show(this.renderTime);
    }

    /**
     * Verifica se pode mover o círculo para cima
     * @param circle - Círculo
     * @return
     */
    private boolean canCircleMoveUp(Circulo circle){
        return circle.getY() > this.escalaY[1] - circle.getRaio();
    }
    
    /**
     * Verifica se pode mover o círculo para baixo
     * @param circle - Círculo
     * @return
     */
    private boolean canCircleMoveDown(Circulo circle){
        return circle.getY() > this.escalaY[0] + circle.getRaio();
    }

    /**
     * Verifica se o círculo colidiu com a barra
     * @param circle - Círculo
     * @return
     */
    private boolean checkCollisionCircleBar(Circulo circle){
        return circle.getY() - circle.getRaio() <= this.escalaY[0] + circle.getRaio() && 
               circle.getX() < this._bottomBar.getX() + this._bottomBar.getLargura() &&
               circle.getX() > this._bottomBar.getX() - this._bottomBar.getLargura();
    }

    /**
     * Verifica se pode mover o círculo horizontalmente
     * @param circle - Círculo
     * @return
     */
    private boolean canCircleMoveHorizontal(Circulo circle){
        return Math.abs(circle.getX()) > this.escalaX[1] - circle.getRaio();
    }

    /**
     * Verifica se a barra pode se mover para esquerda
     * @return
     */
    private boolean canBarMoveLeft(){
        return this.isLeftKeyPressed() && this._bottomBar.getX() >= this.escalaX[0] + this._bottomBar.getLargura();
    }

    /**
     * Verifica se a barra pode se mover para direita
     * @return
     */
    private boolean canBarMoveRight(){
        return this.isRightKeyPressed() && this._bottomBar.getX() <= this.escalaX[1] - this._bottomBar.getLargura();
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

    /**
     * Retorna um novo círculo
     * @return
     */
    private Circulo getNewCirculo(){
        Circulo c = new Circulo(StdDraw.getRandomColor(), 0.05);
        double x  = NumberUtil.round(NumberUtil.random(escalaX[0] + c.getRaio(), escalaX[1] - c.getRaio()), 3),
               y  = NumberUtil.round(NumberUtil.random(escalaY[0] + _bottomBar.getAltura() + c.getRaio(), escalaY[1] - c.getRaio()), 3);
        c.setX(x).setY(y).setVelocidadeX(NumberUtil.random(-0.015, 0.015)).setVelocidadeY(NumberUtil.random(-0.023, 0.023));
        return c;
    }
}
