package game;

import game.Inimigo.Robo;
import game.Escudo.EscudoMedio;
import game.Escudo.EscudoForte;
import game.Escudo.EscudoFraco;
import game.Escudo.Escudo;
import game.Ataque.Poder;
import game.Helpers.Dir;
import game.Helpers.Posicao;
import game.Helpers.RandomGenerator;
import game.Personagem.Jogador;
import game.Personagem.SimplePersonagemFactory;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Font;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Game extends JPanel
{
    private Jogador jogador = null;
    private ArrayList<Robo> robos = null;
//    private BufferedImage character, enemy1, enemy2, enemy3;
    private ImageIcon background;
    private ArrayList<Escudo> escudos;
    private ArrayList<Poder> poderes;
    private final Font EnemyStatusFont = new Font("Serif", Font.BOLD, 20);
    private final Font baseFont = new Font("Serif", Font.BOLD, 60);

    public Game() {
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
        // So that the JPanel object receives the keyboard notifications it is necessary
        // to include
        // the instruction setFocusable(true), which allows KeyboardExample to receive
        // the focus.

    }

    public class MyKeyListener implements KeyListener
    {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));

            if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A ) {
                jogador.moveToLeft();
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                jogador.moveToRight();
            }

            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                jogador.moveToUp();
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                jogador.moveToDown();
            }

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                jogador.enviaAtaque(robos);
            }

            if (e.getKeyCode() == KeyEvent.VK_P) {
                jogador.coletaEscudo(escudos);
            }
            
            if (e.getKeyCode() == KeyEvent.VK_1) {
                jogador.coletaEscudo(escudos);
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            // System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }
    }

    @Override
    public void paint(Graphics g) {
        Robo robo;
        Graphics2D g2d = (Graphics2D) g;
        
        // The call to "super.paint(g)", cleans the screen
        super.paint(g); 
        
        // The instruction; "g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        // RenderingHints.VALUE_ANTIALIAS_ON)" makes the borders of the figures smoother

        // g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        // RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (jogador == null || robos == null) {
            return;
        }

        escudos.forEach((Escudo escudo) -> {
            // g2d.fillOval(((Escudo) escudo).getX(), ((Escudo) escudo).getY(), 30, 30);
            g2d.drawImage(escudo.getImage(), ((Escudo) escudo).getX(), ((Escudo) escudo).getY(), 30, 30, null);
        });
        
        // g2d.drawString(jogador.getQuantidade(), 0 ,0);
        this.drawJogador(g2d, jogador, 850, 2);
        g2d.drawString(getPorcentagemVida(jogador, "Jogador:"), 856, 21);

        // ROBO 1------------ //
        if (robos.size() >= 1) {
            robo = robos.get(0);
            this.drawRobo(g2d, robo, 850, 32);
            g2d.drawString(getPorcentagemVida(robo, robo.getNome() + ":"), 856, 51);

        }

        // ROBO 2------------- //
        if (robos.size() >= 2) {
            robo = robos.get(1);
            this.drawRobo(g2d, robo, 850, 62);
            g2d.drawString(getPorcentagemVida(robo, robo.getNome() + ":"), 856, 81);
        }

        // ROBO 3------------- //
        if (robos.size() == 3) {
            robo = robos.get(2);
            this.drawRobo(g2d, robo, 850, 92);
            g2d.drawString(getPorcentagemVida(robo, robo.getNome() + ":"), 856, 111);
        }

    }

    public void drawJogador(Graphics2D g2d, Jogador jogador, int posX, int posY) {
        // g2d.fillOval(jogador.getX(), jogador.getY(), 20, 20);        
        g2d.drawImage(
            jogador.getAvatar(),
            jogador.getX(),
            jogador.getY(),
            jogador.getWidth(),
            jogador.getHeight(),
            null
        );
        

        // -- Jogador -- //
        g2d.setColor(Color.WHITE);
        g2d.fillRect(posX,posY, 140, 26);

        g2d.setColor(Color.RED);
        g2d.setFont(EnemyStatusFont);
    }

    public void drawRobo(Graphics2D g2d, Robo robo, int posX, int posY) {
        // g2d.fillOval(robos.get(2).getX(), robos.get(2).getY(), 20, 20);
        g2d.drawImage(
            robo.getAvatar(),
            robo.getX(),
            robo.getY(),
            robo.getWidth(),
            robo.getHeight(),
            null
        );

        // --- Robo 3 --- //
        g2d.setColor(Color.WHITE);
        g2d.fillRect(posX, posY, 140, 26);

        g2d.setColor(robo.getCor());
        g2d.setFont(EnemyStatusFont);
    }

    public String getPorcentagemVida(Jogador jogador, String preffix) {
        return String.format("%s %d", preffix, jogador.getQuantidade());
    }

    public String getPorcentagemVida(Robo robo, String preffix) {
        return String.format("%s %d", preffix, robo.getQuantidade());
    }

    public void jogar(Game game) throws InterruptedException {
        System.out.println("------------- Comeca jogo --------------");
        
        Escudo eForte, eMedio, eFraco;
        Poder soco, chute, especial;

        JFrame frame = new JFrame("RoboHunt");

        JLabel label = new JLabel();
        JLabel lifeJogador = new JLabel();
        
        
        background = new ImageIcon(Utilities.backgroundPath);
        robos = new ArrayList<>();
        escudos = new ArrayList<>();
        
        Utilities.enemysData.forEach(enemy -> {
            JLabel enemyLabel = new JLabel();
            
            enemyLabel.setFont(baseFont);
            enemyLabel.setText(
                (String) enemy.get("jlabelName")           
            );
            
            game.add(enemyLabel);
        });
        
        try {
            jogador = SimplePersonagemFactory
                .criaPersonagem(RandomGenerator.getFloat());
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
        
        Utilities.enemysData.forEach(enemy -> {
            try {
                Robo robo = new Robo(
                    (Posicao) enemy.get("posicao"),
                    (Integer) enemy.get("width"),
                    (Integer) enemy.get("height"),
                    (String) enemy.get("name"),
                    (Color) enemy.get("color"),
                    (String) enemy.get("image")
                );
                robos.add(robo);
                jogador.addObserver(robo);
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(0);
            }
        });

        eFraco = new EscudoFraco();
        eFraco.setRandomicPosition();
        eMedio = new EscudoMedio();
        eMedio.setRandomicPosition();
        eForte = new EscudoForte();
        eForte.setRandomicPosition();

        escudos.add(eFraco);
        escudos.add(eMedio);
        escudos.add(eForte);

        label.setBounds(0, 0, Utilities.WIDTH, Utilities.HEIGHT);
        label.setIcon(background);

        game.setLayout(null);
        game.add(label);

        // ------- //

        lifeJogador.setFont(baseFont);
        lifeJogador.setText("Vida Jogador");
        game.add(lifeJogador);
        
        // ------- //

        frame.add(game);
        frame.setSize(Utilities.WIDTH, Utilities.HEIGHT + 29);
        frame.setVisible(true);
        frame.setResizable(false);   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            if (robos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Voce ganhou!");
                break;
            }
            
            jogador.show();
            game.repaint();
            Thread.sleep(50);
        }
        System.exit(0);
    }

//    private void inputImage() {
//        InputStream cs = getClass()
//            .getResourceAsStream(Dir.imagePath() + "/character0.png");
//        
//        InputStream es1 = getClass()
//            .getResourceAsStream(Dir.imagePath() + "/enemy1.png");
//        
//        InputStream es2 = getClass()
//            .getResourceAsStream(Dir.imagePath() + "/enemy2.png");
//        
//        InputStream es3 = getClass()
//            .getResourceAsStream(Dir.imagePath() + "/enemy3.png");
//        
//        try {
//            character = ImageIO.read(cs);
//            enemy1 = ImageIO.read(es1);
//            enemy2 = ImageIO.read(es2);
//            enemy3 = ImageIO.read(es3);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
