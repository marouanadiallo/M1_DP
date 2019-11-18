package mesmaths.cinematique;

import mesmaths.geometrie.base.Vecteur;

/**
 * Arc au sens large : rectiligne ou curviligne
 * Represente une partie d'un contour ferme.
 * 
 * 
 * */
public interface Arc
{

/**
 * Calcule une base orthonormale de 2 vecteurs {i,j} au point d'abscisse curviligne t.
 * On doit avoir 0 <= t <= 1. t == 0 <---> debut de l' arc et t == 1 <---> fin de l' arc 
 * Cette base est telle que i soit un vecteur tangent e l'arc et j soit un vecteur rentrant dans le contour.
 * j indique oe se trouve l'interieur du contour ferme. 
 * |i| == |j| == 1 et i.j == 0
 * @return un tableau t de 2 elements tel que t[0] = i et tel que t[1] = j
 * */
public Vecteur [] base(double t);

/**
 * Calcule la distance signee entre le point p et l'arc this. 
 * Si cette distance est > 0, p est e l'interieur du contour
 * Si cette distance est < 0, p est e l'exterieur du contour
 * Si cette distance est == 0, p est e sur l'arc
 * 
 * */
public double distanceSignee(Vecteur p);

/**
 * Calcule l'abscisse curviligne du projete orthogonal de p sur this
 * 
 * */
public abstract double projeteOrthogonal(Vecteur p);
/**
 * Calcule l'oppose de p suivant la direction et le sens defini par le projete orthogonal N au contour C dont this fait partie.
 * Explication : Le point trouve est unique. 
 * Il est defini comme suit :
 * 
 * Notons d la droite munie du repere oriente {p,n} avec p comme point de passage et n vecteur directeur de la droite orthogonale e this passant par p
 * On suppose que p est dans le contour. n oriente de p vers N.
 * La droite coupe le contour C en 2 points A et B d'eloignement maximal puisque C est ferme et que p est e l'interieur de C.
 * Supposons que les points A, p et B soient orientes dans le sens A < p < B (suivant n).
 * Notons xA, xp,xB les abscisses respectifs de A, p et B suivant le repere {p,n}
 * 
 * notons deltaX = xB - xp.
 * 
 * Alors retourne le point M tel que vecteur(M ->A) == deltaX * n
 * 
 * */
public Vecteur oppose(Vecteur p);

/**
 * Calcule, sur l'arc this, le point de passage  correspondant e l'abscisse curviligne t.
 * 
 * */
public Vecteur evalue(double t);

}
