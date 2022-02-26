package game.Personagem;

import game.Ataque.AtaqueFraco;

public class Druida extends Personagem {
    private static final String PATH = "res\\character0.png";

    public Druida() {
        super("Druida", Druida.PATH);
        String descricao = "Mussum Ipsum, cacilds vidis litro abertis."
            + "Si num tem leite então bota uma pinga aí cumpadi!"
            + "Quem num gosta di mim que vai caçá sua turmis!"
            + "Delegadis gente finis, bibendum egestas augue arcu ut est."
            + "Per aumento de cachacis, eu reclamis.";
        
        super.setAtaque(new AtaqueFraco());
        super.setDescricao(descricao);
    }
}
