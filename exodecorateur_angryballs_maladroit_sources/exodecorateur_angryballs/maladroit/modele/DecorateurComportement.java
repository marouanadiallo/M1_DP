package exodecorateur_angryballs.maladroit.modele;

public abstract class DecorateurComportement extends Bille{
	protected Bille bille;

	public DecorateurComportement(Bille bille) {

		this.bille = bille;
		// TODO Auto-generated constructor stub
	}
	
	public Bille getBille() {
		return bille;
	}

	public void setBille(Bille bille) {
		this.bille = bille;
	}

}
