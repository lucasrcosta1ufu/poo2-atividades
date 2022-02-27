package game.Personagem;

import game.Ataque.Ataque;
import game.States.Estado;
import game.States.EstadoNormal;
import game.Inimigo.Robo;
import game.Inimigo.RoboMorto;
import game.Escudo.Escudo;
import game.Game;
import game.Helpers.Posicao;
import java.util.Observable;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import game.Movimento.Movimento;
import game.Utilities;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Write ataque description of class Jogador here.
 * 
 * @author (your name)
 * @version (ataque version number or ataque date)
 */
public abstract class Jogador extends Observable {
    private int quantidade, width, height, numSuccessfulAtacks = 0;
    private String nome, tipo, descricao;
    private Movimento movimento;
    private Ataque ataque;
    private Estado vida;
    private Escudo escudo;
    private BufferedImage image;
    private final Posicao posicao;

    public Jogador(String tipo, int x, int y, int width, int height, BufferedImage image) {
        this.posicao = new Posicao(x, y, Game.WIDTH - width, Game.HEIGHT - height);
        this.image = image;
        this.width = width;
        this.height = height;
        this.quantidade = 70;
        this.vida = new EstadoNormal(this);
    }

    public Jogador(String tipo, int x, int y, int width, int height, String path)
        throws IOException
    {
        this.posicao = new Posicao(x, y, Utilities.WIDTH - width, Utilities.HEIGHT - height);
        this.width = width;
        this.height = height;
        this.quantidade = 70;  
        this.vida = new EstadoNormal(this);      
        this.image = ImageIO.read(
            getClass().getResourceAsStream(path)
        );
        
    }

    public Jogador(String tipo, Posicao posicao, int width, int height, BufferedImage image) {
        this.posicao = posicao;
        this.image = image;
        this.width = width;
        this.height = height;
        this.quantidade = 70;
        this.vida = new EstadoNormal(this);
    }

    public Jogador(String tipo, Posicao posicao, int width, int height, String path)
        throws IOException
    {
        this.posicao = posicao;
        this.width = width;
        this.height = height;
        this.quantidade = 70;
        this.vida = new EstadoNormal(this);
        
        this.image = ImageIO.read(
            getClass().getResourceAsStream(path)
        );
        
    }

    public Jogador(int x, int y, int width, int height, BufferedImage image) {
        this.posicao = new Posicao(
            x, y, Game.WIDTH - width, Game.HEIGHT - height
        );
        this.image = image;
        this.width = width;
        this.height = height;
        this.quantidade = 70;
        this.vida = new EstadoNormal(this);
    }

    public Jogador(int x, int y, int width, int height, String path)
        throws IOException
    {
        this.posicao = new Posicao(
            x, y, Utilities.WIDTH - width, Utilities.HEIGHT - height
        );
        this.width = width;
        this.height = height;
        this.quantidade = 70;
        this.vida = new EstadoNormal(this);
        
        this.image = ImageIO.read(
            getClass().getResourceAsStream(path)
        );
        
    }

    public Jogador(Posicao posicao, int width, int height, BufferedImage image)
    {
        this.posicao = posicao;
        this.image = image;
        this.width = width;
        this.height = height;
        this.quantidade = 70;
        this.vida = new EstadoNormal(this);
    }

