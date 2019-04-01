//Mª José Medina Hernández 2º GITT
//Aplicación para dibujar círculos azules en diagonal

public class AppDibujo02
{ public static void main(String args[])
  { //Declaración de variables
    public static final N_CIRCULOS = 10;
    //Ventana para dibujar
    Dibujo dibujo1 = new Dibujo();
    //ArrayList de círculos y cuadrados
    ArrayList figuras = new ArrayList();
    //Metemos círculos en el ArrayList de figuras

    for (int i=0; i< N_CIRCULOS; i++)
    { Figura figura = figuras.add(new Circulo(50*i, 50*i, 75, false, 0, 0, 255));
      dibujo1.pintar(figuras);
      Util.wait(1);
    }

  }
}
