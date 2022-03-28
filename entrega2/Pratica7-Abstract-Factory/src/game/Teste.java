package game;

public class Teste
{
    static final Runtime run = Runtime.getRuntime();
    static Process pro;
    
    public static void main(String args[])
        throws InterruptedException
    {
        Utilities.readConfigs();
        GameFactory factory = getFactory("1");
        
        Game g = Game.getInstance(0);
        
        g.setJogador(factory.criarJogador());
        g.setEnemys(factory.criarInimigos());
        g.setBackgroundGame(factory.criarCenario());
        
        g.jogar(g);
    }
    
    public static GameFactory getFactory(String s)
    {
        if(s.equals("1")){
            return new FuturisticGameFactory();
        } else if(s.equals("0")) {
            return new MedievalGameFactory();
        }
        
        return null;
    }

}
