//Clase cerdo no ibérico
//Posee los atributos de cerdo
//Sobreescribe el método comer

package Inter2018.dominio;

public class CerdoNoIberico extends Cerdo
{//Atributos de Clase

 //Atributos de Instancia

 public CerdoNoIberico()
  { super.setPeso(0);
  }

 public CerdoNoIberico(double peso)
  { super.setPeso(peso);
  }

 @Override
 public double comer()
   { double cantidadPienso = 1.4 * super.getPeso();
     return cantidadPienso;
   }
}
