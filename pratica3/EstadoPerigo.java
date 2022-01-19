
/**
 * Write a description of class EstadoPerigo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EstadoPerigo extends Estado
{
    public EstadoPerigo(Jogador p){
        super(p);
        p.setC(new CorreDevagar());
        p.setA(new AtacaFraco());
    }
    
    public EstadoPerigo(Robo r){
        super(r);
        r.setC(new CorreDevagar());
        r.setA(new AtacaFraco());
    }
    
    public void setLimites(){
        this.setLimiteInferior(0);
        this.setLimiteSuperior(29);
    }
    
    public void verificaEstado(){
        if(this.getP().getQuantidade() <= this.getLimiteInferior()){
            this.getP().setVida(new EstadoMorto(this.getP()));
        }else if(this.getP().getQuantidade() > this.getLimiteSuperior()){
            this.getP().setVida(new EstadoNormal(this.getP()));
        }
    }
    
    public void dano(){
        this.perdeVida(5);
    }
}
