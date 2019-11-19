package exodecorateur_angryballs.maladroit.modele;

public abstract class DecorateurComportement extends Bille{
	protected Bille billeDecorer;

	public DecorateurComportement(Bille billeDecorer) {

		this.billeDecorer = billeDecorer;
		// TODO Auto-generated constructor stub
	}
	
	public Bille getBille() {
		return billeDecorer;
	}

	public void setBille(Bille bille) {
		this.billeDecorer = bille;
	}

}
