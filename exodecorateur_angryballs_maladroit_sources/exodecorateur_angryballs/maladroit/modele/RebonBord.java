package exodecorateur_angryballs.maladroit.modele;

import mesmaths.cinematique.Collisions;

public class RebonBord extends DecorateurBille{

	public RebonBord(Bille bille) {
		// TODO Auto-generated constructor stub
		super(bille);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
			double hauteur) {
		billeAdecorer.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
		Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), 
				this.getVitesse(),
				abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
	}

}
