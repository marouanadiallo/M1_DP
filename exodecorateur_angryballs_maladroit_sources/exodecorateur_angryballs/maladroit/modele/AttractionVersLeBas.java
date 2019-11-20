package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public class AttractionVersLeBas extends DecorateurBille{
	Vecteur pesanteur;
	
	public AttractionVersLeBas(Bille bille, Vecteur pesanteur) {
		super(bille);
		this.pesanteur = pesanteur;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void gestionAcceleration(Vector<Bille> billes)
	{
		this.billeAdecorer.gestionAcceleration(billes);
		this.getAcceleration().ajoute(this.pesanteur);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur,
			double hauteur) {
		// TODO Auto-generated method stub
	}

}
