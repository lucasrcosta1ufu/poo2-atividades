import java.util.Random;

/**
 * Write a description of class aleatorio here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class aleatorio
{
    public static void main() {
        Random aleatorio = new Random();
        float valor = aleatorio.nextFloat();
        System.out.println("Número gerado: " + valor);
    }
}
