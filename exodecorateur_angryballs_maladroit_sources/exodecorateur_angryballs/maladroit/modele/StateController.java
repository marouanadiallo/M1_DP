package exodecorateur_angryballs.maladroit.modele;

import java.awt.event.MouseEvent;

import mesmaths.geometrie.base.Vecteur;

public abstract class StateController {
	
	protected StateController suivant;
	protected Bille billeAPilloter;

	protected StateManager sm;
	
	public StateController(StateController suivant, StateManager sm) {
		this.suivant = suivant;
		this.sm = sm;
	}

	public abstract void traiter(MouseEvent e);
	
	public boolean isCaught(Vecteur u) {
	
		for(Bille b: sm.billes)
		{
			if(Math.abs((u.x-b.getPosition().x)*(u.x-b.getPosition().x)+(u.y-b.getPosition().y)*(u.y-b.getPosition().y))<=(b.getRayon()*b.getRayon()))
			{
				this.billeAPilloter = b;
				this.billeAPilloter = new BillePilote(billeAPilloter, u);//on decore la bille attrapée
				return true;
			}
		}
		return false;
	}
}
