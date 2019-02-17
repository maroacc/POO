//Mª José Medina Hernández 2º GITT
//Aplicación para mostrar la información sobre figuras

public class AppDibujo02
{ public static void main(String args[])
  { //Declaración de variables
    //Vector de círculos y cuadrados
    Figura figuras[] = new Figura[3];

    //Metemos círculos y cuadrados en el vector de figuras
    figuras[0] = new Cuadrado(10, 10, 10, true, 255, 255, 255);
    figuras[1] = new Circulo(20, 20, 20, true, 0, 255, 255);
    figuras[2] = new Cuadrado(30, 30, 10, false, 255, 0, 255);

    for (int i = 0; i<3; i++)
      { System.out.println(figuras[i].pintar());
        //Espera 1 segundo
        Util.wait(1);

      }

  }

}
