package qa.Personagens;

import qa.Ataque.Ataque;
import qa.Image;

public abstract class Personagem {
    private String tipo;
    private Ataque ataque;
    private Image character;
    private String descricao;

    public Personagem(String path)
    {
        this.character = new Image(path);
    }

    public Personagem(String tipo, String path)
    {
        this.tipo = tipo;
        this.character = new Image(path);
    }

    public Image getCharacter()
    {
        return this.character;
    }

    public void setCharacter(String path)
    {
        this.character = new Image(path);
    }

    public String getTipo()
    {
        return this.tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public Ataque getAtaque()
    {
        return this.ataque;
    }

    public void setAtaque(Ataque ataque)
    {
        this.ataque = ataque;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }
}
