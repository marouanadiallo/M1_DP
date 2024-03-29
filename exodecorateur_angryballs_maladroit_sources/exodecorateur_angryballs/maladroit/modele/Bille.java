package exodecorateur_angryballs.maladroit.modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import mesmaths.cinematique.Cinematique;
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
	protected static int prochaineClef = 0;

	public static double ro = 1;        // masse volumique

	/**
	 * @return the position
	 */
	public abstract Vecteur getPosition();
	
	/**
	 * @return the rayon
	 */
	public abstract double getRayon();
	
	/**
	 * @return the vitesse
	 */
	public abstract Vecteur getVitesse();

	
	/**
	 * @return the acceleration
	 */
	public abstract Vecteur getAcceleration();
	
	/**
	 * @return the clef
	 */
	public abstract int getClef();
	/**
	 * @return the couleur
	 */
	public abstract Color getCouleur();


	public double masse() 
	{
		return ro*Geop.volumeSphere(this.getRayon());
	}


	public void dessine (Graphics g)
	{
	    int width, height;
	    int xMin, yMin;
	    
	    xMin = (int)Math.round(this.getPosition().x-this.getRayon());
	    yMin = (int)Math.round(this.getPosition().y-this.getRayon());
	
	    width = height = 2*(int)Math.round(this.getRayon()); 
	
	    g.setColor(this.getCouleur());
	    g.fillOval( xMin, yMin, width, height);
	    g.setColor(Color.CYAN);
	    g.drawOval(xMin, yMin, width, height);
	}
	
	


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
 * calcul (c-e-d mise e jour) eventuel  du vecteur acceleration. 
 * billes est la liste de toutes les billes en mouvement
 * Cette methode peut avoir besoin de "billes" si this subit l'attraction gravitationnelle des autres billes
 * La nature du calcul du vecteur acceleration de la bille  est definie dans les classes derivees
 * A ce niveau le vecteur acceleration est mis e zero (c'est e dire pas d'acceleration)
 * */


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

public void gestionAcceleration(Vector<Bille> billes)
{
	this.getAcceleration().set(Vecteur.VECTEURNUL);
}

public String toString() 
{
	return "centre = " + this.getPosition() + " rayon = "+this.getRayon() +  " vitesse = " + this.getVitesse() + " acceleration = " + this.getAcceleration() + " couleur = " + this.getCouleur() + "clef = " + this.getClef();
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

