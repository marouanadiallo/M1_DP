package exodecorateur_angryballs.maladroit.modele;

import java.awt.event.MouseEvent;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

public class ControllerWaitingToBeCaught extends StateController{

	
	public ControllerWaitingToBeCaught(StateController suivant, StateManager sm) {
		super(suivant, sm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void traiterMPressed(MouseEvent e) {
		for(Bille b: sm.billes)
		{
			if(Geop.appartientDisque(new Vecteur(e.getX(),e.getY()),b.getPosition(), b.getRayon()))
			{
				this.billeAPiloter = new BillePilote(b, Vecteur.VECTEURNUL);//Décoration de la billeDecorer à piloté
				sm.billes.remove(b);
				sm.billes.add(this.billeAPiloter);
				sm.setCc(this.suivant);
				break;//il faut sortir de la boucle dès qu'on trouve la bille
			}
		}
				
	}
	

}
