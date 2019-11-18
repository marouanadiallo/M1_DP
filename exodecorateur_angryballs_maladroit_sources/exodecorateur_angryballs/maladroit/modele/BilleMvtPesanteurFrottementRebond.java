package exodecorateur_angryballs.maladroit.modele;

import java.awt.Color;
import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 * 
 * Bille rebondissant sur les murs, subissant un mouvement rectiligne (mouvement en ligne droite) et subissant le frottement dans l'air
 * 
 * Soumis e un vecteur pesanteur
 * 
 * 
 *  A MODIFIER
 *  
 *  */
public class BilleMvtPesanteurFrottementRebond extends Bille
{
Vecteur pesanteur;

public BilleMvtPesanteurFrottementRebond(Vecteur position, double rayon,
        Vecteur vitesse, Vecteur pesanteur, Color couleur)
{
super(position, rayon, vitesse, couleur);
this.pesanteur = pesanteur;
}



/* (non-Javadoc)
 * @see decorateur_angryballs.modele.Bille#gestionAcceleration(java.util.Vector)
 */
@Override
public void gestionAcceleration(Vector<Bille> billes)
{
super.gestionAcceleration(billes);          // remise e zero du vecteur acceleration
this.getAcceleration().ajoute(this.pesanteur);          // contribution du champ de pesanteur (par exemple)
this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse())); // contribution de l'acceleration due au frottement dans l'air
}



@Override
public void collisionContour(double abscisseCoinHautGauche,
        double ordonneeCoinHautGauche, double largeur, double hauteur)
{
Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
}

}
