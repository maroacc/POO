package PracticaFinal.dominio;

import java.io.Serializable;

import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Album implements Representable, Serializable
{ private String nombre;
  private ImageIcon caratula;
  private int releaseDate;
  private ArrayList pathCanciones = new ArrayList();
  private ArrayList canciones = new ArrayList();

  public Album()
    { this.setNombre(null);
    }

  public Album(String nombre)
    { this.setNombre(nombre);

    }

  public Album(String nombre,  int releaseDate,  ImageIcon caratula)
    { this.setNombre(nombre);
      this.setReleaseDate(releaseDate);
      this.setImageIcon(caratula);
    }

  public Album(String nombre, int releaseDate, ImageIcon caratula, ArrayList canciones)
    { this.setNombre(nombre);
      this.setReleaseDate(releaseDate);
      this.setImageIcon(caratula);
      this.setCanciones(canciones);
    }
  @Override
  public void setNombre(String nombre)
    { this.nombre = nombre;

    }
  public void setReleaseDate(int releaseDate)
    { this.releaseDate = releaseDate;

    }

  @Override
  public void setImageIcon(ImageIcon caratula)
    { this.caratula = caratula;

    }
  public void setCanciones(ArrayList canciones)
    { this.canciones = canciones;

    }


  @Override
  public String getNombre()
    { return nombre;

    }

  public int getReleaseDate()
    { return releaseDate;

    }

  @Override
  public ImageIcon getImageIcon()
    { return caratula;

    }
  public ArrayList getCanciones()
    { return canciones;

    }
  public void addCancion(Cancion cancion)
    { canciones.add(cancion);

    }
}
