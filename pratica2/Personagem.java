
/**
 * Write a description of class Personagem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Personagem
{
    private Estado vida;
    private int quantidade;
    
    public Personagem(){
        vida = new EstadoNormal(this);
        setQuantidade(70);
    }
    
    public Estado getVida(){
        return this.vida;
    }
    
    public void setVida(Estado vida){
        this.vida = vida;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public void atacando(){
        vida.dano();
    }
    
    public void recompensa(){
        vida.ganhaVida();
    }
    
    // -------------------------------------------------------------- //
     
    private Corre c;
    private Ataca a;
    
    public Corre getC(){
        return this.c;
    }
    
    public void setC(Corre c){
        this.c = c;
    }
    
    public Ataca getA(){
        return this.a;
    }
    
    public void setA(Ataca a){
        this.a = a;
    }
    
    public void corrida(){
        c.correr();
    }
    
    public void ataque(){
        a.atacar();
    }
}
