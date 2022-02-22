package Helpers;

import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Image {
    public static InputStream getStream(String path) {
        return new Image().getClass().getResourceAsStream(path);
    }

    public static BufferedImage getImage(String path) throws IOException {
        return ImageIO.read(Image.getStream(path));
    }
}