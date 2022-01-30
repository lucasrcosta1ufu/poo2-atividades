
/**
 * Write a description of class RoboForte here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RoboForte extends RoboEstado
{
    public RoboForte(Robo r){
        super(r);
        r.setC(new CorreRapido());
        r.setA(new AtacaForte());
    }
    
    public void setLimites(){
        this.setLimiteInferior(71);
        this.setLimiteSuperior(100);
    }
    
    public void verificaEstado(){
        if(this.getR().getQuantidade() < this.getLimiteInferior()){
            this.getR().setVida(new RoboNormal(this.getR()));
        }else if(this.getR().getQuantidade() > this.getLimiteSuperior()){
            this.getR().setVida(new RoboForte(this.getR()));
        }
    }
    
    public void dano(int dano){
        this.perdeVida(dano);
    }
}
