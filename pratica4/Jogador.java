import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;

/**
 * Write a description of class Jogador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogador extends Observable
{
    private Corre c;
    private Ataca a;
    private Estado vida;
    private int quantidade;  
    private Escudo escudo;
    private String nome;
    private int x = 0;
    private int y = 0;    
    
    public Jogador(int x, int y){
        this.x = x;
        this.y = y;
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
    
    public void recebeAtaque(int ataque) {
        vida.dano(ataque);
    }
    
    public void recompensa(){
        vida.ganhaVida();
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
    
    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }
    
    public Escudo getEscudo () {
        return this.escudo;
    }

    public void addEscudo(Escudo escudo) {
        this.escudo.setNext(escudo);
    }    
    
    public void corrida(){
        c.correr();
    }
    
    public void ataque(){
        a.atacar();
    }
    
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }    
    
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;        
    }
    
    public void show(){
        setChanged();
        notifyObservers();
    }
    
    // ------------------------------------------------------- //
          
    public void enviaAtaque(ArrayList<Robo> robos){
        //se estiver em distancia de ataque
        int numRobos = robos.size();
        for(int i = 0; i <= numRobos; i ++){
            if ( ( Math.abs(this.getX() - robos.get(i).getX()) <= 10) && (Math.abs(this.getY() - robos.get(i).getY()) <= 10) ){
                robos.get(i).getVida().verificaEstado();
                if(robos.get(i).getVida() instanceof RoboMorto){
                    this.deleteObserver(robos.get(i));
                    robos.remove(i);
                }else{
                    robos.get(i).recebeAtaque(this.getA().atacar());
                    if (Math.random() < 0.5){
                        robos.get(i).setPos(robos.get(i).getX()+(int)(100*Math.random()), robos.get(i).getY()-(int)(100*Math.random()));
                    }
                    else {
                        robos.get(i).setPos(robos.get(i).getX()-(int)(100*Math.random()), robos.get(i).getY()+(int)(100*Math.random()));
                    }
                }
                
                
            }
            //se precisar andar em direcao a bola
            else {
               //se precisa andar para frente 
               if (robos.get(i).getX() > this.x) this.x = this.x+(int)(5*Math.random());
               else this.x = this.x-(int)(5*Math.random());
               //se precisa andar para tras
               if (robos.get(i).getY() > this.y) this.y = this.y+(int)(5*Math.random());
               else this.y = this.y-(int)(5*Math.random());
         
            }
            
            if (robos.get(i).getX() < 0) robos.get(i).setX(100);
            if (robos.get(i).getY() < 0) robos.get(i).setY(100);
        }
    }
       
    public void coletaEscudo(ArrayList<Escudo> escudos) {
        for(int i = 0; i <= escudos.size() ; i ++){
            if ((Math.abs(this.getX() - escudos.get(i). getX()) <= 2) && (Math.abs(this.getY() - escudos.get(i). getY()) <= 2)){
                this.addEscudo(escudos.get(i));
            }
        }
    }
    
    public String toString(){
        return this.nome;
    }    
    
    
    
}
