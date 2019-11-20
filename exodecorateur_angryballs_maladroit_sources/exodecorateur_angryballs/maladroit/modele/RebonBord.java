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
		Collisions.collisionBilleContourAvecRebond(billeAdecorer.getPosition(), billeAdecorer.getRayon(), 
				billeAdecorer.getVitesse(),
				abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
	}

}
