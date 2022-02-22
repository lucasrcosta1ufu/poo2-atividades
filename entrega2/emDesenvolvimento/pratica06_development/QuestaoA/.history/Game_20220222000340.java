import Personagens.SimplePersonagemFactory;

class Game
{
    private static int width = 999;
    private static int height = 571;
    private Personagens[] personagens = new Personagem[5];

    public void jogar()
    {
        autoGeneratePersonagens();


    }

    public void autoGeneratePersonagens()
    {
        for (personagens : personagem) {
            personagem = SimplePersonagemFactory
                .criaPersonagem();
        }
    }

    public void drawPersonagem(Graphics2D g2d, Personagens personagens, int posX, int posY)
    {
        g2d.drawImage(
            personagens.getCharacter(), posX, posY, Game.width, Game.height, null
        );
    }
}