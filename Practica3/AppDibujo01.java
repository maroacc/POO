//Mª José Medina Hernández 2º GITT
//Aplicación para mostrar la información sobre figuras

public class AppDibujo01
{ public static void main(String args[])
  { //Declaración de variables
    //Ventana para dibujar
    Dibujo dibujo1 = new Dibujo();
    //Vector de círculos y cuadrados
    Figura figuras[] = new Figura[4];

    //Metemos círculos y cuadrados en el vector de figuras
    figuras[0] = new Circulo(100, 25, 20, true, 0, 255, 255);
    figuras[1] = new Cuadrado(100, 100, 10, true, 255, 255, 255);
    figuras[2] = new Circulo(300, 25, 20, true, 0, 255, 255);
    figuras[3] = new Cuadrado(300, 100, 10, false, 255, 0, 255);

    for (int i = 0; i<4; i++)
      { dibujo1.pintar(cuadrados[i]);


      }

  }

}
