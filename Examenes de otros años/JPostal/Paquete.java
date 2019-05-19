package icai.examen.diciembre2014.dominio;

public abstract class Paquete extends Envio

{
  private double peso;
  private double volumen;

  @Override
  public double calcularFactorCarga()
    { return peso*volumen;

    }

  @Override
  public double calcularFactorCoste();
    { return 0.5 + this.calcularFactorCarga();

    }

}
