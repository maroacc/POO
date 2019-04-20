package PracticaFinal.dominio;

import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Album implements Representable
{ private String nombre;
  private ImageIcon caratula;
  private ArrayList canciones = new ArrayList();

  public Album()
    { this.setNombre(null);
    }

  public Album(String nombre)
    { this.setNombre(nombre);

    }

  public Album(String nombre, ImageIcon caratula)
    { this.setNombre(nombre);
      this.setImageIcon(caratula);
    }

  public Album(String nombre, ImageIcon caratula, ArrayList canciones)
    { this.setNombre(nombre);
      this.setImageIcon(caratula);
      this.setCanciones(canciones);
    }
  @Override
  public void setNombre(String nombre)
    { this.nombre = nombre;

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
