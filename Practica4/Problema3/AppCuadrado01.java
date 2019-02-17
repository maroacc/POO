//Mª José Medina Hernández 2º GITT
//Crea 2 reservas de caza y 3 áreas protegidas insertándolas en un array

public class AppParqueNacional01
{
	public static void main(String args[])
	{ ParqueNacional parquesnacionales[] = new ParqueNacional[4];


    parquesnacionales[0] = new ReservaDeCaza( ReservaDeCaza01, 10000, 2000, 100, Rifle);
		parquesnacionales[1] = new ReservaDeCaza( ReservaDeCaza02, 20000, 3000, 200, Rifle);
		parquesnacionales[2] = new AreaProtegida( AreaProtegida01, 10000, 2000, 5000000, GreenPeace);
		parquesnacionales[3] = new AreaProtegidaAcuatica(  String nombre, int extension, int numeroEspeciesAnimales,   int subvencion, String ONG, int numeroLagos);
		parquesnacionales[3] = new AreaProtegidaTerrestre(  String nombre, int extension, int numeroEspeciesAnimales,   int subvencion, String ONG, String tipoTerreno);



    parquesnacionales[0].setX(4);
    parquesnacionales[0].setY(4);

    dibujo1.pintar(parquesnacionales[0]);

		//Espera 1 segundo
    Util.wait(1);

    parquesnacionales[1].setLado(9);
    parquesnacionales[1].setX(9);
    parquesnacionales[1].setY(9);
    dibujo1.pintar(parquesnacionales[1]);

    Util.wait(1);

    parquesnacionales[2].setLado(45);
    parquesnacionales[2].setX(45);
    parquesnacionales[2].setY(45);
    dibujo1.pintar(parquesnacionales[2]);



	}
}
