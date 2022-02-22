import Personagens.SimplePersonagemFactory;

import java.awt.Graphics;
import java.awt.Graphics2D;

class Game
{
    private static int width = 999;
    private static int height = 571;
    private Personagem[] personagens = new Personagem[5];
    private Graphics2D g2d;

    public void jogar()
    {
        autoGeneratePersonagens();

        while (true) {
            jogador.show();
            game.repaint();
            Thread.sleep(50);
        }
        System.exit(0);
    }

    public void paint(Graphics g) {
        super.paint(g); // The call to "super.paint(g)", cleans the screen

        g2d = (Graphics2D) g;

        drawPersonagem(0, 0, 0);
        drawPersonagem(1, 10, 10);
        drawPersonagem(2, 20, 20);
        drawPersonagem(3, 30, 30);
        drawPersonagem(4, 40, 40);
    }

    public void autoGeneratePersonagens()
    {
        for (personagens : personagem) {
            personagem = SimplePersonagemFactory
                .criaPersonagem();
        }
    }

    public void drawPersonagem(Personagem personagem, int posX, int posY)
    {
        g2d.drawImage(
            personagens.getCharacter(), posX, posY, Game.width, Game.height, null
        );
    }

    public void drawPersonagem(int index, int posX, int posY)
    {
        Personagem personagem = personagens[index];
        g2d.drawImage(
            personagens.getCharacter(), posX, posY, Game.width, Game.height, null
        );
    }
}