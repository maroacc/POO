//Areas protegidas Terrestre
//Son un tipo de parque Area Protegida
//Además de los atributos de Area Protegida,
//poseen un tipo de terreno
public class AreaProtegidaTerrestre extends AreaProtegida
{
  //Atributos de Clase

  //Atributos de instancia
  String tipoTerreno;

  //Constructores

  public AreaProtegidaTerrestre(  String nombre, int extension, int numeroEspeciesAnimales,   int subvencion, String ONG, String tipoTerreno)
    { super.setNombre(nombre);
      super.setExtension(extension);
      super.setNumeroEspeciesAnimales(numeroEspeciesAnimales);
      super.setSubvencion(subvencion);
      super.setONG(ONG);
      this.setTipoTerreno(tipoTerreno);

    }
  //Getters y setters

  public void setTipoTerreno(String tipoTerreno)
    { this.tipoTerreno = tipoTerreno;

    }

  public String getTipoTerreno()
    { return tipoTerreno;

    }
  @Override
    public String mostrarInformacion()
    { return super.mostrarInformacion() + "\nTipo Terreno: " + this.getTipoTerreno();

    }
}
