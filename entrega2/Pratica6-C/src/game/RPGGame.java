package game;

import game.Ataque.Poder;
import game.Inimigo.Robo;
import game.Escudo.EscudoMedio;
import game.Escudo.EscudoForte;
import game.Escudo.EscudoFraco;
import game.Escudo.Escudo;
import game.Helpers.JLabelData;
import game.Helpers.Posicao;
import game.Helpers.RandomGenerator;
import game.Personagem.Jogador;
import game.Personagem.SimplePersonagemFactory;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Font;

import java.io.IOException;
import java.util.Dictionary;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RPGGame extends Game
{
    private Jogador jogador = null;
    private ImageIcon background;
    private ArrayList<Robo> robos = null;
    private ArrayList<Escudo> escudos;
    private final Font EnemyStatusFont = new Font("Serif", Font.BOLD, 20);
    private final Font baseFont = new Font("Serif", Font.BOLD, 60);

    public RPGGame()
    {
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
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e)
        {
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
        public void keyReleased(KeyEvent e)
        {
            // System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }
    }

    @Override
    public void paint(Graphics g)
    {
        Robo robo;
        Graphics2D g2d = (Graphics2D) g;
        JLabelData labelData;
        JLabelData jogadorLabel = (JLabelData) Utilities
            .personagemData.get("jlabel");
        
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
            g2d.drawImage(
                escudo.getImage(),
                ((Escudo) escudo).getX(),
                ((Escudo) escudo).getY(),
                30,
                30,
                null
            );
        });
        
        // g2d.drawString(jogador.getQuantidade(), 0 ,0);
        this.drawJogador(
            g2d,
            jogador,
            jogadorLabel
        );
        
        if (jogador.isAttacking()) {
            if (jogador.getAtaque() instanceof Poder) {
                Posicao ataqueDecodadoPosicao = (Posicao) Utilities
                    .ataqueDecoradoData.get("posicao");

                g2d.drawImage(
                    ((Poder) jogador.getAtaque()).getImage(),
                    jogador.getX() +
                        ataqueDecodadoPosicao.getX(),
                    jogador.getY() +
                        ataqueDecodadoPosicao.getY(),
                    (Integer) Utilities.ataqueDecoradoData.get("width"),
                    (Integer) Utilities.ataqueDecoradoData.get("height"),
                    null         
                );
            }
        }
        
        for (int i = 0; i < robos.size(); i++) {
            robo = robos.get(i);            
            this.drawRobo(g2d, robo, Utilities.enemysData.get(i));
        }
    }

    public void drawJogador(Graphics2D g2d, Jogador jogador, JLabelData jogadorLabel)
    {
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
        g2d.fillRect(
            jogadorLabel.getBackgroundPosX(),
            jogadorLabel.getBackgroundPosY(),
            jogadorLabel.getWidth(),
            jogadorLabel.getHeight()
        );

        g2d.setColor(Color.RED);
        g2d.setFont(EnemyStatusFont);
         
        g2d.drawString(
            getPorcentagemVida(jogador, "Jogador: "),
            jogadorLabel.getTextPosX(),
            jogadorLabel.getTextPosY()
        );
    }

    public void drawRobo(Graphics2D g2d, Robo robo, Dictionary<String, Object> enemyData)
    {
        JLabelData labelData = (JLabelData) enemyData.get("jlabel");
        Color color = (Color) enemyData.get("color");
        
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
        g2d.fillRect(
            labelData.getBackgroundPosX(),
            labelData.getBackgroundPosY(),
            labelData.getWidth(),
            labelData.getHeight()
        );

        g2d.setColor(color);
        g2d.setFont(EnemyStatusFont);
        
        g2d.drawString(
            getPorcentagemVida(robo, robo.getNome() + ":"),
            labelData.getTextPosX(),
            labelData.getTextPosY()
        );
    }

    public String getPorcentagemVida(Jogador jogador, String preffix)
    {
        return String.format("%s %d", preffix, jogador.getQuantidade());
    }

    public String getPorcentagemVida(Robo robo, String preffix)
    {
        return String.format("%s %d", preffix, robo.getQuantidade());
    }

    @Override
    public void jogar(Game g)
        throws InterruptedException
    {
        System.out.println("------------- Comeca jogo --------------");
        
        RPGGame game = (RPGGame) g;
        Escudo eForte, eMedio, eFraco;

        JFrame frame = new JFrame("RoboHunt");

        JLabel label = new JLabel();
        JLabel lifeJogador = new JLabel();
        JLabelData jogadorLabel = (JLabelData) Utilities.personagemData.get("jlabel");
        
        
        background = new ImageIcon(Utilities.backgroundPath);
        robos = new ArrayList<>();
        escudos = new ArrayList<>();
        
        Utilities.enemysData.forEach(enemy -> {
            JLabel enemyLabel = new JLabel();
            JLabelData labelData = (JLabelData) enemy.get("jlabel");
            
            enemyLabel.setFont(baseFont);
            enemyLabel.setText(labelData.getName());
            
            game.add(enemyLabel);
        });
        
        try {
            jogador = SimplePersonagemFactory
                .criaPersonagem(RandomGenerator.getFloat());
            
        } catch (IOException ex) {
            Logger.getLogger(RPGGame.class.getName())
                .log(Level.SEVERE, null, ex);
            System.exit(0);
        }
        
        Utilities.enemysData.forEach(enemy -> {
            try {
                Robo robo = new Robo(
                    (Posicao) enemy.get("posicao"),
                    (Integer) enemy.get("width"),
                    (Integer) enemy.get("height"),
                    (String) enemy.get("name"),
                    (String) enemy.get("image")
                );
                robos.add(robo);
                jogador.addObserver(robo);
            } catch (IOException ex) {
                Logger.getLogger(RPGGame.class.getName())
                    .log(Level.SEVERE, null, ex);
                
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
        lifeJogador.setText(jogadorLabel.getName());
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

    @Override
    public Jogador criaPersonagem() {
        Jogador player = null;
        try {
            player = SimplePersonagemFactory
                    .criaPersonagem(RandomGenerator.getFloat());
        } catch (IOException ex) {
            Logger.getLogger(RPGGame.class.getName())
                .log(Level.SEVERE, null, ex);
        } finally {
            return player;
        }
    }
}
