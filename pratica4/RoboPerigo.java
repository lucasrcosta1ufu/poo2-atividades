
/**
 * Write a description of class RoboPerigo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RoboPerigo extends RoboEstado
{    
    public RoboPerigo(Robo r){
        super(r);
        r.setC(new CorreDevagar());
        r.setA(new AtacaFraco());
    }
    
    public void setLimites(){
        this.setLimiteInferior(1);
        this.setLimiteSuperior(29);
    }
    
    public void verificaEstado(){
        if(this.getR().getQuantidade() <= this.getLimiteInferior()){
            this.getR().setVida(new RoboMorto(this.getR()));
        }else if(this.getR().getQuantidade() > this.getLimiteSuperior()){
            this.getR().setVida(new RoboNormal(this.getR()));
        }
    }
    
    public void dano(int dano){
        this.perdeVida(dano);
    }
}
