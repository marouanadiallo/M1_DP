package exodecorateur_angryballs.maladroit.modele;

import mesmaths.cinematique.Collisions;

public class RebondBord extends Collision{

	public RebondBord(Bille bille) {
		super(bille);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
			double hauteur) {
		// TODO Auto-generated method stub
		Collisions.collisionBilleContourAvecArretHorizontal(this.billeDecorer.getPosition(), this.billeDecorer.getRayon(), this.billeDecorer.getVitesse(), abscisseCoinHautGauche, largeur);
		Collisions.collisionBilleContourAvecArretVertical(this.billeDecorer.getPosition(), this.billeDecorer.getRayon(), this.billeDecorer.getVitesse(), ordonneeCoinHautGauche, hauteur);
	}

}
