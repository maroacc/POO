//Mª José Medina Hernández 2º GITT
//Crea 2 reservas de caza y 3 áreas protegidas insertándolas en un array

public class AppParqueNacional
{
	public static void main(String args[])
	{
		//Inicialización del vector de parques nacionales
		ParqueNacional parquesnacionales[] = new ParqueNacional[5];

    parquesnacionales[0] = new ReservaDeCaza( "ReservaDeCaza01", 10000, 2000, 100, "Rifle");
		parquesnacionales[1] = new ReservaDeCaza( "ReservaDeCaza02", 20000, 3000, 200," Rifle");
		parquesnacionales[2] = new AreaProtegida(" AreaProtegida01", 10000, 2000, 5000000, "GreenPeace");
		parquesnacionales[3] = new AreaProtegidaAcuatica("AreaProtegidaAcuatica", 10000, 2000, 5000000, "GreenPeace", 300);
		parquesnacionales[4] = new AreaProtegidaTerrestre("AreaProtegidaAcuatica", 10000, 2000, 5000000, "GreenPeace", "Savana");

		//Mostrar toda la Información sobre los parques almacenados

		System.out.println("INFO PARQUES NACIONALES:\n");

		for (int i=0; i<parquesnacionales.length; i++)
			{ System.out.println(parquesnacionales[i].mostrarInformacion()+ "\n");
			}

		//Mostrar el nombre de los parques almacenados

		System.out.println("\nNOMBRES PARQUES NACIONALES:\n");

		for (int i=0; i<parquesnacionales.length; i++)
			{ System.out.println(parquesnacionales[i].getNombre() + "\n");
			}

//--------------------------------------------------------------------------------------------------------
	 //Inicialización del vector de visitables

	 Visitable visitables[] = new Visitable[4];

	 visitables[0] = new Museo("Prado", "Paseo del Prado, 10", 10);
	 visitables[1] = (AreaProtegida) parquesnacionales[2];
	 visitables[2] = (AreaProtegida) parquesnacionales[3];
	 visitables[3] = (AreaProtegida) parquesnacionales[4];



	//Visitando

	System.out.println("\nVISITAS:\n");

	for (int i=0; i<visitables.length; i++)
		{ System.out.println(visitables[i].visitar("Paco") + "\n");
		}
	}
}
