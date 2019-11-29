package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public class BillePilote extends AvecAcceleration {
	private Vecteur uDelaSouris;
	
	public BillePilote(Bille bille, Vecteur u) {
		super(bille);
		
		this.uDelaSouris = u;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void contributionAAcceleration(Vector<Bille> billes) {
		// TODO Auto-generated method stub
		//this.getAcceleration().ajoute(this.uDelaSouris);
	}
	
}
