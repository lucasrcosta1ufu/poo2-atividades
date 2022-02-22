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
        Personagem personagem;

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
                personagem = SimplePersonagemFactory
                    .createDruida();
            } else if (valor <= 0.4) {
                personagem = SimplePersonagemFactory
                    .createPaladino();
            } else if (valor <= 0.6) {
                personagem = SimplePersonagemFactory
                    .createMago();
            } else if (valor <= 0.8) {
                personagem = SimplePersonagemFactory
                    .createSacerdote();
            } else if (valor <= 1) {
                personagem = SimplePersonagemFactory.createAssassino();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personagem;
    }

    public static Mago createMago()
    {
        return new Mago();
    }

    public static Paladino createPaladino()
    {
        return new Paladino();
    }

    public static Sacerdote createSacerdote()
    {
        return new Sacerdote();
    }

    public static Assassino createAssassino()
    {
        return new Assassino();
    }

    public static Druida createDruida()
    {
        return new Druida();
    }
}
