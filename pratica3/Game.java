import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.*; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Font;

public class Game extends JPanel {
    
    private Robo r1, r2, r3;
    private ArrayList<Robo> robos;    
    private Jogador jogador;
    
    public Game() {
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true); //So that the JPanel object receives the keyboard notifications it is necessary to include 
        //the instruction setFocusable(true), which allows KeyboardExample to receive the focus.
               
    }       
    
    public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));

            if (e.getKeyCode() == KeyEvent.VK_LEFT)
               jogador.setX(jogador.getX()-jogador.getC().correr());
               
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
               jogador.setX(jogador.getX()+jogador.getC().correr());
               
            if (e.getKeyCode() == KeyEvent.VK_UP)
                jogador.setY(jogador.getY()-jogador.getC().correr());
            
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
               jogador.setY(jogador.getY()+jogador.getC().correr());    
               
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
               jogador.enviaAtaque(robos);  
               
               
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }
}    
    
    public void paint(Graphics g) {
        super.paint(g); //The call to "super.paint(g)", cleans the screen 

        Graphics2D g2d = (Graphics2D) g;
        //The instruction; "g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)" makes the borders of the figures smoother

        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLUE);                        
        g2d.fillOval(jogador.getX(), jogador.getY(), 20, 20);
        
        // -- Jogador -- //
        g2d.setColor(Color.WHITE); 
        g2d.fillRect(850, 2, 140, 26);
        
        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("Serif", Font.BOLD, 20));
        //g2d.drawString(jogador.getQuantidade(), 0 ,0);
        g2d.drawString(getPorcentagemVida(jogador, "Jogador:"), 856 ,21);
        
        if (robos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Voce ganhou!");
            System.exit(0);
        }
        
        // ------------- //
        if (robos.size() >= 1) {
            g2d.setColor(Color.GREEN);        
            g2d.fillOval(robos.get(0).getX(), robos.get(0).getY(), 20, 20);
            
            // --- Robo 1 --- //
            g2d.setColor(Color.WHITE); 
            g2d.fillRect(850, 32, 140, 26);
        
            g2d.setColor(Color.GREEN);
            g2d.setFont(new Font("Serif", Font.BOLD, 20));
            g2d.drawString(getPorcentagemVida(robos.get(0), "Robo 1:"),  856 ,51);
        }
        
        // ------------- //
        if (robos.size() >= 2) {
            g2d.setColor(Color.RED);                
            g2d.fillOval(robos.get(1).getX(), robos.get(1).getY(), 20, 20);
            
            // --- Robo 2 --- //
            g2d.setColor(Color.WHITE); 
            g2d.fillRect(850, 62, 140, 26);
            
            g2d.setColor(Color.RED);
            g2d.setFont(new Font("Serif", Font.BOLD, 20));
            g2d.drawString(getPorcentagemVida(robos.get(1), "Robo 2:"), 856 ,81);
        }
        
        // ------------- //
        if (robos.size() == 3) {
            g2d.setColor(Color.BLACK);        
            g2d.fillOval(robos.get(2).getX(), robos.get(2).getY(), 20, 20);
            
            // --- Robo 3 --- //
            g2d.setColor(Color.WHITE); 
            g2d.fillRect(850, 92, 140, 26);
            
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Serif", Font.BOLD, 20));
            //g2d.drawString(jogador.getQuantidade(), 0 ,0);
            g2d.drawString(getPorcentagemVida(robos.get(2), "Robo 3:"), 856 ,111);
            // ------------- //
        }
        
    }

    public String getPorcentagemVida(Jogador jogador, String preffix) {
        return String.format("%s %d", preffix, jogador.getQuantidade()); 
    }
    
    public String getPorcentagemVida(Robo robo, String preffix) {
        return String.format("%s %d", preffix, robo.getQuantidade()); 
    }
    
    public void jogar(Game game) throws InterruptedException {
        int x = 999;
        int y = 571;
        JFrame frame = new JFrame("RoboHunt");
        
        ImageIcon background = new ImageIcon("scenario.jpg");

        System.out.println("------------------- GAME -----------------------");
        JLabel label = new JLabel();
        
        label.setBounds(0, 0, x, y);
        label.setIcon(background);

        game.setLayout(null);
        game.add(label);
        
        // ------- //
        JLabel  lifeJogador = new JLabel(),
                lifeR1 = new JLabel(), 
                lifeR2 = new JLabel(), 
                lifeR3 = new JLabel();
            
        lifeJogador.setFont(new Font("Serif", Font.BOLD, 60));
        lifeR1.setFont(new Font("Serif", Font.BOLD, 60));
        lifeR2.setFont(new Font("Serif", Font.BOLD, 60));
        lifeR3.setFont(new Font("Serif", Font.BOLD, 60));
        
        lifeJogador.setText("Vida Jogador");
        lifeR1.setText("Vida r1");
        lifeR2.setText("Vida r2");
        lifeR3.setText("Vida r3");  
                
        game.add(lifeJogador);
        game.add(lifeR1);
        game.add(lifeR2);
        game.add(lifeR3);        
        // ------- //
        
        frame.add(game);
        frame.setSize(x, y);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        
        robos = new ArrayList<Robo>();      
        r1 = new Robo(10,450,"Robo 1");
        r2 = new Robo(400,20,"Robo 2");
        r3 = new Robo(50,50,"Robo 3");
        jogador = new Jogador(100,400);
        
        
        robos.add(r1);
        robos.add(r2);
        robos.add(r3);
        
        jogador.addObserver(robos.get(0));
        jogador.addObserver(robos.get(1));
        jogador.addObserver(robos.get(2));

        
        while (true) {
            jogador.show();
            game.repaint();
            Thread.sleep(50);
        }
    }
}
