package exodecorateur_angryballs.maladroit.modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;


/**
 * Cas general d'une bille de billard
 * 
 *  A MODIFIER
 *  
 * 
 * */
public abstract class Bille
{
	
	public  Vecteur position;   // centre de la bille
	public  double rayon;            // rayon > 0
	public  Vecteur vitesse;
	public  Vecteur acceleration;
	public int clef;                // identifiant unique de cette bille

	protected Color couleur;

	protected static int prochaineClef = 0;

	public static double ro = 1;        // masse volumique
	
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


	public double masse() 
	{
		return ro*Geop.volumeSphere(rayon);
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
	
	
public abstract void gestionAcceleration(Vector<Bille> billes);

/**
 * gestion de l'eventuelle  collision de cette bille avec les autres billes
 *
 * billes est la liste de toutes les billes en mouvement
 * 
 * Le comportement par defaut est le choc parfaitement elastique (c-e-d rebond sans amortissement)
 * 
 * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 billes impliquees dans le choc sont modifiees
 * si renvoie false, il n'y a pas de collision et les billes sont laissees intactes 
 * */
public boolean gestionCollisionBilleBille(Vector<Bille> billes)
{
	return OutilsBille.gestionCollisionBilleBille(this, billes);
}




/**
 * gestion de l'eventuelle collision de la bille (this) avec le contour rectangulaire de l'ecran defini par (abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur)
 * 
 * detecte si il y a collision et le cas echeant met à jour position et vitesse
 * 
 * La nature du comportement de la bille en reponse à cette collision est definie dans les classes derivees
 * */
public abstract void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur);

//----------------- classe Bille -------------------------------------
}

