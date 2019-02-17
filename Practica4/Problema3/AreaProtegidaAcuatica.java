//Areas protegidas Acuáticas
//Son un tipo de parque Area Protegida
//Además de los atributos de Area Protegida,
//poseen un número de lagos
public class AreaProtegidaAcuatica extends AreaProtegida
{
  //Atributos de Clase

  //Atributos de instancia
  int numeroLagos;

  //Constructores

  public AreaProtegidaAcuatica(String nombre, int extension, int numeroEspeciesAnimales,   int subvencion, String ONG, int numeroLagos)
    { super.setNombre(nombre);
      super.setExtension(extension);
      super.setNumeroEspeciesAnimales(numeroEspeciesAnimales);
      super.setSubvencion(subvencion);
      super.setONG(ONG);
      this.setNumeroLagos(numeroLagos);

    }
  //Getters y setters

  public void setNumeroLagos(int numeroLagos)
    { this.numeroLagos = numeroLagos;

    }

  public int getNumeroLagos()
    { return numeroLagos;

    }

  @Override
    public String mostrarInformacion()
    { return super.mostrarInformacion() + "\nNº Lagos: " + this.getNumeroLagos();

    }
}
