/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Inimigo.Robo;
import game.Personagem.Futurista.SimplePersonagemFactory;
import game.Personagem.Jogador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class FuturisticGameFactory extends GameFactory
{
    public Jogador criarJogador()
    {
        try {
            return SimplePersonagemFactory.criaPersonagem((float) .5);
        } catch (IOException ex) {
            Logger.getLogger(FuturisticGameFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Robo criarInimigos()
    {
    }
    
    public void criarCenario() 
    {
        
    }
}
