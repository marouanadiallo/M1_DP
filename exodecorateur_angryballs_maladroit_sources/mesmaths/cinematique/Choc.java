package mesmaths.cinematique;

import mesmaths.geometrie.base.Vecteur;

/**
 * represente un choc. Defini par une position et une intensite.
 * Cette classe a pour but de diffuser un son occasionne par un choc
 * */
public class Choc
{
Vecteur position;
double intensite; // quantite > 0

/**
 * @param position
 * @param intensite
 */
public Choc(Vecteur position, double intensite)
{
this.position = position;
this.intensite = intensite;
}

@Override
public String toString()
{
return "Choc [position=" + this.position + ", intensite=" + this.intensite
        + "]";
}

public Vecteur getPosition()
{
return this.position;
}

public double getIntensite()
{
return this.intensite;
}


}
