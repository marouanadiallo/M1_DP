package exodecorateur_angryballs.maladroit.modele;

import java.awt.Color;

import mesmaths.geometrie.base.Vecteur;

public abstract class DecorateurBille extends Bille{
	protected Bille billeAdecorer;
	
	public DecorateurBille(Bille bille) {
		billeAdecorer = bille;
	}
	
	/**
	 * @return the position
	 */
	public  Vecteur getPosition() {
		return this.billeAdecorer.getPosition();
	}
	
	/**
	 * @return the rayon
	 */
	public double getRayon() {
		return this.billeAdecorer.getRayon();
	}
	
	/**
	 * @return the vitesse
	 */
	public Vecteur getVitesse() {
		return this.billeAdecorer.getVitesse();
	}

	
	/**
	 * @return the acceleration
	 */
	public Vecteur getAcceleration() {
		return this.billeAdecorer.getAcceleration();
	}
	
	/**
	 * @return the clef
	 */
	public int getClef() {
		return this.billeAdecorer.getClef();
	}
	public Color getCouleur()
	{
		return this.billeAdecorer.getCouleur();
	}

	public Bille getBilleAdecorer() {
		return billeAdecorer;
	}

	public void setBilleAdecorer(Bille billeAdecorer) {
		this.billeAdecorer = billeAdecorer;
	}
	
}
