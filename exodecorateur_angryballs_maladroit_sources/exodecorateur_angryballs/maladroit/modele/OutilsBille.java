package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 * 
 * 
 * Operations utiles sur les Billes
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 *  */

public class OutilsBille
{
/**
 * @param Billes est la liste de TOUTES les Billes en mouvement
 * @param cetteBille est l'une d'entre elles.
 * @return la liste des autres Billes que cetteBille, c'est-e-dire la liste de toutes les Billes sauf cetteBille 
 * 
 * */
public static Vector<Bille> autresBilles(Bille cetteBille, Vector<Bille> Billes)
{
Vector<Bille> autresBilles = new Vector<Bille>();

Bille BilleCourante;

int i;

for( i = 0; i < Billes.size(); ++i)
   {
   BilleCourante = Billes.get(i);
   if ( BilleCourante.getClef() != cetteBille.getClef())
     autresBilles.add(BilleCourante);
   }

return autresBilles;
}


/**
 * @param cetteBille : une Bille particuliere
 * @param Billes : une liste de Billes, cette liste peut contenir cetteBille
 *
 * gestion de l'eventuelle  collision de cette Bille avec les autres Billes
 *
 * Billes est la liste de toutes les Billes en mouvement
 * 
 * Le comportement par defaut est le choc parfaitement elastique (c-e-d rebond sans amortissement)
 * 
 * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 Billes impliquees dans le choc sont modifiees
 * si renvoie false, il n'y a pas de collision et les Billes sont laissees intactes 
 * */
public static  boolean gestionCollisionBilleBille(Bille cetteBille, Vector<Bille> Billes)
{
//--- on recupere d'abord dans autresBilles toutes les Billes sauf cetteBille ----

Vector<Bille> autresBilles = OutilsBille.autresBilles(cetteBille, Billes);

//--- on cherche e present la 1ere des autres Billes avec laquelle cetteBille est en collision ---------------------
//-------------- on suppose qu'il ne peut y avoir de collision qui implique plus de deux Billes e la fois ---------------

Bille BilleCourante;

int i;

for ( i = 0 ; i < autresBilles.size(); ++i)
    {
    BilleCourante = autresBilles.get(i);
    if (Collisions.CollisionBilleBille(    cetteBille.getPosition(),    cetteBille.getRayon(),    cetteBille.getVitesse(),    cetteBille.masse(), 
                                        BilleCourante.getPosition(), BilleCourante.getRayon(), BilleCourante.getVitesse(), BilleCourante.masse()))
       return true; 
    }
return false;
}


/**
 * @param cetteBille : une Bille particuliere
 * @param Billes : une liste de Billes, cette liste peut contenir cetteBille
 * 
 * On suppose que cetteBille subit l'attraction gravitationnelle due aux Billes contenues dans "Billes" autres que cetteBille.
 * 
 * teche : calcule a, le vecteur acceleration subi par cetteBille resultant de l'attraction par les autres Billes de la liste.
 * 
 * @return a : le vecteur acceleration resultant
 * 
 * */
public static Vecteur gestionAccelerationNewton(Bille cetteBille, Vector<Bille> Billes)
{

//--- on recupere d'abord dans autresBilles toutes les Billes sauf celle-ci ----

Vector<Bille> autresBilles = OutilsBille.autresBilles(cetteBille, Billes);

//-------------- e present on recupere les masses et les positions des autres Billes ------------------
int i;
Bille BilleCourante;

int d = autresBilles.size();

double masses [] = new double[d];   // les masses des autres Billes
Vecteur C [] = new Vecteur[d];      // les positions des autres Billes

for ( i = 0; i < d; ++i)
    {
    BilleCourante = autresBilles.get(i);
    masses[i] = BilleCourante.masse();
    C[i] = BilleCourante.getPosition();
    }

//------------------ e present on calcule le champ de gravite exerce par les autres Billes sur cette Bille ------------------

return  MecaniquePoint.champGraviteGlobal( cetteBille.getPosition(),  masses, C);
}
}
