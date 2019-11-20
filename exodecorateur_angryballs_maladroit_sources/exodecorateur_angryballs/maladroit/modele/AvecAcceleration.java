package exodecorateur_angryballs.maladroit.modele;

public abstract class AvecAcceleration extends DecorateurBille{

	public AvecAcceleration(Bille bille) {
		super(bille);
		// TODO Auto-generated constructor stub
	}
	
	public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
			double hauteur) {
		// TODO Auto-generated method stub
		billeAdecorer.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
	}

}
