package icai.examen.diciembre2014.dominio;

public class Vehiculo

{ private String matricula;
  private int movil;
  private double factorCarga;
  HashSet envios;

  public boolean addEnvio()
    { if (factorCargaEnvios + envio.calcularFactorCarga() < factorCarga)
        {envios.add(envio);
        return true;
        }
      else
        return false;
    }

  public double calcularFactorCargaEnvios()
    { double factorCargaEnvios;
      Iterator it = envio.iterator();
      while (it.hasNext());
        {  factorCargaEnvios = factorCargaEnvios + envio.calcularFactorCarga();

        }

    }

  @Override
  public String toString()
    { StringBuider sb = new StringBuider();
      return sb.append("MATRICULA: ")
               .append(matricula)
               .append("FACTOR DE CARGA: ")
               .append(factorCarga)
               .append("MOVIL: ")
               .append(movil);


    }


}
