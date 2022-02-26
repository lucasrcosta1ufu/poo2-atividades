package game.Inimigo;

import game.Ataque.Ataque;
import game.Game;
import game.Helpers.Posicao;
import game.Personagem.Jogador;
import java.util.Observer;
import java.util.Observable;
import java.awt.Color;
import java.awt.image.BufferedImage;
import game.Movimento.Movimento;
import game.Utilities;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Robo implements Observer {
    private RoboEstado vida;
    private int quantidade;
    private int x;
    private int y;
    private String nome;
    private Movimento c;
    private Ataque a;
    private Posicao posicao;
    private Color cor;
    private BufferedImage image;
    private int width, height;

    public Robo(int x, int y, int width, int height, String nome, Color cor, BufferedImage image)
    {
        this.posicao = new Posicao(x, y, Utilities.WIDTH - width, Utilities.HEIGHT - height);
        this.nome = nome;
        this.cor = cor;
        this.image = image;
        this.width = width;
        this.height = height;

        this.vida = new RoboNormal(this);
        this.setQuantidade(70);
    }

    public Robo(Posicao posicao, int width, int height, String nome, Color cor, BufferedImage image)
    {
        this.posicao = posicao;
        this.nome = nome;
        this.cor = cor;
        this.image = image;
        this.width = width;
        this.height = height;

        this.vida = new RoboNormal(this);
        this.setQuantidade(70);
    }

    public Robo(int x, int y, int width, int height, String nome, Color cor, String path)
        throws IOException
    {
        this.posicao = new Posicao(x, y, Utilities.WIDTH - width, Utilities.HEIGHT - height);
        this.nome = nome;
        this.cor = cor;
        this.width = width;
        this.height = height;

        this.image = ImageIO.read(
            getClass().getResourceAsStream(path)
        );

        this.vida = new RoboNormal(this);
        this.setQuantidade(70);
    }

    public Robo(Posicao posicao, int width, int height, String nome, Color cor, String path)
        throws IOException
    {
        this.posicao = posicao;
        this.nome = nome;
        this.cor = cor;
        this.width = width;
        this.height = height;

        this.image = ImageIO.read(
            getClass().getResourceAsStream(path)
        );
        
        this.vida = new RoboNormal(this);
        this.setQuantidade(70);
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public RoboEstado getVida()
    {
        return this.vida;
    }

    public void setVida(RoboEstado vida)
    {
        this.vida = vida;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getX()
    {
        return this.posicao.getX();
    }

    public int getY()
    {
        return this.posicao.getY();
    }

    public void setX(int x)
    {
        this.posicao.setX(x);
    }

    public void setY(int y)
    {
        this.posicao.setY(y);
    }

    public void setPos(int x, int y)
    {
        this.posicao.setPos(x, y);
    }

    public void setCor(Color cor)
    {
        this.cor = cor;
    }

    public Color getCor()
    {
        return this.cor;
    }

    public void setAvatar(BufferedImage image)
    {
        this.image = image;
    }

    public BufferedImage getAvatar()
    {
        return this.image;
    }

    public void recebeAtaque(int ataque)
    {
        vida.dano(ataque);
    }

    public void recompensa()
    {
        vida.ganhaVida();
    }

    public void update(Observable subject, Object arg)
    {
        Jogador jogador = (Jogador) subject;

        // se estiver em distancia de ataque
        if (
            (Math.abs(this.getX() - jogador.getX()) == 0) &&
            (Math.abs(this.getY() - jogador.getY()) == 0)
        ) {
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
            if (jogador.getX() > this.getX()) {
                this.moveToRight((int) (5 * Math.random()));
            } else {
                this.moveToLeft((int) (5 * Math.random()));
            }
            // se precisa andar para tras
            if (jogador.getY() > this.getY()) {
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

    public Movimento getC()
    {
        return this.c;
    }

    public void setC(Movimento c)
    {
        this.c = c;
    }

    public Ataque getA()
    {
        return this.a;
    }

    public void setA(Ataque a)
    {
        this.a = a;
    }

    public void corrida()
    {
        c.correr();
    }

    public void ataque()
    {
        a.atacar();
    }

    public void moveToUp(int moviment)
    {
        if (this.getY() - moviment >= 0) {
            this.setY(this.getY() - moviment);
        } else {
            this.setY(0);
        }
    }

    public void moveToDown(int moviment)
    {
        if (this.getY() + moviment <= this.posicao.getMaxY()) {
            this.setY(this.getY() + moviment);
        } else {
            this.setY(this.posicao.getMaxY());
        }
    }

    public void moveToLeft(int moviment)
    {
        if (this.getX() - moviment >= 0) {
            this.setX(this.getX() - moviment);
        } else {
            this.setX(0);
        }
    }

    public void moveToRight(int moviment)
    {
        if (this.getX() + moviment <= this.posicao.getMaxX()) {
            this.setX(this.getX() + moviment);
        } else {
            this.setX(this.posicao.getMaxX());
        }
    }
}