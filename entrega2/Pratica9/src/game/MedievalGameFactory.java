/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Helpers.Posicao;
import game.Helpers.RandomGenerator;
import game.Inimigo.Inimigo;
import game.Inimigo.RoboForte;
import game.Movimento.MovimentoRapido;
import game.Personagem.Medieval.SimplePersonagemMedievalFactory;
import game.Personagem.Jogador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Usuario
 */
public class MedievalGameFactory extends GameFactory
{
    private static MedievalGameFactory instance = new MedievalGameFactory();

    private MedievalGameFactory() {}    

    public static MedievalGameFactory getInstance()
    {
        return instance;
    }
    
    @Override
    public Jogador criarJogador()
    {
        try {
            return SimplePersonagemMedievalFactory
                .criaPersonagem(RandomGenerator.getFloat());
        } catch (IOException ex) {
            Logger.getLogger(FuturisticGameFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public ArrayList<Inimigo> criarInimigos()
    {
        ArrayList<Inimigo> enemys = new ArrayList<>();
        
        Utilities.medievalData.enemysData.forEach(new Consumer<Dictionary<String, Object>>() {
            @Override
            public void accept(Dictionary<String, Object> enemy) {
                try {
                    Inimigo robo = new Inimigo(
                        (Posicao) enemy.get("posicao"),
                        (Integer) enemy.get("width"),
                        (Integer) enemy.get("height"),
                        (String) enemy.get("name"),
                        (String) enemy.get("image")
                    );
                    enemys.add(robo);
                } catch (IOException ex) {
                    Logger.getLogger(MedievalGameFactory.class.getName())
                            .log(Level.SEVERE, null, ex);
                    
                    System.exit(0);
                }
            }
        });
        
        return enemys;
    }
    
    @Override
    public ArrayList<Inimigo> criarInimigos(int n)
    {
        ArrayList<Inimigo> enemys = new ArrayList<>();
        Dictionary<String, Object> enemyData;
        
        for (int i = 0; i < n; i++) {
            try {
                enemyData = Utilities.medievalData.enemysData.get(i);
                Inimigo robo = new Inimigo(
                    (Posicao) enemyData.get("posicao"),
                    (Integer) enemyData.get("width"),
                    (Integer) enemyData.get("height"),
                    (String) enemyData.get("name"),
                    (String) enemyData.get("image")
                );
                enemys.add(robo);
            } catch (IOException ex) {
                Logger.getLogger(MedievalGameFactory.class.getName())
                        .log(Level.SEVERE, null, ex);

                System.exit(0);
            }
        }
        
        return enemys;
    }
    
    @Override
    public ArrayList<Inimigo> criarInimigosRapidos()
    {
        ArrayList<Inimigo> enemys = new ArrayList<>();
        
        Utilities.medievalData.enemysData.forEach(new Consumer<Dictionary<String, Object>>() {
            @Override
            public void accept(Dictionary<String, Object> enemy) {
                try {
                    Inimigo robo = new Inimigo(
                        (Posicao) enemy.get("posicao"),
                        (Integer) enemy.get("width"),
                        (Integer) enemy.get("height"),
                        (String) enemy.get("name"),
                        (String) enemy.get("image")
                    );
                    robo.setMovimento(MovimentoRapido.getInstance());
                    enemys.add(robo);
                } catch (IOException ex) {
                    Logger.getLogger(MedievalGameFactory.class.getName())
                            .log(Level.SEVERE, null, ex);
                    
                    System.exit(0);
                }
            }
        });
        
        return enemys;
    }
    
    @Override
    public ArrayList<Inimigo> criarInimigosRapidos(int n)
    {
        ArrayList<Inimigo> enemys = new ArrayList<>();
        Dictionary<String, Object> enemyData;
        
        for (int i = 0; i < n; i++) {
            try {
                enemyData = Utilities.medievalData.enemysData.get(i);
                Inimigo robo = new Inimigo(
                    (Posicao) enemyData.get("posicao"),
                    (Integer) enemyData.get("width"),
                    (Integer) enemyData.get("height"),
                    (String) enemyData.get("name"),
                    (String) enemyData.get("image")
                );
                robo.setMovimento(MovimentoRapido.getInstance());
                enemys.add(robo);
            } catch (IOException ex) {
                Logger.getLogger(MedievalGameFactory.class.getName())
                        .log(Level.SEVERE, null, ex);

                System.exit(0);
            }
        }
        
        return enemys;
    }
    
    @Override
    public ArrayList<Inimigo> criarInimigosFortes()
    {
        ArrayList<Inimigo> enemys = new ArrayList<>();
        
        Utilities.medievalData.enemysData.forEach(new Consumer<Dictionary<String, Object>>() {
            @Override
            public void accept(Dictionary<String, Object> enemy) {
                try {
                    Inimigo robo = new Inimigo(
                        (Posicao) enemy.get("posicao"),
                        (Integer) enemy.get("width"),
                        (Integer) enemy.get("height"),
                        (String) enemy.get("name"),
                        (String) enemy.get("image")
                    );
                    robo.setVida(new RoboForte(robo));
                    enemys.add(robo);
                } catch (IOException ex) {
                    Logger.getLogger(MedievalGameFactory.class.getName())
                            .log(Level.SEVERE, null, ex);
                    
                    System.exit(0);
                }
            }
        });
        
        return enemys;
    }
    
    @Override
    public ArrayList<Inimigo> criarInimigosFortes(int n)
    {
        ArrayList<Inimigo> enemys = new ArrayList<>();
        Dictionary<String, Object> enemyData;
        
        for (int i = 0; i < n; i++) {
            try {
                enemyData = Utilities.medievalData.enemysData.get(i);
                Inimigo robo = new Inimigo(
                    (Posicao) enemyData.get("posicao"),
                    (Integer) enemyData.get("width"),
                    (Integer) enemyData.get("height"),
                    (String) enemyData.get("name"),
                    (String) enemyData.get("image")
                );
                robo.setVida(new RoboForte(robo));
                enemys.add(robo);
            } catch (IOException ex) {
                Logger.getLogger(MedievalGameFactory.class.getName())
                        .log(Level.SEVERE, null, ex);

                System.exit(0);
            }
        }
        
        return enemys;
    }
    
    @Override
    public ImageIcon criarCenario() 
    {
        return new ImageIcon(Utilities.medievalData.getBackgroundPathFase1());
    }
    
    @Override
    public ImageIcon criarCenarioFase2() 
    {
        return new ImageIcon(Utilities.medievalData.getBackgroundPathFase2());
    }
    
    @Override
    public ImageIcon criarCenarioFase3() 
    {
        return new ImageIcon(Utilities.medievalData.getBackgroundPathFase3());
    }
}
