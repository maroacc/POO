//Trabajador es una Persona
public class Trabajador extends Persona
{
    String profesion;

    public Trabajador(String nombre, int edad, String profesion)
    {
        super.Persona(String nombre, int edad);
    }

    String getProfesion()
    {
        return profesion;
    }

    void setProfesion(String profesion)
    {
        this.profesion = profesion;
    }

   @Override
    public String getinfo()
    {
        return "Nombre............" + this.formatear(nombre) + "\nEdad..........." +
         this.formatear(edad) + "\nCiudad........." + CIUDAD + "<br />" +  "\nProfesion: " + this.formatear(profesion);
    }
}
