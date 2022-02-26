package game.Personagem;

import game.Ataque.AtaqueMedio;
import game.Helpers.Dir;
import java.io.IOException;

public class Mago extends Personagem {
    private static final String PATH = Dir.imagePath() + "/character2.png";

    public Mago() throws IOException {
        super("Mago", Mago.PATH);
        String descricao = "Mussum Ipsum, cacilds vidis litro abertis."
            + "Si num tem leite então bota uma pinga aí cumpadi!"
            + "Quem num gosta di mim que vai caçá sua turmis!"
            + "Delegadis gente finis, bibendum egestas augue arcu ut est."
            + "Per aumento de cachacis, eu reclamis.";
        
        super.setAtaque(new AtaqueMedio());
        super.setDescricao(descricao);
    }
}
