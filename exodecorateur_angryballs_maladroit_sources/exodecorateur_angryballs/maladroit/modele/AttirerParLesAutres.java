package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

public class AttirerParLesAutres extends AvecAcceleration{

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

}
