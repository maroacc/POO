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
    figuras[0] = new Circulo(50, 50, 150, true, 0, 0, 255);
    figuras[1] = new Cuadrado(300, 50, 150, true, 255, 0, 0);
    figuras[2] = new Circulo(300, 250, 150, true, 0, 255, 0);
    figuras[3] = new Cuadrado(50, 250, 150, false, 255, 0, 0);

    for (int i = 0; i<figuras.length; i++)
      { dibujo1.pintar(figuras[i]);


      }

  }

}
