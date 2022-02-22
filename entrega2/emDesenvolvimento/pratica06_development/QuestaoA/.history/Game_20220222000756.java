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


    }

    public void paint(Graphics g) {
        super.paint(g); // The call to "super.paint(g)", cleans the screen

        g2d = (Graphics2D) g;
        
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