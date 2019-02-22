//Clase Vaca
//Posee los atributos de Animal y un nivel de pureza (1-3)
//Sobreescribe el método comer

package Inter2018.dominio;

public class Vaca extends Animal
{ //Atributos de Clase

  //Atributos de instancia
    //Nivel de pureza. Puede tomar valores de 1 a 3
    private int nivelDePureza;

    public Vaca()
      { super.setPeso(0);
        this.setNivelDePureza(0);
      }

    public Vaca(double peso, int nivelDePureza)
      { super.setPeso(peso);
        this.setNivelDePureza(nivelDePureza);
      }

    public void setNivelDePureza(int nivelDePureza)
      { this.nivelDePureza = nivelDePureza;
      }

    public int getNivelDePureza()
      { return nivelDePureza;
      }

    @Override
    public double comer()
      { double cantidadPienso = 0.7 * super.getPeso() - 10 * this.getNivelDePureza();
        return cantidadPienso;
      }

}
