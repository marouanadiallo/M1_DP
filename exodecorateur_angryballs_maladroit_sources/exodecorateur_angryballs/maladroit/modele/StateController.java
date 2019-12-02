package exodecorateur_angryballs.maladroit.modele;

import java.awt.event.MouseEvent;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

public abstract class StateController {
	
	protected StateController suivant;
	protected BillePilote billeAPiloter;

	
	protected StateManager sm;

	public StateController(StateController suivant, StateManager sm) {
		this.suivant = suivant;
		this.sm = sm;
	}

	public  void traiterMPressed(MouseEvent e) {}
	public  void traiterMDragged(MouseEvent e) {}
	public  void traiterMReleased(MouseEvent e) {}
	
	



}
