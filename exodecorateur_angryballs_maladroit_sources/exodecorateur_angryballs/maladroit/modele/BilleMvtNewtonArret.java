package exodecorateur_angryballs.maladroit.modele;

import java.awt.Color;
import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 * 
 * Bille s'arretant sur les bords et subissant l'attraction des autres billes
 * 
 * 
 *  A MODIFIER
 *  
 *  */

public class BilleMvtNewtonArret extends Bille
{


public BilleMvtNewtonArret(Vecteur position, double rayon, Vecteur vitesse,
        Color couleur)
{
super(position, rayon, vitesse, couleur);
}

/* (non-Javadoc)
 * @see decorateur_angryballs.modele.Bille#gestionAcceleration(java.util.Vector)
 */
@Override
public void gestionAcceleration(Vector<Bille> billes)
{
super.gestionAcceleration(billes);                              // remise e zero du vecteur acceleration
this.getAcceleration().ajoute(OutilsBille.gestionAccelerationNewton(this, billes));     // contribution de l'acceleration due e l'attraction des autres billes
}

@Override
public void collisionContour(double abscisseCoinHautGauche,
        double ordonneeCoinHautGauche, double largeur, double hauteur)
{
Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(), ordonneeCoinHautGauche, hauteur);
}

}
