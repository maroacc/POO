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

  //Getters y setters

  public void setCosteLicencia(costeLicencia)
    { this.costeLicencia = costeLicencia;

    }

  public int getCosteLicencia()
    { return costeLicencia;

    }

  public void setTipoArma(tipoArma)
    { this.tipoArma = tipoArma;

    }

  public String getTipoArma()
    { return tipoArma;

    }

}
