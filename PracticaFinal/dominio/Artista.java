package PracticaFinal.dominio;

import java.io.Serializable;

import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Artista implements Representable, Serializable

{ private String nombre;
  private ImageIcon foto;
  private ArrayList albumes = new ArrayList();

  public Artista()
    { this.setNombre(null);
    }

  public Artista(String nombre)
    { this.setNombre(nombre);

    }

  public Artista(String nombre, ImageIcon foto)
    { this.setNombre(nombre);
      this.setImageIcon(foto);
    }

  public Artista(String nombre, ImageIcon foto, ArrayList albumes)
    { this.setNombre(nombre);
      this.setImageIcon(foto);
      this.setAlbumes(albumes);
    }
  @Override
  public void setNombre(String nombre)
    { this.nombre = nombre;

    }
  @Override
  public void setImageIcon(ImageIcon foto)
    { this.foto = foto;

    }
  public void setAlbumes(ArrayList albumes)
    { this.albumes = albumes;

    }
  @Override
  public String getNombre()
    { return nombre;

    }

  @Override
  public ImageIcon getImageIcon()
    { return foto;

    }

  public void addAlbum(Album album)
    { albumes.add(album);

    }

  public ArrayList getAlbumes()
    { return albumes;

    }
}
