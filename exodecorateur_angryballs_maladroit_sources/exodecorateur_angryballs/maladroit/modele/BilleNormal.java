package exodecorateur_angryballs.maladroit.modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import mesmaths.cinematique.Cinematique;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

public class BilleNormal extends Bille {
	

	
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
	
	
	
	public String toString() 
    {
		return "centre = " + position + " rayon = "+rayon +  " vitesse = " + vitesse + " acceleration = " + acceleration + " couleur = " + couleur + "clef = " + clef;
    }
	
	@Override
	public void gestionAcceleration(Vector<Bille> billes)
	{
		this.getAcceleration().set(Vecteur.VECTEURNUL);
	}



	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
			double hauteur) {
		// TODO Auto-generated method stub	
	}
}
