package game.Personagem;

import game.Ataque.AtaqueFraco;
import game.Helpers.Posicao;
import game.Utilities;
import java.io.IOException;

public class Sacerdote extends Jogador {
    public Sacerdote(Posicao posicao, int width, int height)
        throws IOException
    {
        super(
            "Sacerdote",
            posicao,
            width,
            height,            
            Utilities.characterPaths.get("sacerdote")
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
