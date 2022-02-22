package Helpers;

import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Image {
    public static InputStream getStream(String path) {
        return getClass().getResourceAsStream(path);
    }

    public static BufferedImage getImage(String path) throws IOException {
        return ImageIO.read(Image.getStream(path));
    }
}