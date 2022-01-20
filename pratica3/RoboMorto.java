import java.util.Scanner;

/**
 * Write a description of class RoboMorto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RoboMorto extends RoboEstado
{
    public RoboMorto(Robo r){
        super(r);
        morte();
    }
    
    public void setLimites(){
        this.setLimiteInferior(0);
        this.setLimiteSuperior(0);
    }
    
    public void verificaEstado(){
        if(this.getR().getQuantidade() < this.getLimiteInferior()){
            this.getR().setVida(new RoboMorto(this.getR()));
        }else if(this.getR().getQuantidade() > this.getLimiteSuperior()){
            this.getR().setVida(new RoboMorto(this.getR()));
        }
    }
    
    public void perdeVida(int lostLife){
        this.morte();
    }
    
    public void morte(){
        System.out.println("Game over!");
        //System.exit(0);
    }
    
    public void dano(int dano){
        this.morte();
    }
}
