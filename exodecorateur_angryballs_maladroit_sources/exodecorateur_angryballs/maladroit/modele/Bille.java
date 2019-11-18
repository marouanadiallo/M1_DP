package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;


/**
 * Cas general d'une bille de billard
 * 
 *  A MODIFIER
 *  
 * 
 * */
public abstract class Bille
{
//----------------- classe Bille-------------------------------------

public abstract void gestionAcceleration(Vector<Bille> billes);



/**
 * gestion de l'eventuelle  collision de cette bille avec les autres billes
 *
 * billes est la liste de toutes les billes en mouvement
 * 
 * Le comportement par defaut est le choc parfaitement elastique (c-e-d rebond sans amortissement)
 * 
 * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 billes impliquees dans le choc sont modifiees
 * si renvoie false, il n'y a pas de collision et les billes sont laissees intactes 
 * */
public boolean gestionCollisionBilleBille(Vector<Bille> billes)
{
	return OutilsBille.gestionCollisionBilleBille(this, billes);
}




/**
 * gestion de l'eventuelle collision de la bille (this) avec le contour rectangulaire de l'ecran defini par (abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur)
 * 
 * detecte si il y a collision et le cas echeant met à jour position et vitesse
 * 
 * La nature du comportement de la bille en reponse à cette collision est definie dans les classes derivees
 * */
public abstract void collisionContour(double abscisseCoinHautGauche, double ordonneeCoinHautGauche, double largeur, double hauteur);

//----------------- classe Bille -------------------------------------
}

