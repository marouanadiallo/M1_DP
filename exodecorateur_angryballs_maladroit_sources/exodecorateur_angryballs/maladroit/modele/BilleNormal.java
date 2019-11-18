package exodecorateur_angryballs.maladroit.modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import mesmaths.cinematique.Cinematique;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

public class BilleNormal {
	
	public  Vecteur position;   // centre de la bille
	public  double rayon;            // rayon > 0
	public  Vecteur vitesse;
	public  Vecteur acceleration;
	public int clef;                // identifiant unique de cette bille

	private Color couleur;

	private static int prochaineClef = 0;

	public static double ro = 1;        // masse volumique
	
	/**
	 * @param centre
	 * @param rayon
	 * @param vitesse
	 * @param acceleration
	 * @param couleur
	 */
	protected BilleNormal(Vecteur centre, double rayon, Vecteur vitesse,
	        Vecteur acceleration, Color couleur)
	{
		this.position = centre;
		this.rayon = rayon;
		this.vitesse = vitesse;
		this.acceleration = acceleration;
		this.couleur = couleur;
		this.clef = BilleNormal.prochaineClef ++;
	}

	/**
	 * @param position
	 * @param rayon
	 * @param vitesse
	 * @param couleur
	 */
	public BilleNormal(Vecteur position, double rayon, Vecteur vitesse, Color couleur)
	{
		this(position,rayon,vitesse,new Vecteur(),couleur);
	}
	
	/**
	 * @return the position
	 */
	public Vecteur getPosition()
	{
		return this.position;
	}
	
	/**
	 * @return the rayon
	 */
	public double getRayon()
	{
		return this.rayon;
	}
	
	/**
	 * @return the vitesse
	 */
	public Vecteur getVitesse()
	{
		return this.vitesse;
	}
	
	/**
	 * @return the acceleration
	 */
	public Vecteur getAcceleration()
	{
		return this.acceleration;
	}
	
	/**
	 * @return the clef
	 */
	public int getClef()
	{
		return this.clef;
	}

	/**
	 * calcul (c-e-d mise e jour) eventuel  du vecteur acceleration. 
	 * billes est la liste de toutes les billes en mouvement
	 * Cette methode peut avoir besoin de "billes" si this subit l'attraction gravitationnelle des autres billes
	 * La nature du calcul du vecteur acceleration de la bille  est definie dans les classes derivees
	 * A ce niveau le vecteur acceleration est mis e zero (c'est e dire pas d'acceleration)
	 * */
	public void gestionAcceleration(Vector<Bille> billes)
	{
		this.getAcceleration().set(Vecteur.VECTEURNUL);
	}

	
	public String toString() 
    {
		return "centre = " + position + " rayon = "+rayon +  " vitesse = " + vitesse + " acceleration = " + acceleration + " couleur = " + couleur + "clef = " + clef;
    }
	
	
	public double masse() 
	{
		return ro*Geop.volumeSphere(rayon);
	}
	

	/**
	 * mise e jour de position et vitesse e t+deltaT e partir de position et vitesse e l'instant t
	 * 
	 * modifie le vecteur position et le vecteur vitesse
	 * 
	 * laisse le vecteur acceleration intact
	 *
	 * La bille subit par defaut un mouvement uniformement accelere
	 * */
	public  void  deplacer( double deltaT)
	{
		Cinematique.mouvementUniformementAccelere( this.getPosition(), this.getVitesse(), this.getAcceleration(), deltaT);
	}
	

	public void dessine (Graphics g)
	{
	    int width, height;
	    int xMin, yMin;
	    
	    xMin = (int)Math.round(position.x-rayon);
	    yMin = (int)Math.round(position.y-rayon);
	
	    width = height = 2*(int)Math.round(rayon); 
	
	    g.setColor(couleur);
	    g.fillOval( xMin, yMin, width, height);
	    g.setColor(Color.CYAN);
	    g.drawOval(xMin, yMin, width, height);
	}
}
