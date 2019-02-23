//App para controlar la Granja
//Crea 2 granjas con 2 animales cada buscarPersona
//Muestra la cantidad de pienso a distribuir
//Muestra la informacion completa de cada ggranjas

package Inter2018.ui;
import Inter2018.dominio.*;
public class AppGranja
{
  public static void main(String args[])
  {  Granja granja1 = new Granja("PACO", "TOLEDO");
     Granja granja2 = new Granja("CURRO", "ALMERIA");

     CerdoNoIberico cerdo1 = new CerdoNoIberico(100);
     Vaca vaca1 = new Vaca(200, 2);
     Gallina gallina1 = new Gallina(1);
     CerdoSemiIberico cerdo2 = new CerdoSemiIberico(120);

     granja1.addAnimal(cerdo1);
     granja1.addAnimal(vaca1);
     granja2.addAnimal(gallina1);
     granja2.addAnimal(cerdo2);

     System.out.println("CANTIDAD GRANJA1 : " + granja1.cantidadPienso());
     System.out.println("CANTIDAD GRANJA2 : " + granja2.cantidadPienso());

     System.out.println(granja1.toString());

  }
}
