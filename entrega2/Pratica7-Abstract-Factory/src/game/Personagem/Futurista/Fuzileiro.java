package game.Personagem.Futurista;

import game.Ataque.AtaqueForte;
import game.Helpers.Posicao;
import game.Personagem.Jogador;
import game.Utilities;
import java.io.IOException;

public class Fuzileiro extends Jogador {
    public Fuzileiro(Posicao posicao, int width, int height)
        throws IOException
    {
        super(
            "fuzileiro",
            posicao,
            width,
            height,
            Utilities.futuristicData.characterPaths.get("fuzileiro")
        );
        
        String descricao = "Mussum Ipsum, cacilds vidis litro abertis."
            + "Si num tem leite então bota uma pinga aí cumpadi!"
            + "Quem num gosta di mim que vai caçá sua turmis!"
            + "Delegadis gente finis, bibendum egestas augue arcu ut est."
            + "Per aumento de cachacis, eu reclamis.";
        
        super.setAtaque(AtaqueForte.getInstance());
        super.setDescricao(descricao);
    }
}
