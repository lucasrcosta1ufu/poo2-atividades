/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Ataque;

import static game.Utilities.ataqueImagesPath;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class DisparoMagico extends Poder
{
    private int forca = 10;
    
    public DisparoMagico(Ataque poder) throws IOException {
        super(poder, ataqueImagesPath.get("special"));
        super.setForca(forca);
    }
    
    @Override
    public int atacar(){
        return super.atacar();
    }   
}