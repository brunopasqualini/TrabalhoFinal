
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
            double x = 0;
            double rx = 0.480, ry = 0.860;  // position
            double vx = 0.015, vy = 0.023;     // velocity
            double radius = 0.05;              // radius

            // main animation loop
            while (true) {
                if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
                    //margem da barra, nao deixa a barra passar o cenario
                    if (x >= -0.74) {
                        x -= 0.02;
                    }
                } else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
                    //margem da barra, nao deixa a barra passar o cenario
                    if (x <= 0.74) {
                        x += 0.02;
                    }
                }

                //y = vertical
                // x = horizontal
                // nao deixa sair das laterais
                if (Math.abs(rx + vx) > 1.0 - radius) {
                    vx = -vx;
                    System.out.println(rx);
                }

                // nao deixa sair em cima
                if (Math.abs(ry + vy) > 1.0 - radius) {
                    vy = -vy;
                    System.out.println(ry);
                }

                double posicaoBarraHorizontal = Math.abs(x) + 0.25;
                double posicaoBolaHorizontal = Math.abs(rx);

                //Compara as posicoes da bola e da barra, caso forem iguais, rebate
                if (((ry + vy) < -0.850) && posicaoBolaHorizontal < (posicaoBarraHorizontal + 0.035)
                        && (posicaoBolaHorizontal > (posicaoBarraHorizontal - 0.35))) {
                            posicaoBolaHorizontal = -posicaoBolaHorizontal;
                            vy = -vy;
                            System.out.println(vy);
                }
                if (((ry + vy) < -0.900) && rx > (x + 0.035)
                        && (rx < (x - 0.35))) {
                            System.out.println("se fudep trouxa, menos uma vida");
                            break;
                    }

                // update position
                rx = rx + vx;
                ry = ry + vy;

                // clear the background
                StdDraw.clear(StdDraw.WHITE);

                // draw ball on the screen
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledRectangle(x, -0.935, 0.25, 0.035);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledCircle(rx, ry, radius);

                // display and pause for 20 ms
                StdDraw.show(59);
            }
        }
    }
}
