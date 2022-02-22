import java.util.Observer;
import java.util.Observable;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Robo implements Observer {
    private RoboEstado vida;
    private int quantidade;
    private int x;
    private int y;
    private String nome;
    private Corre c;
    private Ataca a;
    private int maxX, maxY;
    private int width, height;
    private Color cor;
    private BufferedImage image;

    public Robo(int x, int y, int maxX, int maxY, int width, int height, String nome, Color cor, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.maxX = maxX - width;
        this.maxY = maxY - height;
        this.nome = nome;
        this.cor = cor;
        this.image = image;
        this.width = width;
        this.height = height;

        this.vida = new RoboNormal(this);
        this.setQuantidade(70);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int heigth) {
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public RoboEstado getVida() {
        return this.vida;
    }

    public void setVida(RoboEstado vida) {
        this.vida = vida;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
        // System.out.println("Posicao do Robo: ("+this.x+","+this.y+")");
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public Color getCor() {
        return this.cor;
    }

    public void setAvatar(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getAvatar() {
        return this.image;
    }

    public void recebeAtaque(int ataque) {
        vida.dano(ataque);
    }

    public void recompensa() {
        vida.ganhaVida();
    }

    public void update(Observable subject, Object arg) {
        Jogador jogador = (Jogador) subject;

        // se estiver em distancia de ataque
        if ((Math.abs(this.x - jogador.getX()) == 0) && (Math.abs(this.y - jogador.getY()) == 0)) {
            jogador.recebeAtaque(this.getA().atacar());

            if (Math.random() < 0.5) {
                jogador.setPos(
                    jogador.getX() + (int) (100 * Math.random()),
                    jogador.getY() - (int) (100 * Math.random())
                );
            } else {
                jogador.setPos(
                    jogador.getX() - (int) (100 * Math.random()),
                    jogador.getY() + (int) (100 * Math.random())
                );
            }

        } else {
            // se precisa andar para frente
            if (jogador.getX() > this.x) {
                this.moveToRight((int) (5 * Math.random()));
            } else {
                this.moveToLeft((int) (5 * Math.random()));
            }
            // se precisa andar para tras
            if (jogador.getY() > this.y) {
                this.moveToDown((int) (5 * Math.random()));
            } else {
                this.moveToUp((int) (5 * Math.random()));
            }

        }

        if (jogador.getX() < 0) {
            jogador.setX(100);
        }
        if (jogador.getY() < 0) {
            jogador.setY(100);
        }

    }

    // ------------------------------------------------ //

    public Corre getC() {
        return this.c;
    }

    public void setC(Corre c) {
        this.c = c;
    }

    public Ataca getA() {
        return this.a;
    }

    public void setA(Ataca a) {
        this.a = a;
    }

    public void corrida() {
        c.correr();
    }

    public void ataque() {
        a.atacar();
    }

    public void moveToUp(int moviment) {
        if (this.y - moviment >= 0) {
            this.setY(this.getY() - moviment);
        } else {
            this.y = 0;
        }
    }

    public void moveToDown(int moviment) {
        if (this.y + moviment <= this.maxY) {
            this.setY(this.getY() + moviment);
        } else {
            this.y = this.maxY;
        }
    }

    public void moveToLeft(int moviment) {
        if (this.x - moviment >= 0) {
            this.setX(this.getX() - moviment);
        } else {
            this.x = 0;
        }
    }

    public void moveToRight(int moviment) {
        if (this.x + moviment <= this.maxX) {
            this.setX(this.getX() + moviment);
        } else {
            this.x = this.maxX;
        }
    }
}