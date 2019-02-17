//Definición de la clase que construirán futuros objetos del tipo Persona
public class Persona
{
    String ciudad; //Todas las personas viven en la misma ciudad
    String nombre;
    int edad;

    public Persona(String a, int b, String c)
    {
        nombre = nombre;
        b = edad;
        ciudad = c;
    }

    public Persona(String a, int b)
    {
        this(a, b, c);
    }

    //Métodos
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String s)
    {
        nombre = s;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setEdad(int edad)
    {
        if(edad>0 & edad<120)
            this.edad = edad;
    }

    public String estadistica()
    {
        return "La mitad de la edad en " + ciudad + " es: " + edad/2;
    }

    String getInfo()
    {
    	return "Nombre: " + nombre + "\nEdad: " + edad + "Ciudad" + ciudad;
    }
}
