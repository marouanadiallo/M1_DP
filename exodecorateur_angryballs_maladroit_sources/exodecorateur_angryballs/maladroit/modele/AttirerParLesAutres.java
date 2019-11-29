package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

public class AttirerParLesAutres extends AvecAcceleration{

	public AttirerParLesAutres(Bille bille) {
		super(bille);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void contributionAAcceleration(Vector<Bille> billes) {
		// TODO Auto-generated method stub
		this.getAcceleration().ajoute(OutilsBille.gestionAccelerationNewton(this.billeAdecorer, billes));     // contribution de l'acceleration due à l'attraction des autres billes
	}

}
