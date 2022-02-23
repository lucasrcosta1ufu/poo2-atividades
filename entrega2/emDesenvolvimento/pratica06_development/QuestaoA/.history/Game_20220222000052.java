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
}