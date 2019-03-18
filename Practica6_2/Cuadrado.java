//Mª José Medina Hernández GITT
//Importamos
import java.awt.Color;
import java.awt.*;

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
    { this(10, 10, 10, true, 255, 0, 255);

    }

  public void setLado(int lado)
    { this.lado = lado;

    }
  public int getLado()
    { return lado;

    }


  //Método pintar
  @Override
  public void pintar(Graphics g)
    {
				if(super.isRelleno())
					g.fillRect(super.getX(), super.getY(), this.getLado(), this.getLado());
				else
					g.drawRect(super.getX(), super.getY(), this.getLado(), this.getLado());
    }

}
