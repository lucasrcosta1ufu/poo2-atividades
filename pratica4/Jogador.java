import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

/**
 * Write a description of class Jogador here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jogador extends Observable {
    private Corre c;
    private Ataca a;
    private Estado vida;
    private int quantidade;
    private Escudo escudo;
    private String nome;
    private int x = 0;
    private int y = 0;
    private int maxX, maxY;
    private int width, height;
    private BufferedImage image;

    public Jogador(int x, int y, int maxX, int maxY, int width, int height, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.maxX = maxX - width;
        this.maxY = maxY - height;
        this.image = image;
        this.width = width;
        this.height = height;

        this.vida = new EstadoNormal(this);
        this.setQuantidade(70);
    }

    public Estado getVida() {
        return this.vida;
    }

    public void setVida(Estado vida) {
        this.vida = vida;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void recebeAtaque(int ataque) {
        if (this.escudo != null) {
            ataque = this.escudo.processaAtaque(ataque);
        }
        vida.dano(ataque);
    }

    public void recompensa() {
        vida.ganhaVida();
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int heigth) {
        this.height = heigth;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

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

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }

    public Escudo getEscudo() {
        return this.escudo;
    }

    public void setAvatar(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getAvatar() {
        return this.image;
    }

    public void addEscudo(Escudo escudo) {
        if (this.escudo != null) {
            this.escudo.setNext(escudo);
        } else {
            this.setEscudo(escudo);  
        }
    }

    public void corrida() {
        c.correr();
    }

    public void ataque() {
        a.atacar();
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

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void show() {
        setChanged();
        notifyObservers();
    }

    // ------------------------------------------------------- //

    public synchronized void enviaAtaque(ArrayList<Robo> robos) {
    	Robo robo;
        // se estiver em distancia de ataque
        for (int i = 0; i < robos.size(); i++) {
        	robo = robos.get(i);
            if (
            	(Math.abs(this.getX() - robo.getX()) <= 10) &&
            	(Math.abs(this.getY() - robo.getY()) <= 10)
            ) {
                robo.recebeAtaque(this.getA().atacar());
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
                if (robo.getX() > this.x) {
                    this.x = this.x + (int) (5 * Math.random());
                } else {
                    this.x = this.x - (int) (5 * Math.random());
                }

                if (robo.getY() > this.y) {
                    this.y = this.y + (int) (5 * Math.random());
                }                 else {
                    this.y = this.y - (int) (5 * Math.random());
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

    public void coletaEscudo(ArrayList<Escudo> escudos) {
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

    public String toString() {
        return this.nome;
    }

    public void moveToUp() {
        if (this.y - this.getC().correr() >= 0) {
            this.setY(this.getY() - this.getC().correr());
        } else {
            this.y = 0;
        }
    }

    public void moveToDown() {
        if (this.y + this.getC().correr() <= this.maxY) {
            this.setY(this.getY() + this.getC().correr());
        } else {
            this.y = this.maxY;
        }
    }

    public void moveToLeft() {
        if (this.x - this.getC().correr() >= 0) {
            this.setX(this.getX() - this.getC().correr());
        } else {
            this.x = 0;
        }
    }

    public void moveToRight() {
        if (this.x + this.getC().correr() <= this.maxX) {
            this.setX(this.getX() + this.getC().correr());
        } else {
            this.x = this.maxX;
        }
    }

}
