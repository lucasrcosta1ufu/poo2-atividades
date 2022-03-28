/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Inimigo.Inimigo;
import game.Personagem.Jogador;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Usuario
 */
public abstract class GameFactory
{
    public abstract Jogador criarJogador();
    public abstract ArrayList<Inimigo> criarInimigos();
    public abstract ArrayList<Inimigo> criarInimigos(int n);
    public abstract ArrayList<Inimigo> criarInimigosRapidos();
    public abstract ArrayList<Inimigo> criarInimigosRapidos(int n);
    public abstract ArrayList<Inimigo> criarInimigosFortes();
    public abstract ArrayList<Inimigo> criarInimigosFortes(int n);
    public abstract ImageIcon criarCenario();
    public abstract ImageIcon criarCenarioFase2();
    public abstract ImageIcon criarCenarioFase3();
}
