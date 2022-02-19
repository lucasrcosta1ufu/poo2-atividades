import java.util.Observer;
import java.util.Observable;

public class Robo implements Observer {
    private RoboEstado vida;
    private int quantidade;
    private int x;
    private int y;
    private String nome; 
    private Corre c;
    private Ataca a;
    
    public Robo(int x, int y,String nome){
        this.x = x;
        this.y = y;
        this.nome = nome;
        vida = new RoboNormal(this);
        setQuantidade(70);
    }
    
    public RoboEstado getVida(){
        return this.vida;
    }
    
    public void setVida(RoboEstado vida){
        this.vida = vida;
    }

    public int getQuantidade(){
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;        
        //System.out.println("Posicao do Robo: ("+this.x+","+this.y+")");
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public int getX() {return this.x;}
    
    public int getY() {return this.y;}    

    public void setX(int x){this.x = x; }           
    
    public void setY(int y){this.y = y; }           
    
    public void recebeAtaque(int ataque) {
        vida.dano(ataque);
    }
    
    public void recompensa(){
        vida.ganhaVida();
    }
    
    public void update(Observable subject, Object arg) {
        
        Jogador jogador = (Jogador)subject;
        
        //se estiver em distancia de ataque
        if ( ( Math.abs(this.x - jogador.getX()) == 0) && (Math.abs(this.y - jogador.getY()) == 0) ){
            System.out.println("Ataque feito por: "+ this.getNome());
            jogador.recebeAtaque(this.getA().atacar());
            System.out.println(" Personagem's LIFE: "+ jogador.getQuantidade());
            if (Math.random() < 0.5){
                jogador.setPos(jogador.getX()+(int)(100*Math.random()), jogador.getY()-(int)(100*Math.random()));
            }
            else {
                jogador.setPos(jogador.getX()-(int)(100*Math.random()), jogador.getY()+(int)(100*Math.random()));
            }
            
            
        }
        //se precisar andar em direcao a jogador
        else {
           //se precisa andar para frente 
           if (jogador.getX() > this.x) this.x = this.x+(int)(5*Math.random());
           else this.x = this.x-(int)(5*Math.random());
           //se precisa andar para tras
           if (jogador.getY() > this.y) this.y = this.y+(int)(5*Math.random());
           else this.y = this.y-(int)(5*Math.random());
     
        }
        
        if (jogador.getX() < 0) jogador.setX(100);
        if (jogador.getY() < 0) jogador.setY(100);
        
    }
    
    // ------------------------------------------------ //
    
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