package exodecorateur_angryballs.maladroit.modele;

import java.awt.event.MouseEvent;

import mesmaths.geometrie.base.Vecteur;

public class ControllerWaitingToBeReleased extends StateController{

	public ControllerWaitingToBeReleased(StateController suivant, StateManager sm) {
		super(suivant, sm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void traiter(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getID()==MouseEvent.MOUSE_RELEASED)
		{
			System.out.println("un released");
			
		}
		else if(e.getID()==MouseEvent.MOUSE_DRAGGED)
		{
			if(this.isCaught(new Vecteur(e.getX(), e.getY())))
			{
				//ici on a un dragged sur une bille
			}
			
		}
			
		this.sm.setCc(this.suivant);
	}

}
