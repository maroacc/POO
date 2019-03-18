//Mª José Medina Hernández 2º GITT
//Aplicación para mostrar la información sobre figuras

import java.util.ArrayList;
public class AppDibujo01
{ public static void main(String args[])
  { //Declaración de variables
    //Ventana para dibujar
    Dibujo dibujo1 = new Dibujo();
    //ArrayList de círculos y cuadrados
    ArrayList figuras = new ArrayList();
    //Metemos círculos y cuadrados en el ArrayList de figuras
    figuras.add(new Circulo(50, 50, 150, true, 0, 0, 255));
    figuras.add(new Cuadrado(300, 50, 150, true, 255, 0, 0));
    figuras.add(new Circulo(300, 250, 150, true, 0, 255, 0));
    figuras.add(new Cuadrado(50, 250, 150, false, 255, 0, 0));

    for (int i = 0; i<figuras.size(); i++)
      { dibujo1.pintar((Figura) figuras.get(i));


      }

  }

}
