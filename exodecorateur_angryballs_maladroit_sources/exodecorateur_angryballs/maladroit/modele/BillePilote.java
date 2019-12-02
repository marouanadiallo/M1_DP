package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public class BillePilote extends AvecAcceleration {
	
	private Vecteur force ;
	
	public BillePilote(Bille bille, Vecteur f) {
		super(bille);
		force = f;

	}

	@Override
	public void contributionAAcceleration(Vector<Bille> billes) {
		this.getAcceleration().ajoute(force);
	}

	public Vecteur getForce() {
		return force;
	}

	public void setForce(Vecteur force) {
		this.force = force;
	}
	
}
