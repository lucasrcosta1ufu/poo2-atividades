package Personagens;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Random;

public class SimplePersonagemFactory {
    public static Jogador criaPersonagem() {
        InputStream cs;
        BufferedImage character;
        Jogador j;
        int posicaoXInicial = 50;
        int posicaoYInicial = 400;
        int height = 571;
        int width = 999;
        int largJog = 40;
        int altJog = 40;
        Random aleatorio = new Random();
        float valor = aleatorio.nextFloat();

        if (valor <= 0.2) {
            cs = getClass().getResourceAsStream("./res/character0.png");
            try {
                character = ImageIO.read(cs);
                j = new Jogador(posicaoXInicial, posicaoYInicial, width, height, largJog, altJog, character);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (valor <= 0.4) {
            cs = getClass().getResourceAsStream("./res/character1.png");
            try {
                character = ImageIO.read(cs);
                Jogador j = new Jogador(posicaoXInicial, posicaoYInicial, width, height, largJog, altJog, character);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (valor <= 0.6) {
            cs = getClass().getResourceAsStream("./res/character2.png");
            try {
                character = ImageIO.read(cs);
                Jogador j = new Jogador(posicaoXInicial, posicaoYInicial, width, height, largJog, altJog, character);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (valor <= 0.8) {
            cs = getClass().getResourceAsStream("./res/character3.png");
            try {
                character = ImageIO.read(cs);
                Jogador j = new Jogador(posicaoXInicial, posicaoYInicial, width, height, largJog, altJog, character);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (valor <= 1) {
            cs = getClass().getResourceAsStream("./res/character4.png");
            try {
                character = ImageIO.read(cs);
                Jogador j = new Jogador(posicaoXInicial, posicaoYInicial, width, height, largJog, altJog, character);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return j;
    }
}
