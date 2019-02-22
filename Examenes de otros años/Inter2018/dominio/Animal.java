//Clase Animal
//Poseen un peso

package Inter2018.dominio;

public abstract class Animal
{
  //Atributos de Clase

  //Atributos de Instancia
    //Peso en kg del animal
    private double peso;

    public void setPeso(double peso)
      { this.peso = peso;

      }

    public double getPeso()
      { return peso;

      }
    public abstract double comer();
}
