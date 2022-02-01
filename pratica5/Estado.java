
/**
 * Write a description of interface Estado here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Estado
{
    private Jogador p;
    private Robo r;
    private int limiteInferior, limiteSuperior;
    
    public Estado(Jogador P){
        this.p = P;
        setLimites();
    }
    
    public Jogador getP(){
        return this.p;
    }
    
    public void setP(Jogador p){
        this.p = p;
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
        this.p.setQuantidade(this.p.getQuantidade() - lostLife);
        verificaEstado();
    }
    
    public void ganhaVida(){
         if(this.p.getQuantidade() >= 100){
            this.p.setQuantidade(100);
        }else{
            this.p.setQuantidade(this.p.getQuantidade() + 10);
        }
        verificaEstado();
    }
    
    public abstract void setLimites();
    
    public abstract void dano(int dano);
    
    public abstract void verificaEstado();
    
}
