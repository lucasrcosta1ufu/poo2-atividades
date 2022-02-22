import Personagens.SimplePersonagemFactory;

import java.awt.Graphics;
import java.awt.Graphics2D;

class Game
{
    private static int width = 999;
    private static int height = 571;
    private Personagens[] personagens = new Personagem[5];
    private Graphics2D g2d;

    public void jogar()
    {
        g2d = (Graphics2D) g;
        autoGeneratePersonagens();


    }

    public void autoGeneratePersonagens()
    {
        for (personagens : personagem) {
            personagem = SimplePersonagemFactory
                .criaPersonagem();
        }
    }

    public void drawPersonagem(Personagens personagem, int posX, int posY)
    {
        g2d.drawImage(
            personagens.getCharacter(), posX, posY, Game.width, Game.height, null
        );
    }
}