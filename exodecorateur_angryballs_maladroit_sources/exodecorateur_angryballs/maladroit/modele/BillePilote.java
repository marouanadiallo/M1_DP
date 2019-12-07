package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public class BillePilote extends AvecAcceleration {
	
	private Vecteur accelerationAppliquer ;
	
	public BillePilote(Bille bille, Vecteur f) {
		super(bille);
		accelerationAppliquer = f;

	}

	@Override
	public void contributionAAcceleration(Vector<Bille> billes) {
		this.getAcceleration().ajoute(accelerationAppliquer);
	}

	public Vecteur getaccelerationAppliquer() {
		return accelerationAppliquer;
	}

	public void setaccelerationAppliquer(Vecteur accelerationAppliquer) {
		this.accelerationAppliquer = accelerationAppliquer;
	}
	
}
