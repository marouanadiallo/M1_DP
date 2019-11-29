package exodecorateur_angryballs.maladroit.modele;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.vues.Billard;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;

public class StateManager implements MouseMotionListener, MouseListener{
	
	private ControllerWaitingToBeCaught etatLibre;
	private ControllerWaitingToBeReleased etatAttraper;
	
	Vector<Bille> billes = new Vector<Bille>();
	Billard billard;
	
	private StateController cc;
	
	
	
	public StateManager(Vector<Bille> billes,Billard b) {
		this.billes = billes;
		this.billard = b;
		
		this.billard.addMouseListener(this);
		this.billard.addMouseMotionListener(this);
		
		this.installeController();
	}
	
	private void installeController() {
		this.etatLibre = new ControllerWaitingToBeCaught(null, this);
		this.etatAttraper = new ControllerWaitingToBeReleased(this.etatLibre, this);
		
		this.etatLibre.suivant = this.etatAttraper;
		
		this.cc = this.etatLibre;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.cc.traiter(arg0);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.cc.traiter(arg0);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.cc.traiter(arg0);
	}
	
	
	
	public StateController getCc() {
		return cc;
	}

	public void setCc(StateController cc) {
		this.cc = cc;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {/*rien à faire*/}

	@Override
	public void mouseExited(MouseEvent arg0) {/*rien à faire*/}

	@Override
	public void mouseMoved(MouseEvent arg0) {/*rien à faire*/}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {/*rien à faire*/}
}
