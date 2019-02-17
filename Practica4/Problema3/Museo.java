//Museos
//Poseen nombre, dirección y precio
//Poseen un guia si alguien los visista

public class Museo implements Visitable
{
  //Atributos de Clase

  //Atributos de instancia
  String nombre;
  String direccion;
  int precio;

//Constructores

  public Museo(  String nombre, String direccion, int precio)
    { this.setNombre(nombre);
      this.setDireccion(direccion);
      this.setPrecio(precio);

    }

//Getters y setters
  public void setNombre(String nombre)
    { this.nombre = nombre;

    }

  public String getNombre()
    { return nombre;

    }

  public void setDireccion(String direccion)
    { this.direccion = direccion;

    }

  public String getDireccion()
    { return direccion;

    }

  public void setPrecio(int precio)
    { this.precio = precio;

    }

  public int getPrecio()
    { return precio;

    }


  @Override
  public String visitar(String guia)
    { return "\nVisitando museo " + nombre + " con el guía " + guia + "a un precio de" + precio;

    }

}
