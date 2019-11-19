package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public abstract class Collision extends DecorateurComportement{

	public Collision(Bille bille) {
		super(bille);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void gestionAcceleration(Vector<Bille> billes) {
		// TODO Auto-generated method stub
		this.getAcceleration().set(Vecteur.VECTEURNUL);
	}
}
