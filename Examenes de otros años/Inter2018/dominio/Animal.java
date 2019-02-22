//Clase Animal
//Poseen un peso

package Inter2018.dominio;

public abstract class Animal
{
  //Atributos de Clase

  //Atributos de Instancia
    //Peso en kg del animal
    private float peso;

    public void setPeso(float peso)
      { this.peso = peso;

      }

    public float getPeso()
      { return peso;

      }
    public abstract float comer();
}
