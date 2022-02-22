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

    public void drawJogador(Graphics2D g2d, Personagens personagens, int posX, int posY) {
        g2d.drawImage(
            personagens.getAvatar(), 10, 10, 40, 40, null
        );
    }
}