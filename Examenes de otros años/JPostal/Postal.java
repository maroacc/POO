package icai.examen.diciembre2014.dominio;

public abstract class Postal extends Envio

{
  @Override
  public double calcularFactorCarga()
    { return 1;

    }

  @Override
  public double calcularFactorCoste();
    { return 0.5;

    }

}
