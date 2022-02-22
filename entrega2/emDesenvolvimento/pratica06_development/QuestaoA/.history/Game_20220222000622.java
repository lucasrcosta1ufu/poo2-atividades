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

    public void paint(Graphics g) {
        Robo robo;
        super.paint(g); // The call to "super.paint(g)", cleans the screen

        Graphics2D g2d = (Graphics2D) g;

        escudos.forEach((Escudo escudo) -> {
            g2d.drawImage(escudo.getImage(), ((Escudo) escudo).getX(), ((Escudo) escudo).getY(), 30, 30, null);
        });
        
        this.drawJogador(g2d, jogador, 850, 2);
        g2d.drawString(getPorcentagemVida(jogador, "Jogador:"), 856, 21);

        // ROBO 1------------ //
        if (robos.size() >= 1) {
            robo = robos.get(0);
            this.drawRobo(g2d, robo, 850, 32);
            g2d.drawString(getPorcentagemVida(robo, robo.getNome() + ":"), 856, 51);

        }

        // ROBO 2------------- //
        if (robos.size() >= 2) {
            robo = robos.get(1);
            this.drawRobo(g2d, robo, 850, 62);
            g2d.drawString(getPorcentagemVida(robo, robo.getNome() + ":"), 856, 81);
        }

        // ROBO 3------------- //
        if (robos.size() == 3) {
            robo = robos.get(2);
            this.drawRobo(g2d, robo, 850, 92);
            g2d.drawString(getPorcentagemVida(robo, robo.getNome() + ":"), 856, 111);
        }

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