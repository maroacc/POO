//Mª José Medina Hernández GITT
//Importamos
import java.awt.*;

public abstract class Figura
{//Atributos de Clase

 //Atributos de instancia
  Boolean relleno;
  int x;
  int y;
  //Componentes RGB para generar color
  int r;
  int g;
  int b;
  Color color = new Color(255, 255, 255);

  //Constructores

  public Figura(int x, int y, Boolean relleno, int r, int g, int b)
    { this.setX(x);
      this.setY(y);
      this.setRelleno(relleno);
      this.setColor(r, g, b);
    }
  public Figura()
    { this(10, 10, false, 255, 255, 255);

    }

  //Métodos de instancia
  //Getters y setters

  public void setX(int x)
    { this.x = x;

    }
  public int getX()
    { return x;

    }

  public void setY(int y)
    { this.y = y;

    }
  public int getY()
    { return y;

    }

  public void setRelleno(Boolean relleno)
    { this.relleno = relleno;

    }
  public Boolean isRelleno()
    { return relleno;

    }
  public void setColor(int r, int g, int b)
    { color = new Color(r, g, b);

    }


  public Color getColor()
    { return color;

    }

  //Métodos abstractos

  public abstract void pintar(Graphics g);




}
