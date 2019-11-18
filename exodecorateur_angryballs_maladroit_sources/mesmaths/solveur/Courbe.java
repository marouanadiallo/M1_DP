package mesmaths.solveur;


/**
 * fonction de la forme : x |---> f(x) dont on va chercher les zeros, c'est-e-dire les valeurs de x pour les quelles on a f(x) = 0
 * 
 * On suppose que x est reel et que f(x) est reel
 * 
 * Les equations specifiques e resoudre sont definies par les classes derivees
 * 
 * 
 * 
 * */
public abstract class Courbe
{

private static final double EPSILON = 0.001;        // valeur petite definie arbitrairement

/**
 * @return la valeur de f(x) 
 * 
 * 
 * */
public abstract double evalue( double x);

/**
 * @return la valeur de f'(x) 
 * 
 * Les classes derivees sont invitees (mais ce n'est pas obligatoire) e fournir un calcul plus precis 
 * 
 * car plus les calculs sont precis, plus l'algo du solveur est rapide
 * 
 * A ce niveau, on ne peut faire qu'un calcul approche.
 * 
 * */
public  double evalueDerivee( double x)
{
double x1 = x + EPSILON;

return (evalue(x1)-evalue(x))/EPSILON;  // approximation du calcul de la derivee
}


}
