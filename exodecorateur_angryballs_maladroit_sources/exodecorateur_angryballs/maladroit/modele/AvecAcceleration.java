package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

public abstract class AvecAcceleration extends DecorateurBille{

	public AvecAcceleration(Bille bille) {
		super(bille);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
			double hauteur) {
		// TODO Auto-generated method stub
		billeAdecorer.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
	}
	@Override
	public void gestionAcceleration(Vector<Bille> billes)
	{
		this.billeAdecorer.gestionAcceleration(billes);
		this.contributionAAcceleration(billes);
	}
	
	public abstract void contributionAAcceleration(Vector<Bille> billes);
}
