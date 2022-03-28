/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Helpers.Posicao;
import game.Helpers.RandomGenerator;
import game.Inimigo.Robo;
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
    public ArrayList<Robo> criarInimigos()
    {
        ArrayList<Robo> enemys = new ArrayList<>();
        
        Utilities.medievalData.enemysData.forEach(new Consumer<Dictionary<String, Object>>() {
            @Override
            public void accept(Dictionary<String, Object> enemy) {
                try {
                    Robo robo = new Robo(
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
    public ImageIcon criarCenario() 
    {
        return new ImageIcon(Utilities.medievalData.getBackgroundPath());
    }
}
