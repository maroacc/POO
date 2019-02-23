//Clase Gallina
//Posee los atributos de animal
//Sobreescribe el método comer

package Inter2018.dominio;

public class Gallina extends Animal
{
  //Atributos de Clase

  //Atributos de instancia

  public Gallina()
  {
    super.setPeso(0);
  }
  public Gallina(double peso)
  {
    super.setPeso(peso);
  }

  @Override
  public double comer()
    { double cantidadPienso = 0.2 * super.getPeso();
      return cantidadPienso;
    }
  @Override
  public String toString()
    { StringBuilder sb = new StringBuilder();
      sb.append("GALLINA: Peso = ")
        .append(this.getPeso())
        .append(" Cantidad pienso: ")
        .append(this.comer());
      return sb.toString();
      }
}
