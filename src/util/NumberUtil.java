package util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * Classe utilitária para manipulação de números
 * @author Bruno
 */
public class NumberUtil {

    /**
     * Instância única para a geração
     */
    private static Random r = new Random();

    /**
     * Retorna um número inteiro aleatório
     * @param min - Número minímo
     * @param max - Número máximo
     * @return
     */
    public static int random(int min, int max){
        return min + r.nextInt(max - min + 1);
    }

    /**
     * Retorna um número inteiro aleatório
     * @param min - Número minímo
     * @param max - Número máximo
     * @return
     */
    public static double random(double min, double max){
        return min + (max - min) * r.nextDouble();
    }

    /**
     * Arredonda um número
     * @param number - Número
     * @param dec    - Casas decimais
     * @return
     */
    public static double round(double number, int dec){
        double x = Math.pow(10, dec);
        return Math.round(number * x) / x;
    }
}
