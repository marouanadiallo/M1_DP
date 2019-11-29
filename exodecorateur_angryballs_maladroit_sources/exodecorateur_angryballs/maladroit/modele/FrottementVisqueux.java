package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

import mesmaths.mecanique.MecaniquePoint;

public class FrottementVisqueux  extends AvecAcceleration{

	public FrottementVisqueux(Bille bille) {
		super(bille);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void contributionAAcceleration(Vector<Bille> billes) {
		// TODO Auto-generated method stub
		this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.billeAdecorer.masse(), this.getVitesse()));

	}
}
