public class Teste
{
    static final Runtime run = Runtime.getRuntime();
    static Process pro;
    
    public static void main(String args[])
    {
        try {
            new Game().jogar();
        } catch (InterruptedException e) {
            //TODO: handle exception
        } catch (Exception e) {
            //TODO: handle exception
        }        
    }
}
