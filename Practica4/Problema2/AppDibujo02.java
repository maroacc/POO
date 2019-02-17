//Mª José Medina Hernández 2º GITT
//Aplicación para dibujar círculos azules en diagonal

public class AppDibujo02
{ public static void main(String args[])
  { //Declaración de variables
    //Ventana para dibujar
    Dibujo dibujo1 = new Dibujo();
    //Vector de círculos y cuadrados
    Figura figuras[] = new Figura[10];

    //Metemos círculos en el vector de figuras

    for (int i=0; i< figuras.length; i++)
    { figuras[i] = new Circulo(50*i, 50*i, 75, false, 0, 0, 255);
      dibujo1.pintar(figuras[i]);
      Util.wait(1);
    }

  }
}
