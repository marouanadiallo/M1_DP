package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

import mesmaths.cinematique.Collisions;

public class BloquerParUnBord extends DecorateurBille{

	public BloquerParUnBord(Bille bille) {
		super(bille);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void gestionAcceleration(Vector<Bille> billes)
	{
		this.billeAdecorer.gestionAcceleration(billes);  
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
			double hauteur) {
		// TODO Auto-generated method stub
		Collisions.collisionBilleContourAvecArretHorizontal(this.billeAdecorer.getPosition(), this.billeAdecorer.getRayon(), this.billeAdecorer.getVitesse(), abscisseCoinHautGauche, largeur);
		Collisions.collisionBilleContourAvecArretVertical(this.billeAdecorer.getPosition(), this.billeAdecorer.getRayon(), this.billeAdecorer.getVitesse(), ordonneeCoinHautGauche, hauteur);	
	}

}
