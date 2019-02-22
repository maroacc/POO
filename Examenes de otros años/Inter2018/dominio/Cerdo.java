//Clase cerdo
//Posee los atributos de Animal
//Sobreescribe el método comer

package Inter2018.dominio;

public class Cerdo extends Animal
{//Atributos de Clase

 //Atributos de Instancia

 public Cerdo()
  { super.setPeso(0);
  }

 public Cerdo(double peso)
  { super.setPeso(peso);
  }

 @Override
 public double comer()
   { double cantidadPienso = 1.5 * super.getPeso() + 1;
     return cantidadPienso;
   }
}
