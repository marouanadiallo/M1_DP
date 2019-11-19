package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public class AbsenceAcceleration extends Acceleration{

	public AbsenceAcceleration(Bille bille) {
		super(bille);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gestionAcceleration(Vector<Bille> billes) {
		// TODO Auto-generated method stub
		this.billeDecorer.getAcceleration().set(Vecteur.VECTEURNUL);
	}

}
