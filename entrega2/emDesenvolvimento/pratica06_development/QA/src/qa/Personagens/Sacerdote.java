package qa.Personagens;

import qa.Ataque.AtaqueFraco;

public class Sacerdote extends Personagem {
    private static final String PATH = "res\\character3.png";

    public Sacerdote() {
        super("Sacerdote", Sacerdote.PATH);
        String descricao = "Mussum Ipsum, cacilds vidis litro abertis."
            + "Si num tem leite então bota uma pinga aí cumpadi!"
            + "Quem num gosta di mim que vai caçá sua turmis!"
            + "Delegadis gente finis, bibendum egestas augue arcu ut est."
            + "Per aumento de cachacis, eu reclamis.";
        
        super.setAtaque(new AtaqueFraco());
        super.setDescricao(descricao);
    }
}
