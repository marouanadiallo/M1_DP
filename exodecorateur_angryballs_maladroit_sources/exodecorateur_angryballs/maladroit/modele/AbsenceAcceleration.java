package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

public class AbsenceAcceleration extends AvecAcceleration{

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
	
}
