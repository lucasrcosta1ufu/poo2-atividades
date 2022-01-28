
/**
 * Write a description of interface RoboEstado here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class RoboEstado
{
    private Robo r;
    private int limiteInferior, limiteSuperior;
    
    public RoboEstado(Robo R) {
        this.r = R;
        setLimites();
    }
    
    public Robo getR(){
        return this.r;
    }
    
    public void set(Robo r){
        this.r = r;
    }
    
    public int getLimiteInferior(){
        return this.limiteInferior;
    }
    
    public void setLimiteInferior(int limiteInferior){
        this.limiteInferior = limiteInferior;
    }
    
    public int getLimiteSuperior(){
        return this.limiteSuperior;
    }
    
    public void setLimiteSuperior(int limiteSuperior){
        this.limiteSuperior = limiteSuperior;
    }
    
    public void perdeVida(int lostLife){
        this.r.setQuantidade(this.r.getQuantidade() - lostLife);
        verificaEstado();
    }
    
    public void ganhaVida(){
         if(this.r.getQuantidade() >= 100){
            this.r.setQuantidade(100);
        }else{
            this.r.setQuantidade(this.r.getQuantidade() + 10);
        }
        verificaEstado();
    }
    
    public abstract void setLimites();
    
    public abstract void dano(int dano);
    
    public abstract void verificaEstado();
    
}
