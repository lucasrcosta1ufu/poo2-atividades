package Personagens;

/**
 * Write a description of class Android here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sacerdote implements Personagem
{
	private String path = "./res/character3.png";
	
	public Sacerdote()
	{
		super("Sacerdote", path);
	}
}
