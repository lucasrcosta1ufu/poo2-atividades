package game.Personagem;

import game.Ataque.DisparoMagico;
import game.Ataque.ForcaAnimal;
import game.Ataque.GolpeSagrado;
import game.Ataque.MilLaminasCortantes;
import game.Ataque.Encantamento;
import game.Helpers.Posicao;
import game.Utilities;
import java.io.IOException;

public class SimplePersonagemFactory {
    public static Jogador criaPersonagem(float valor)
        throws IOException
    {
        Jogador personagem = null;

        if (valor <= 0.2) {
            personagem = SimplePersonagemFactory
                .createDruida();

        } else if (valor <= 0.4) {
            personagem = SimplePersonagemFactory
                .createPaladino();

        } else if (valor <= 0.6) {
            personagem = SimplePersonagemFactory
                .createMago();

        } else if (valor <= 0.8) {
            personagem = SimplePersonagemFactory
                .createSacerdote();

        } else if (valor <= 1) {
            personagem = SimplePersonagemFactory
                .createAssassino();

        }

        return personagem;
    }

    public static Mago createMago()
        throws IOException
    {
        Jogador p = new Mago(
            (Posicao) Utilities.personagemData.get("posicao"),
            (Integer) Utilities.personagemData.get("width"),
            (Integer) Utilities.personagemData.get("height")
        );       
        
        p.setAtaque(DisparoMagico.getInstance(p.getAtaque())); 
        
        return (Mago) p;
    }

    public static Paladino createPaladino()
        throws IOException
    {
        Paladino p = new Paladino(
            (Posicao) Utilities.personagemData.get("posicao"),
            (Integer) Utilities.personagemData.get("width"),
            (Integer) Utilities.personagemData.get("height")
        );        
        
        p.setAtaque(GolpeSagrado.getInstance(p.getAtaque())); 
        
        return (Paladino) p;
    }

    public static Sacerdote createSacerdote()
        throws IOException
    {
        Jogador p = new Sacerdote(
            (Posicao) Utilities.personagemData.get("posicao"),
            (Integer) Utilities.personagemData.get("width"),
            (Integer) Utilities.personagemData.get("height")
        );      
        
        p.setAtaque(Encantamento.getInstance(p.getAtaque())); 
        
        return (Sacerdote) p;
    }

    public static Assassino createAssassino()
        throws IOException
    {
        Jogador p = new Assassino(
            (Posicao) Utilities.personagemData.get("posicao"),
            (Integer) Utilities.personagemData.get("width"), 
            (Integer) Utilities.personagemData.get("height")
        );    
        
        p.setAtaque(MilLaminasCortantes.getInstance(p.getAtaque())); 
        
        return (Assassino) p;
    }

    public static Druida createDruida()
        throws IOException
    {
        Jogador p = new Druida(
            (Posicao) Utilities.personagemData.get("posicao"),
            (Integer) Utilities.personagemData.get("width"),
            (Integer) Utilities.personagemData.get("height")
        );     
        
        p.setAtaque(ForcaAnimal.getInstance(p.getAtaque())); 
        
        return (Druida) p; 
    }
}
