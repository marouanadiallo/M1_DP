package exodecorateur_angryballs.maladroit.modele;


import mesmaths.cinematique.Collisions;

public class BloquerParUnBord extends DecorateurBille{

	public BloquerParUnBord(Bille bille) {
		super(bille);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
			double hauteur) {
		// TODO Auto-generated method stub
		Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
		Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(), ordonneeCoinHautGauche, hauteur);	
	}

}
