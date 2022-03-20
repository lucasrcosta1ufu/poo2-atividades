package game.Personagem;

import game.Ataque.AtaqueFraco;
import game.Helpers.Posicao;
import game.Utilities;
import java.io.IOException;

public class Druida extends Jogador {
    public Druida(Posicao posicao, int width, int height)
        throws IOException
    {
        super(
            "Druida",
            posicao,
            width,
            height,
            Utilities.characterPaths.get("druida")
        );
        
        String descricao = "Mussum Ipsum, cacilds vidis litro abertis."
            + "Si num tem leite então bota uma pinga aí cumpadi!"
            + "Quem num gosta di mim que vai caçá sua turmis!"
            + "Delegadis gente finis, bibendum egestas augue arcu ut est."
            + "Per aumento de cachacis, eu reclamis.";
        
        super.setAtaque(AtaqueFraco.getInstance());
        super.setDescricao(descricao);
    }
}
