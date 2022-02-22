package Personagens;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Random;

public class SimplePersonagemFactory
{
    public static Jogador criaPersonagem()
    {
        InputStream cs;
        BufferedImage character;
        Jogador j;

        int posicaoXInicial = 50;
        int posicaoYInicial = 400;
        int height = 571;
        int width = 999;
        int largJog = 40;
        int altJog = 40;
        String path;
        float valor = RandomFloat.getRandom();

        try {
            if (valor <= 0.2) {
                path = "./res/character0.png";
            } else if (valor <= 0.4) {
                path = "./res/character1.png";
            } else if (valor <= 0.6) {
                path = "./res/character2.png";
            } else if (valor <= 0.8) {
                path = "./res/character3.png";
            } else if (valor <= 1) {
                cs = SimplePersonagemFactory
                    .getCharacter("./res/character4.png");
                
                character = ImageIO.read(cs);
                Jogador j = new Jogador(posicaoXInicial, posicaoYInicial, width, height, largJog, altJog, character);
            }

            
            cs = SimplePersonagemFactory
                .getCharacter(path);
            
            character = ImageIO.read(cs);
            Jogador j = new Jogador(posicaoXInicial, posicaoYInicial, width, height, largJog, altJog, character);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return j;
    }

    public static InputStream getCharacter(String path)
    {
        return getClass().getResourceAsStream("./res/character4.png");
    }
}
