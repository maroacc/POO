package icai.examen.diciembre2014.dominio;

public abstract class Envio

{ private String id;
  private boolean urgete;
  private double factorCarga;
  private Cliente remitente;
  private Cliente destinatario;

  public abstract double calcularFactorCarga();
  public abstract double calcularFactorCoste();

  @Override
  public int compareTo(Object o)
    { if (o instanceof Envio)
        { Envio envio = (Envio) o;
          if (envio.isUrgente())
            return 1;
          else
            return 0;

        }
      else
        return -1;

    }

  @Override
  public boolean equals(Object o)
    { if (o instanceof Envio)
        { Envio envio = (Envio) o;
          if (envio.getID() == this.getID)
            return true;
          else
            return false;

        }
      else
        return false;

      }

}
