package exodecorateur_angryballs.maladroit.modele;

import java.awt.Color;
import mesmaths.geometrie.base.Vecteur;

public class BilleNormal extends Bille {
	

	public  Vecteur position;   // centre de la bille
	public  double rayon;            // rayon > 0
	public  Vecteur vitesse;
	public  Vecteur acceleration;
	public int clef;                // identifiant unique de cette bille

	public Color couleur;
	
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
	

		// la bille normal doit avoir quoi comme collisionContour par défaut?
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
			double hauteur) {
		// TODO Auto-generated method stub	
	}
	
	
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

	@Override
	public Color getCouleur() {
		// TODO Auto-generated method stub
		return this.couleur;
	}
	
}
