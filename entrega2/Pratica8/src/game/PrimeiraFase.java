/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Ataque.Poder;
import game.Escudo.Escudo;
import game.Escudo.EscudoForte;
import game.Escudo.EscudoFraco;
import game.Escudo.EscudoMedio;
import game.Helpers.DataManager;
import static game.Helpers.FactoryHelper.getFactory;
import game.Helpers.JLabelData;
import game.Helpers.Posicao;
import game.Inimigo.Inimigo;
import game.Personagem.Jogador;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Dictionary;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class PrimeiraFase extends JPanel implements Game
{
    private Game proximaFase;
    
    private Jogador jogador = null;
    private ArrayList<Inimigo> enemy = null;
    private ArrayList<Escudo> escudos;
    private ImageIcon background;
    
    protected final Font EnemyStatusFont = new Font("Serif", Font.BOLD, 20);
    protected final Font baseFont = new Font("Serif", Font.BOLD, 60);
    
    private DataManager configs;
    private int gameType;
    
    private static PrimeiraFase instancia = null;
    
    public static PrimeiraFase getInstance(int gameType)
    {
        if (instancia == null) {
            instancia = new PrimeiraFase(gameType);
        }
        
        return instancia;
    }

    private PrimeiraFase(int gameType)
    {
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
        
        this.gameType = gameType;
        proximaFase = SegundaFase.getInstance(gameType);
        
        if (gameType == 0) {
            this.configs = Utilities.medievalData;
            
        } else if (gameType == 1) {
            this.configs = Utilities.futuristicData;
            
        }
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
                getJogador().moveToLeft();
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                getJogador().moveToRight();
            }

            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                getJogador().moveToUp();
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                getJogador().moveToDown();
            }

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                getJogador().enviaAtaque(getEnemys());
            }

            if (e.getKeyCode() == KeyEvent.VK_P) {
                getJogador().coletaEscudo(getEscudos());
            }
            
            if (e.getKeyCode() == KeyEvent.VK_1) {
                getJogador().coletaEscudo(getEscudos());
            }

        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            // System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }
    }

    public Jogador getJogador()
    {
        return jogador;
    }

    public void setJogador(Jogador jogador)
    {
        this.jogador = jogador;
    }

    public ArrayList<Escudo> getEscudos()
    {
        return escudos;
    }

    public void setEscudos(ArrayList<Escudo> escudos)
    {
        this.escudos = escudos;
    }

    public ArrayList<Inimigo> getEnemys()
    {
        return enemy;
    }

    public void setEnemys(ArrayList<Inimigo> enemys)
    {
        this.enemy = enemys;
    }

    public ImageIcon getBackgroundGame()
    {
        return background;
    }

    public void setBackgroundGame(ImageIcon background)
    {
        this.background = background;
    }

    @Override
    public void paint(Graphics g)
    {
        Inimigo robo;
        Graphics2D g2d = (Graphics2D) g;
        JLabelData labelData;
        JLabelData jogadorLabel = (JLabelData) configs
            .personagemData.get("jlabel");
        
        // The call to "super.paint(g)", cleans the screen
        super.paint(g); 
        
        // The instruction; "g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        // RenderingHints.VALUE_ANTIALIAS_ON)" makes the borders of the figures smoother

        // g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        // RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (jogador == null || enemy == null) {
            System.exit(0);
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
                Posicao ataqueDecodadoPosicao = (Posicao) configs
                    .ataqueDecoradoData.get("posicao");

                g2d.drawImage(
                    ((Poder) jogador.getAtaque()).getImage(),
                    jogador.getX() +
                        ataqueDecodadoPosicao.getX(),
                    jogador.getY() +
                        ataqueDecodadoPosicao.getY(),
                    (Integer) configs.ataqueDecoradoData.get("width"),
                    (Integer) configs.ataqueDecoradoData.get("height"),
                    null         
                );
            }
        }
        
        for (int i = 0; i < enemy.size(); i++) {
            robo = enemy.get(i);            
            this.drawRobo(g2d, robo, configs.enemysData.get(i));
        }
    }

    @Override
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

    @Override
    public void drawRobo(Graphics2D g2d, Inimigo robo, Dictionary<String, Object> enemyData)
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

        // --- Inimigo 3 --- //
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

    public String getPorcentagemVida(Inimigo robo, String preffix)
    {
        return String.format("%s %d", preffix, robo.getQuantidade());
    }

    @Override
    public void jogar(Game g)
        throws InterruptedException
    {
        if (jogador == null || enemy == null) {
            System.exit(0);
        }
        
        PrimeiraFase game = (PrimeiraFase) g;
        
        System.out.println("------------- Comeca jogo --------------");
        
        Escudo eForte, eMedio, eFraco;

        JFrame frame = new JFrame("RoboHunt");

        JLabel label = new JLabel();
        JLabel lifeJogador = new JLabel();
        JLabelData jogadorLabel = (JLabelData) configs.personagemData.get("jlabel");
        
        setEscudos(new ArrayList<>());
        
        configs.enemysData.forEach(enemy -> {
            JLabel enemyLabel = new JLabel();
            JLabelData labelData = (JLabelData) enemy.get("jlabel");
            
            enemyLabel.setFont(baseFont);
            enemyLabel.setText(labelData.getName());
            
            game.add(enemyLabel);
        });
        
        getEnemys().forEach(enemy -> {
            jogador.addObserver(enemy);
        });

        eFraco = new EscudoFraco();
        eFraco.setRandomicPosition();
        eMedio = new EscudoMedio();
        eMedio.setRandomicPosition();
        eForte = new EscudoForte();
        eForte.setRandomicPosition();

        getEscudos().add(eFraco);
        getEscudos().add(eMedio);
        getEscudos().add(eForte);

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

        while (!getEnemys().isEmpty()) {            
            getJogador().show();
            game.repaint();
            Thread.sleep(50);
        }
                
        setProximaFase();        
        proximaFase.jogar(proximaFase);
    }
    
    public void setProximaFase()
    {
        proximaFase.setJogador(getJogador());
        proximaFase.setEnemys(getFactory(gameType).criarInimigosRapidos(5));
        proximaFase.setBackgroundGame(getFactory(gameType).criarCenarioFase2());
    }
}
