//Mª José Medina Hernández 2º GITT
//Aplicación para pintar figuras por grupos de colores

import java.util.HashMap;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.JFrame;

public class AppDibujo01
{ public static void main(String args[])
  { //Declaración de variables
    //Ventana para dibujar
    Dibujo dibujo1 = new Dibujo();
    dibujo1.pintar("Grupo Rojo", new Cuadrado(100, 400, 100, true, Color.RED, true));
    dibujo1.pintar("Grupo Rojo", new Cuadrado(100, 100, 50, true, Color.RED, true));
    dibujo1.pintar("Grupo Rojo", new Cuadrado(200, 100, 50, true, Color.RED, true));
    dibujo1.pintar("Grupo Verde", new Cuadrado(300, 100, 50, true, Color.GREEN, true));
    dibujo1.pintar("Grupo Azul", new Cuadrado(200, 400, 50, true, Color.BLUE, true));

    Util.wait(1);
    dibujo1.ocultarGrupo("Grupo Rojo");
    Util.wait(1);
    dibujo1.ocultarGrupo("Grupo Verde");
    Util.wait(1);
    dibujo1.ocultarGrupo("Grupo Azul");
    Util.wait(1);
    dibujo1.mostrarTodasFiguras();


  }

}
