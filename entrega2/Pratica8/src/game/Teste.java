package game;

import static game.Helpers.FactoryHelper.getFactory;

public class Teste
{
    static final Runtime run = Runtime.getRuntime();
    static Process pro;
    
    public static void main(String args[])
        throws InterruptedException
    {
        Utilities.readConfigs();
        GameFactory factory = getFactory(0);
        
        Game g = PrimeiraFase.getInstance(0);
        
        g.setJogador(factory.criarJogador());
        g.setEnemys(factory.criarInimigos(3));
        g.setBackgroundGame(factory.criarCenario());
        
        g.jogar(g);
    }
    
    

}
