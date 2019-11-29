package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public class AttractionVersLeBas extends AvecAcceleration{
	Vecteur pesanteur;
	
	public AttractionVersLeBas(Bille bille, Vecteur pesanteur) {
		super(bille);
		this.pesanteur = pesanteur;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void contributionAAcceleration(Vector<Bille> billes) {
		// TODO Auto-generated method stub
		this.getAcceleration().ajoute(this.pesanteur);
	}

}
