package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

public class AbsenceAcceleration extends DecorateurBille{

	public AbsenceAcceleration(Bille bille) {
		super(bille);
		// TODO Auto-generated constructor stub
	}
	
	// est-ce necessaire de rédefinir 
	@Override
	public void gestionAcceleration(Vector<Bille> billes)
	{
		this.billeAdecorer.gestionAcceleration(billes);
	}
	
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
			double hauteur) {
		// TODO Auto-generated method stub
		//billeAdecorer.collisionContour(abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
	}

}
