//Reservas de Caza
//Son un tipo de parque Nacionales
//Además de los atributos de Parque Nacional,
//poseen coste de licencia y un sólo tipo de arma a utilizar en él

public class ReservaDeCaza extends ParqueNacional
{
  //Atributos de Clase

  //Atributos de instancia
  int costeLicencia;
  String tipoArma;

  //Constructores

  public ReservaDeCaza(  String nombre, int extension, int numeroEspeciesAnimales, int costeLicencia, String tipoArma)
    { super.setNombre(nombre);
      super.setExtension(extension);
      super.setNumeroEspeciesAnimales(numeroEspeciesAnimales);
      this.setCosteLicencia(costeLicencia);
      this.setTipoArma(tipoArma);

    }

  //Getters y setters

  public void setCosteLicencia(int costeLicencia)
    { this.costeLicencia = costeLicencia;

    }

  public int getCosteLicencia()
    { return costeLicencia;

    }

  public void setTipoArma(String tipoArma)
    { this.tipoArma = tipoArma;

    }

  public String getTipoArma()
    { return tipoArma;

    }

  @Override
  public String mostrarInformacion()
    { return super.mostrarInformacion() + "\nCoste Licencia: " + this.getCosteLicencia() + "\nTipo de Arma: " + this.getTipoArma();

    }

}
