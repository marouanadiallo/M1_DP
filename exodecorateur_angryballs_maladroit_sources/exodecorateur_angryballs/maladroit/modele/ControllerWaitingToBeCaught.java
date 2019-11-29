package exodecorateur_angryballs.maladroit.modele;

import java.awt.event.MouseEvent;

import mesmaths.geometrie.base.Vecteur;

public class ControllerWaitingToBeCaught extends StateController{

	public ControllerWaitingToBeCaught(StateController suivant, StateManager sm) {
		super(suivant, sm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void traiter(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getID() == MouseEvent.MOUSE_PRESSED)
		{
			if(this.isCaught(new Vecteur(e.getX(), e.getY())))
			{
				//ici on a un presse sur une bille
			}
			this.sm.setCc(this.suivant);
		}
			
	}

}
