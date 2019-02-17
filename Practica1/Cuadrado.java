//Mª José Medina Hernández 2ºA GITT

public class Cuadrado

{
  //Atributos

  int ejex;  //Posición en píxeles del ejex
  int ejey;  //Posición en píxeles del ejey
  int lado;  //Longitud del lado en píxeles

  public void setLado(int i)
    { lado = i;

    }
  public void setX(int x){
    ejex = x;
  }
  public void setY(int y){
    ejey = y;
  }

  public int getLado()
  {
    return lado;
  }

  public int getX()
  {
    return ejex;
  }

  public int getY()
  {
    return ejey;
  }

}
