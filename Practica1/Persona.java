public class Persona
{
	//Atributos
	String nombre;
	int edad;

	//Métodos

	public String getNombre()
	{
		return nombre;

	}

	public void setNombre(String s)
	{
		nombre = s;

	}

	public String getInfo()
	{
		//Concatena el string y el int
		return "Nombre : " + nombre "\nEdad: "+ edad;
	}
}