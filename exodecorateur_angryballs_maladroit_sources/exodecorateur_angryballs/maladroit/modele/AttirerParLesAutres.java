package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

public class AttirerParLesAutres extends DecorateurBille{

	public AttirerParLesAutres(Bille bille) {
		super(bille);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void gestionAcceleration(Vector<Bille> billes)
	{
		this.billeAdecorer.gestionAcceleration(billes);                              // remise à zero du vecteur acceleration
		this.billeAdecorer.getAcceleration().ajoute(OutilsBille.gestionAccelerationNewton(this.billeAdecorer, billes));     // contribution de l'acceleration due à l'attraction des autres billes
	}
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
			double hauteur) {
		// TODO Auto-generated method stub
		billeAdecorer.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
	}

}