    public Jogador(Posicao posicao, int width, int height, String path)
        throws IOException
    {
        this.posicao = posicao;
        this.width = width;
        this.height = height;
        this.quantidade = 70;
        this.vida = new EstadoNormal(this);
        
        this.image = ImageIO.read(
            getClass().getResourceAsStream(path)
        );        
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public Estado getVida()
    {
        return this.vida;
    }

    public void setVida(Estado vida)
    {
        this.numSuccessfulAtacks = 0;
        this.vida = vida;
    }

    public int getQuantidade()
    {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }

    public void recebeAtaque(int ataque)
    {
        if (this.escudo != null) {
            ataque = this.escudo.processaAtaque(ataque);
        }
        vida.dano(ataque);
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public void recompensa()
    {
        vida.ganhaVida();
    }

    public Movimento getMovimento()
    {
        return this.movimento;
    }

    public void setMovimento(Movimento movimento)
    {
        this.movimento = movimento;
    }

    public Ataque getAtaque()
    {
        return this.ataque;
    }

    public void setAtaque(Ataque ataque)
    {
        this.ataque = ataque;
    }

    public void setEscudo(Escudo escudo)
    {
        this.escudo = escudo;
    }

    public Escudo getEscudo() {
        return this.escudo;
    }

    public void setAvatar(BufferedImage image)
    {
        this.image = image;
    }

    public BufferedImage getAvatar()
    {
        return this.image;
    }

    public void addEscudo(Escudo escudo)
    {
        if (this.escudo != null) {
            this.escudo.setNext(escudo);
        } else {
            this.setEscudo(escudo);  
        }
    }

    public void corrida()
    {
        movimento.correr();
    }

    public void ataque()
    {
        ataque.atacar();
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

    public void show()
    {
        setChanged();
        notifyObservers();
    }

    // ------------------------------------------------------- //

    public synchronized void enviaAtaque(ArrayList<Robo> robos)
    {
        Robo robo;
        // se estiver em distancia de ataque
        for (int i = 0; i < robos.size(); i++) {
            robo = robos.get(i);
            if (
                (Math.abs(this.getX() - robo.getX()) < 3) &&
                (Math.abs(this.getY() - robo.getY()) < 3)
            ) {
                robo.recebeAtaque(this.getAtaque().atacar());               
                robo.getVida().verificaEstado();
                
                if (robo.getVida() instanceof RoboMorto) {
                    this.deleteObserver(robo);
                    robos.remove(robo);
                    continue;
                }

                if (Math.random() < 0.5) {
                    robo.setPos(
                        robo.getX() + (int) (100 * Math.random()),
                        robo.getY() - (int) (100 * Math.random())
                    );
                } else {
                    robo.setPos(
                        robo.getX() - (int) (100 * Math.random()),
                        robo.getY() + (int) (100 * Math.random())
                    );
                }
            } else {
                if (robo.getX() > this.getX()) {
                    this.setX(this.getX() + (int) (5 * Math.random()));
                } else {
                    this.setX(this.getX() - (int) (5 * Math.random()));
                }

                if (robo.getY() > this.getY()) {
                    this.setY(this.getY() + (int) (5 * Math.random()));
                } else {
                    this.setY(this.getY() - (int) (5 * Math.random()));
                }

            }

            if (robo.getX() < 0) {
                robo.setX(100);
            }
            if (robo.getY() < 0) {
                robo.setY(100);
            }
        }
    }

    public void coletaEscudo(ArrayList<Escudo> escudos)
    {
        for (int i = 0; i < escudos.size(); i++) {
            if (
                (Math.abs(this.getX() - escudos.get(i).getX()) <= 10) &&
                (Math.abs(this.getY() - escudos.get(i).getY()) <= 10)
            ) {
                this.addEscudo(escudos.get(i));
                escudos.remove(escudos.get(i));
            }
        }
    }

    @Override
    public String toString()
    {
        return this.nome;
    }

    public void moveToUp()
    {
        if (this.getY() - this.getMovimento().correr() >= 0) {
            this.setY(this.getY() - this.getMovimento().correr());
        } else {
            this.setY(0);
        }
    }

    public void moveToDown()
    {
        if (this.getY() + this.getMovimento().correr() <= this.posicao.getMaxY()) {
            this.setY(this.getY() + this.getMovimento().correr());
        } else {
            this.setY(this.posicao.getMaxY());
        }
    }

    public void moveToLeft()
    {
        if (this.getX() - this.getMovimento().correr() >= 0) {
            this.setX(this.getX() - this.getMovimento().correr());
        } else {
            this.setX(0);
        }
    }

    public void moveToRight()
    {
        if (this.getX() + this.getMovimento().correr() <= this.posicao.getMaxX()) {
            this.setX(this.getX() + this.getMovimento().correr());
        } else {
            this.setX(this.posicao.getMaxX());
        }
    }

}
