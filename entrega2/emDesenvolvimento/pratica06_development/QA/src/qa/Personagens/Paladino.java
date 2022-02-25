package qa.Personagens;

import qa.Ataque.AtaqueForte;

public class Paladino extends Personagem {
    private static final String PATH = "res\\character1.png";

    public Paladino() {
        super("Paladino", Paladino.PATH);
        String descricao = "Mussum Ipsum, cacilds vidis litro abertis."
            + "Si num tem leite então bota uma pinga aí cumpadi!"
            + "Quem num gosta di mim que vai caçá sua turmis!"
            + "Delegadis gente finis, bibendum egestas augue arcu ut est."
            + "Per aumento de cachacis, eu reclamis.";
        
        super.setAtaque(new AtaqueForte());
        super.setDescricao(descricao);
    }
}
