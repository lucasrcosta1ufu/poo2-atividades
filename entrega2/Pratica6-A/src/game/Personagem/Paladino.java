package game.Personagem;

import game.Ataque.AtaqueForte;
import game.Helpers.Posicao;
import game.Utilities;
import java.io.IOException;

public class Paladino extends Jogador {
    public Paladino(Posicao posicao, int width, int height)
        throws IOException
    {
        super(
            "Paladino",
            posicao,
            width,
            height,
            Utilities.characterPaths.get("paladino")
        );
        String descricao = "Mussum Ipsum, cacilds vidis litro abertis."
            + "Si num tem leite então bota uma pinga aí cumpadi!"
            + "Quem num gosta di mim que vai caçá sua turmis!"
            + "Delegadis gente finis, bibendum egestas augue arcu ut est."
            + "Per aumento de cachacis, eu reclamis.";
        
        super.setAtaque(new AtaqueForte());
        super.setDescricao(descricao);
    }
}
