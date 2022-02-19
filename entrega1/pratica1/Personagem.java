
/**
 * Write a description of class Personagem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Personagem
{
    private Pula p;
    private Corre c;
    private Ataca a;
    
    public Pula getP(){
        return this.p;
    }
    
    public void setP(Pula p){
        this.p = p;
    }
    
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
    
    public void pulo(){
        p.pular();
    }
    
    public void corrida(){
        c.correr();
    }
    
    public void ataque(){
        a.atacar();
    }
}
