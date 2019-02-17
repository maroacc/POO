//Mª José Medina Hernández 2º GITT
//Dibuja 3 cuadrados rojos rellenos en una ventana emergente

public class AppCuadrado01
{
	public static void main(String args[])
	{ Cuadrado cuadrados[] = new Cuadrado[3];
    Dibujo dibujo1 = new Dibujo();

		for (int i=0; i<3; i++)
			{cuadrados[i] = new Cuadrado();
			}

		//Define el atributo de clase RELLENO como true
		Cuadrado.setRELLENO(true);

    cuadrados[0].setLado(4);
    cuadrados[0].setX(4);
    cuadrados[0].setY(4);

    dibujo1.pintar(cuadrados[0]);

		//Espera 1 segundo
    Util.wait(1);

    cuadrados[1].setLado(9);
    cuadrados[1].setX(9);
    cuadrados[1].setY(9);
    dibujo1.pintar(cuadrados[1]);

    Util.wait(1);

    cuadrados[2].setLado(45);
    cuadrados[2].setX(45);
    cuadrados[2].setY(45);
    dibujo1.pintar(cuadrados[2]);



	}
}
