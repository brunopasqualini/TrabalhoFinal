
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * ****************************************************************************
 * Compilation: javac BouncingBall.java Execution: java BouncingBall
 * Dependencies: StdDraw.java
 *
 * Implementation of a 2-d bouncing ball in the box from (-1, -1) to (1, 1).
 *
 * % java BouncingBall
 *
 *****************************************************************************
 */
public class BouncingBall {

    private static Random r = new Random();

    public static void main(String[] args) {
        // set the scale of the coordinate system
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);

        new Thread(new BouncingBallThread()).start();
    }

    private static class BouncingBallThread implements Runnable {
        // Colocar uma classe com array de elementos, assim só ela irá usar o StdDraw.clear(StdDraw.WHITE) 
        // Classe bola possui raio e posicao X,Y
        // e todos os elementos serão impressos de uma vez só

        @Override
        public void run() {
            double posicaoHorizontalBarra = 0;
            double posicaoHorizontalBola = 0.480, posicaoVerticalBola = 0.860;  // position
            double vx = 0.015, vy = 0.023;     // velocity
            double radius = 0.05;
            int nivel = 35;

            // main animation loop
            while (true) {

                if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
                    //Movimenta a barra, caso nao esteja na parede
                    if (posicaoHorizontalBarra >= -0.74) {
                        posicaoHorizontalBarra -= 0.02;
                    }
                } else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
                    //Movimenta a barra, caso nao esteja na parede
                    if (posicaoHorizontalBarra <= 0.74) {
                        posicaoHorizontalBarra += 0.02;
                    }
                }

                //Impede que a bola passe pelas laterais
                if (Math.abs(posicaoHorizontalBola) > 1.0 - radius) {
                    vx = -vx;
                }

                //Imprede que a bola passe pra cima
                if (posicaoVerticalBola > 1.0 - radius) {
                    vy = -vy;
                }

                //Compara as posicoes da bola e da barra, caso forem iguais, rebate
                if (((posicaoVerticalBola - radius) <= -0.947) && posicaoHorizontalBola < (posicaoHorizontalBarra + 0.25)
                        && (posicaoHorizontalBola > (posicaoHorizontalBarra - 0.25))) {
                    vy = -vy;
                    System.out.println(posicaoVerticalBola + "voltou");
                    nivel --;
                } else if ((posicaoVerticalBola) < -0.944) {
                    System.out.println("perdeu");
                    break;
                }

                // update position
                posicaoHorizontalBola = posicaoHorizontalBola + vx;
                posicaoVerticalBola = posicaoVerticalBola + vy;
                // clear the background
                StdDraw.clear(StdDraw.WHITE);

                // draw ball on the screen
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledRectangle(posicaoHorizontalBarra, -0.999, 0.25, 0.055);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledCircle(posicaoHorizontalBola, posicaoVerticalBola, radius);

                // display and pause for 20 ms
                StdDraw.show(nivel);
                System.out.println(nivel);
            }
        }
    }
}
