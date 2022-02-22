public class Teste {
    static final Runtime run = Runtime.getRuntime();
    static Process pro;

    public static void main(String args[]) {
        try {
            new Game().jogar();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
