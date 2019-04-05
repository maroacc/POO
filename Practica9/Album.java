package PracticaFinal.dominio;

import java.util.ArrayList;

public class Album
{ private String nombre;
  private ImageIcon caratula;
  private ArrayList canciones;

  public Album()
    { this.setNombre(null);
    }

  public Album(String nombre)
    { this.setNombre(null);

    }

  public Album(String nombre, ImageIcon caratula)
    { this.setNombre(nombre);
      this.setCaratula(caratula);
    }
    
  public Album(String nombre, ImageIcon caratula, ArrayList canciones)
    { this.setNombre(nombre);
      this.setCaratula(caratula);
      this.setCanciones(canciones);
    }

  public void setNombre(String nombre)
    { this.nombre = nombre;

    }

  public void setCaratula(ImageIcon caratula)
    { this.caratula = caratula;

    }
  public void setNombre(ArrayList canciones)
    { this.canciones = canciones;

    }

  public String getNombre()
    { return nombre;

    }

  public ImageIcon getCaratula()
    { return caratula;

    }
  public ArrayList setNombre()
    { return canciones;

    }
}
