//Clase Gestora
//Contiene:
//ArrayList de Artistas
//ArrayList de Albumes
package PracticaFinal.logica;
import PracticaFinal.ui.JVentana;
import PracticaFinal.dominio.Album;
import PracticaFinal.dominio.Artista;
import PracticaFinal.dominio.Cancion;



import javax.swing.ImageIcon;

import java.util.ArrayList;
//import java.lang.Math;

public class GestorReproductorMusica
{ private ArrayList albumes = new ArrayList();
  private ArrayList artistas = new ArrayList();
  private Cancion cancionEnReproduccion;
  private Album albumEnReproduccion;
  private JVentana jventana;

  public GestorReproductorMusica(JVentana jventana)
    { this.jventana = jventana;

    }

  public void addAlbum(Album album)
    { albumes.add(album);

    }

  public ArrayList getAlbumes()
    { return albumes;

    }

  public void addArtista(Artista artista)
    { artistas.add(artista);

    }

  public ArrayList getArtistas()
    { return artistas;

    }

  public void setCancionEnReproduccion(Cancion cancionEnReproduccion)
    { this.cancionEnReproduccion = cancionEnReproduccion;

    }

  public Cancion getCancionEnReproduccion()
    { return cancionEnReproduccion;

    }
    
  public void setAlbumEnReproduccion(Album albumEnReproduccion)
    { this.albumEnReproduccion = albumEnReproduccion;

    }

  public Album getAlbumEnReproduccion()
    { return albumEnReproduccion;

    }

  public void playAlbum()
    { //while(jventana.getCancionEnReproduccion().getClip().getMicrosecondPosition()< jventana.getCancionEnReproduccion().getClip().getMicrosecondLength())
        // { jventana.getCancionEnReproduccion().play();
        //
        // }
      jventana.getCancionEnReproduccion().play();
    }

  // Pone la siguiente canción del album
  public void pasarDeCancion()
    { int numeroCancion = jventana.getAlbumEnReproduccion().getCanciones().indexOf(jventana.getCancionEnReproduccion());
      jventana.setCancionEnReproduccion((Cancion) jventana.getAlbumEnReproduccion().getCanciones().get(numeroCancion + 1));
    }

}
