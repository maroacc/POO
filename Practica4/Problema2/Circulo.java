//Mª José Medina Hernández GITT
//Importamos

import java.awt.Color;
import java.awt.*;

public class Circulo extends Figura

{//Atributos de Clase

 //Atributos de instancia
  int radio;
  //Componentes RGB para generar color
  int r;
  int g;
  int b;

  //Extendemos el constructor de figura para crear un círculo
  //Utilizamos el propio constructor de Figura y añadimos el radio
  public Circulo(int x, int y, int radio, Boolean relleno, int r, int g, int b)
      { super(x,y,relleno,r,g,b);
        this.radio = radio;
      }

  public Circulo()
    { this(10, 10, 10, true, 255, 255, 255);

    }

  public void setRadio(int radio)
    { this.radio = radio;

    }
  public int getRadio()
    { return radio;

    }

    //Método pintar: devuelve la información sobre el círculo
    @Override
    public void pintar(Graphics g)
      {
        		if(super.isRelleno())
  					g.fillOval(super.getX(), super.getY(), this.getRadio(), this.getRadio());
  				else
  					g.drawOval(super.getX(), super.getY(), this.getRadio(), this.getRadio());
      }

  }
