//Clase cerdo semi-ibérico
//Posee los atributos de cerdo
//Sobreescribe el método comer

package Inter2018.dominio;

public class CerdoSemiIberico extends Cerdo
{//Atributos de Clase

 //Atributos de Instancia

 public CerdoSemiIberico()
  { super.setPeso(0);
  }

 public CerdoSemiIberico(double peso)
  { super.setPeso(peso);
  }

 @Override
 public double comer()
   { double cantidadPienso = 1.1 * super.getPeso();
     return cantidadPienso;
   }

 @Override
 public String toString()
   { StringBuilder sb = new StringBuilder();
     sb.append("CERDO SEMI IBERICO: Peso = ")
       .append(this.getPeso())
       .append(" Cantidad pienso: ")
       .append(this.comer());
     return sb.toString();
     }
}
