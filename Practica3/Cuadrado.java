//Mª José Medina Hernández GITT
//Importamos
import java.awt.Color;
public class Cuadrado extends Figura

{//Atributos de Clase

 //Atributos de instancia
  int lado;
  //Componentes RGB para generar color
  int r;
  int g;
  int b;

  //Extendemos el constructor de figura para crear un cuadrado
  //Utilizamos el propio constructor de Figura y añadimos el lado
  public Cuadrado(int x, int y, int lado, Boolean relleno, int r, int g, int b)
      { super(x,y,relleno,r,g,b);
        this.lado = lado;
      }

  public Cuadrado()
    { this(10, 10, 10, true, 255, 255, 255);

    }

  //Método pintar: devuelve la información sobre el cuadrado
  @Override
  public String pintar()
    { return "INFORMACION DEL CUADRADO: \nPosición: (" + x + ","+ y + ")\nLado: " + lado + "\nRelleno: " + relleno + "\nColor: " + color;

    }

}
