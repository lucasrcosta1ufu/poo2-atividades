package game.Personagem;

import game.Helpers.Posicao;
import game.Utilities;
import java.io.IOException;

public class SimplePersonagemFactory {
    public static Jogador criaPersonagem(float valor)
        throws IOException
    {
        Jogador personagem = null;

        // int posicaoXInicial = 50;
        // int posicaoYInicial = 400;
        // int height = Game.height;
        // int width = Game.width;
        // int wJogador = 40;
        // int hJogador = 40;

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
            personagem = SimplePersonagemFactory
                .createAssassino();

        }

        return personagem;
    }

    public static Mago createMago()
        throws IOException
    {
        return new Mago(
            (Posicao) Utilities.personagemData.get("posicao"),
            (Integer) Utilities.personagemData.get("width"),
            (Integer) Utilities.personagemData.get("height")
        );
    }

    public static Paladino createPaladino()
        throws IOException
    {
        return new Paladino(
            (Posicao) Utilities.personagemData.get("posicao"),
            (Integer) Utilities.personagemData.get("width"),
            (Integer) Utilities.personagemData.get("height")
        );
    }

    public static Sacerdote createSacerdote()
        throws IOException
    {
        return new Sacerdote(
            (Posicao) Utilities.personagemData.get("posicao"),
            (Integer) Utilities.personagemData.get("width"),
            (Integer) Utilities.personagemData.get("height")
        );
    }

    public static Assassino createAssassino()
        throws IOException
    {
        return new Assassino(
            (Posicao) Utilities.personagemData.get("posicao"),
            (Integer) Utilities.personagemData.get("width"),
            (Integer) Utilities.personagemData.get("height")
        );
    }

    public static Druida createDruida()
        throws IOException
    {
        return new Druida(
            (Posicao) Utilities.personagemData.get("posicao"),
            (Integer) Utilities.personagemData.get("width"),
            (Integer) Utilities.personagemData.get("height")
        );
    }
}
