package exodecorateur_angryballs.maladroit.modele;

import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 * 
 * 
 * Operations utiles sur les BilleNormals
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 *  */

public class OutilsBille
{
/**
 * @param BilleNormals est la liste de TOUTES les BilleNormals en mouvement
 * @param cetteBilleNormal est l'une d'entre elles.
 * @return la liste des autres BilleNormals que cetteBilleNormal, c'est-e-dire la liste de toutes les BilleNormals sauf cetteBilleNormal 
 * 
 * */
public static Vector<BilleNormal> autresBilleNormals(BilleNormal cetteBilleNormal, Vector<BilleNormal> BilleNormals)
{
Vector<BilleNormal> autresBilleNormals = new Vector<BilleNormal>();

BilleNormal BilleNormalCourante;

int i;

for( i = 0; i < BilleNormals.size(); ++i)
   {
   BilleNormalCourante = BilleNormals.get(i);
   if ( BilleNormalCourante.getClef() != cetteBilleNormal.getClef())
     autresBilleNormals.add(BilleNormalCourante);
   }

return autresBilleNormals;
}


/**
 * @param cetteBilleNormal : une BilleNormal particuliere
 * @param BilleNormals : une liste de BilleNormals, cette liste peut contenir cetteBilleNormal
 *
 * gestion de l'eventuelle  collision de cette BilleNormal avec les autres BilleNormals
 *
 * BilleNormals est la liste de toutes les BilleNormals en mouvement
 * 
 * Le comportement par defaut est le choc parfaitement elastique (c-e-d rebond sans amortissement)
 * 
 * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 BilleNormals impliquees dans le choc sont modifiees
 * si renvoie false, il n'y a pas de collision et les BilleNormals sont laissees intactes 
 * */
public static  boolean gestionCollisionBilleBille(BilleNormal cetteBilleNormal, Vector<BilleNormal> BilleNormals)
{
//--- on recupere d'abord dans autresBilleNormals toutes les BilleNormals sauf cetteBilleNormal ----

Vector<BilleNormal> autresBilleNormals = OutilsBille.autresBilleNormals(cetteBilleNormal, BilleNormals);

//--- on cherche e present la 1ere des autres BilleNormals avec laquelle cetteBilleNormal est en collision ---------------------
//-------------- on suppose qu'il ne peut y avoir de collision qui implique plus de deux BilleNormals e la fois ---------------

BilleNormal BilleNormalCourante;

int i;

for ( i = 0 ; i < autresBilleNormals.size(); ++i)
    {
    BilleNormalCourante = autresBilleNormals.get(i);
    if (Collisions.CollisionBilleBille(    cetteBilleNormal.getPosition(),    cetteBilleNormal.getRayon(),    cetteBilleNormal.getVitesse(),    cetteBilleNormal.masse(), 
                                        BilleNormalCourante.getPosition(), BilleNormalCourante.getRayon(), BilleNormalCourante.getVitesse(), BilleNormalCourante.masse()))
       return true; 
    }
return false;
}


/**
 * @param cetteBilleNormal : une BilleNormal particuliere
 * @param BilleNormals : une liste de BilleNormals, cette liste peut contenir cetteBilleNormal
 * 
 * On suppose que cetteBilleNormal subit l'attraction gravitationnelle due aux BilleNormals contenues dans "BilleNormals" autres que cetteBilleNormal.
 * 
 * teche : calcule a, le vecteur acceleration subi par cetteBilleNormal resultant de l'attraction par les autres BilleNormals de la liste.
 * 
 * @return a : le vecteur acceleration resultant
 * 
 * */
public static Vecteur gestionAccelerationNewton(BilleNormal cetteBilleNormal, Vector<BilleNormal> BilleNormals)
{

//--- on recupere d'abord dans autresBilleNormals toutes les BilleNormals sauf celle-ci ----

Vector<BilleNormal> autresBilleNormals = OutilsBille.autresBilleNormals(cetteBilleNormal, BilleNormals);

//-------------- e present on recupere les masses et les positions des autres BilleNormals ------------------
int i;
BilleNormal BilleNormalCourante;

int d = autresBilleNormals.size();

double masses [] = new double[d];   // les masses des autres BilleNormals
Vecteur C [] = new Vecteur[d];      // les positions des autres BilleNormals

for ( i = 0; i < d; ++i)
    {
    BilleNormalCourante = autresBilleNormals.get(i);
    masses[i] = BilleNormalCourante.masse();
    C[i] = BilleNormalCourante.getPosition();
    }

//------------------ e present on calcule le champ de gravite exerce par les autres BilleNormals sur cette BilleNormal ------------------

return  MecaniquePoint.champGraviteGlobal( cetteBilleNormal.getPosition(),  masses, C);
}
}
