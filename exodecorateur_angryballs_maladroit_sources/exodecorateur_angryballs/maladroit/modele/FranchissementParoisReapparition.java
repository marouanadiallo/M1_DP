package exodecorateur_angryballs.maladroit.modele;

import mesmaths.cinematique.Collisions;

public class FranchissementParoisReapparition extends DecorateurBille{

	public FranchissementParoisReapparition(Bille bille) {
		super(bille);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
			double hauteur) {
		// TODO Auto-generated method stub
		Collisions.collisionBilleContourPasseMuraille( this.getPosition(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
	}

}
