package Personagens;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Random;

public class SimplePersonagemFactory
{
    public static Personagem criaPersonagem()
    {
        InputStream cs;
        BufferedImage character;
        Personagem jogador;

        int posicaoXInicial = 50;
        int posicaoYInicial = 400;
        int height = Game.height;
        int width = Game.width;
        int wJogador = 40;
        int hJogador = 40;
        float valor = RandomFloat.getRandom();

        String path = "";

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
                path = "./res/character4.png";
            }
            
            cs = SimplePersonagemFactory
                .getCharacter(path);
            
            character = ImageIO.read(cs);

            wJogador = character.getWidth();
            hJogador = character.getHeight();

            Personagem jogador = new Jogador(
                posicaoXInicial,
                posicaoYInicial,
                width,
                height,
                wJogador,
                hJogador,
                character
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jogador;
    }

    public static Personagem createMago()
    {
        return new Mago();
    }

    public static Personagem createPaladino()
    {
        return new Paladino();
    }

    public static Personagem createSacerdote()
    {
        return new Sacerdote();
    }

    public static Personagem createAssassino()
    {
        return new Assassino();
    }

    public static Personagem createDruida()
    {
        return new Druida();
    }

    public static InputStream getCharacter(String path)
    {
        return getClass().getResourceAsStream(path);
    }
}
