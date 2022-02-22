package Personagens;

import Ataque.Ataca;
import Helpers.Image;

public abstract class Personagem {
    private String tipo;
    private Ataca ataque;
    private BufferedImage character;

    public Personagem(BufferedImage character) {
        this.character = character;
    }

    public Personagem(String path) {
        this.character = Image.getImage(path);
    }

    public Personagem(String tipo, BufferedImage character) {
        this.tipo = tipo;
        this.character = character;
    }

    public Personagem(String tipo, String path) {
        this.tipo = tipo;
        this.character = Image.getImage(path);
    }

    public BufferedImage getCharacter() {
        return this.character;
    }

    public void setCharacter(BufferedImage character) {
        this.character = character;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Ataca getAtaque() {
        return this.ataque;
    }

    public void setAtaque(Ataca ataque) {
        this.ataque = ataque;
    }
}
