package mesmaths.solveur;
import java.util.*;
/**
 * dediee e la resolution des equations de la forme f(x)=0 avec x reel et f e valeurs reelles
 * 
 * f est supposee etre une instance d'une classe derivee de Courbe
 * 
 * On suppose que f est une fonction continue, mais c'est mieux si elle derivable (c'est-e-dire si elle fournit un calcul de derivee. cf. classe Courbe)
 * */
public class Solveur
{

private static final double PRECISION = 1.0e-6; // precision des resultats

/**
 * resout l'equation f(x) = 0 sur l'intervalle fini [a,b]
 * 
 * On suppose que f(a)*f(b) < 0 et que l'equation admet une unique solution sur [a,b]
 * 
 * @param f : telle que f(x) = 0 est l'equation e resoudre
 * @param a : borne inferieure de l'intervalle de recherche
 * @param b : borne superieure de l'intervalle de recherche
 * 
 * @return la valeur de x telle que f(x) = 0 et x est dans [a,b]
 * 
 * 
 * */
public static double resout( Courbe f, double a, double b)
{
double fa, f1a, fb, f1b, u, fu, x, fx, f1x, v;

fa = f.evalue(a);
fb = f.evalue(b);

if (fa*fb > 0) throw new IllegalArgumentException("l'equation e resoudre n'a peut-etre pas de solution sur [ " + a + ", " + b + "]");

u = a; fu = fa; v = b;
f1a = f.evalueDerivee(a); 
f1b = f.evalueDerivee(b);

if (Math.abs(f1a) < Math.abs(f1b))              // on part toujours de la borne de plus grande pente
    { x = b; fx = fb; f1x = f1b;}
else
    {x = a; fx = fa; f1x = f1a;}


// la boucle gere les suites Un, f(Un), Xn, f(Xn), f'(Xn) et Vn
while (true)
    {
    double r = fx/f1x;
    x -= r;                                     // iteration Newton
    if (Math.abs(r)<PRECISION) return x;
    
    if (!(u <= x && x <= v)) x = 0.5*(u+v);     // dichotomie si echec de Newton
        
    fx = f.evalue(x);
    f1x = f.evalueDerivee(x);
    
    if (fu*fx<0)
        v = x;
    else
        {u=x; fu = fx;}
    
    }    
}

}
