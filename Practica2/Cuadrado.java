public class Cuadrado

{ //Atributos de Clase
  static Boolean RELLENO;
  //Atributos
  int x;
  int y;
  int lado;

  public Cuadrado(int x, int y, int lado)
      { this.setX(x);
        this.setY(y);
        this.setLado(lado);

      }
  public Cuadrado()
    { this(10, 10, 10);

    }

    public static void setRELLENO (Boolean relleno)
      { RELLENO = relleno;

      }
    public static Boolean isRELLENO ()
      { return RELLENO;

      }



  public void setLado(int i)
    { lado = i;

    }
  public void setX(int x)
    {
      this.x = x;
    }
  public void setY(int y)
    {
      this.y = y;
    }

  public int getLado()
    {
      return lado;
    }

  public int getX()
    {
      return x;
    }

  public int getY()
    {
      return y;
    }

}
