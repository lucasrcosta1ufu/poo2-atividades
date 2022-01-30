
import java.awt.image.BufferedImage;
import java.io.InputStream;

/**
 * Write a description of class EscudoFraco here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EscudoFraco extends Escudo
{
    public EscudoFraco (BufferedImage image) {
        super(image);
        super.setDefesa(1);
    }
}

