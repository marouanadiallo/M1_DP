package exodecorateur_angryballs.maladroit.modele;

import java.awt.event.MouseEvent;

import mesmaths.geometrie.base.Vecteur;

public class ControllerWaitingToBeReleased extends StateController{

	public ControllerWaitingToBeReleased(StateController suivant, StateManager sm) {
		super(suivant, sm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void traiterMDragged(MouseEvent e) {
		Vecteur force = new Vecteur(e.getX(),e.getY()).difference(this.suivant.billeAPiloter.getPosition());
		force.multiplie(1/this.suivant.billeAPiloter.masse());//on divise par la masse pour bien garder la portotion avec le rayon de la bille
		this.suivant.billeAPiloter.setaccelerationAppliquer(force);
	}
	
	@Override
	public void traiterMReleased(MouseEvent e) {
	
		Bille BilleSuivant = this.suivant.billeAPiloter.getBilleAdecorer();//on récupère l'anciene décoration de la bille
		sm.billes.remove(this.suivant.billeAPiloter);//on supprime la bille décorer BilleAPiloter
		sm.billes.add(BilleSuivant);		
		
		this.sm.setCc(this.suivant);
	}
}
