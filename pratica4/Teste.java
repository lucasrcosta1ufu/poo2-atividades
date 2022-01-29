

public class Teste
{
    static final Runtime run = Runtime.getRuntime();
    static Process pro;
    
    public static void main(String args[])throws InterruptedException {
            try
            {
                pro = run.exec("clear");
            }
            catch (java.io.IOException ioe)
            {
                ioe.printStackTrace();
            }
            Game g = new Game();
            g.jogar(g);
    
    }
}
