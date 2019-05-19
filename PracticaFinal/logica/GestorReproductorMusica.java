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
import java.util.Random;

//import java.lang.Math;

public class GestorReproductorMusica
{ public static final int MODO_NORMAL = 1;
  public static final int MODO_ALEATORIO = 2;
  public static final int MODO_BUCLE = 3;


  private ArrayList albumes = new ArrayList();
  private ArrayList artistas = new ArrayList();
  private Cancion cancionEnReproduccion;
  private Album albumEnReproduccion;
  private JVentana jventana;
  private int modo;

  public GestorReproductorMusica(JVentana jventana)
    { this.jventana = jventana;
      this.setCancionEnReproduccion(jventana.getCancionEnReproduccion());
      this.setAlbumEnReproduccion(jventana.getAlbumEnReproduccion());
      this.setModo(MODO_NORMAL);

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
  public void setModo(int modo)
    { this.modo = modo;

    }

  public int getModo()
    { return modo;

    }
  // public void playAlbum()
  //   { //while(jventana.getCancionEnReproduccion().getClip().getMicrosecondPosition()< jventana.getCancionEnReproduccion().getClip().getMicrosecondLength())
  //       // { jventana.getCancionEnReproduccion().play();
  //       //
  //       // }
  //     jventana.getCancionEnReproduccion().play();
  //   }

  // Pone la canción anterior del album
  public void reproducirCancionAnterior()
    { // Recoge el estado de la cancion que se está reproduciendo actualmente (play/pause) para
      // que la cancion anterior conmienze en ese mismo estado
      try
      { String estadoSiguienteCancion = jventana.getCancionEnReproduccion().getEstado();
        jventana.getCancionEnReproduccion().restart();
        jventana.getCancionEnReproduccion().pause();
        int numeroCancion = jventana.getAlbumEnReproduccion().getCanciones().indexOf(jventana.getCancionEnReproduccion());
        if(numeroCancion == 0)
              jventana.setCancionEnReproduccion((Cancion) jventana.getAlbumEnReproduccion().getCanciones().get(jventana.getAlbumEnReproduccion().getCanciones().size()-1));
        else
              jventana.setCancionEnReproduccion((Cancion) jventana.getAlbumEnReproduccion().getCanciones().get(numeroCancion - 1));
          jventana.getCancionEnReproduccion().play();
          jventana.getCancionEnReproduccion().setEstado(estadoSiguienteCancion);
      }
      catch (Exception e)
        { e.printStackTrace();

        }
      }

  // Pone la siguiente canción del album
  public void reproducirSiguienteCancion()
    { // Recoge el estado de la cancion que se está reproduciendo actualmente (play/pause) para
      // que la cancion siguiente conmienze en ese mismo estado
      try
      { String estadoSiguienteCancion = jventana.getCancionEnReproduccion().getEstado();
        jventana.getCancionEnReproduccion().restart();
        jventana.getCancionEnReproduccion().pause();
        int numeroCancion = jventana.getAlbumEnReproduccion().getCanciones().indexOf(jventana.getCancionEnReproduccion());
        if(numeroCancion == jventana.getAlbumEnReproduccion().getCanciones().size()-1)
          jventana.setCancionEnReproduccion((Cancion) jventana.getAlbumEnReproduccion().getCanciones().get(0));
        else
          jventana.setCancionEnReproduccion((Cancion) jventana.getAlbumEnReproduccion().getCanciones().get(numeroCancion + 1));
        jventana.getCancionEnReproduccion().play();
        jventana.getCancionEnReproduccion().setEstado(estadoSiguienteCancion);
      }
      catch (Exception e)
        { e.printStackTrace();

        }

    }

    // Reproduce una cancion aleatoria dentro del album al que pertenece la cancion en reproduccion
    public void reproducirCancionAleatoria()
      { // Recoge el estado de la cancion que se está reproduciendo actualmente (play/pause) para
        // que la cancion siguiente conmienze en ese mismo estado
        try
        { String estadoSiguienteCancion = jventana.getCancionEnReproduccion().getEstado();
          jventana.getCancionEnReproduccion().restart();
          jventana.getCancionEnReproduccion().pause();
          Random r = new Random();
          int numeroAleatorio = r.nextInt( jventana.getAlbumEnReproduccion().getCanciones().size());
          jventana.setCancionEnReproduccion((Cancion) jventana.getAlbumEnReproduccion().getCanciones().get(numeroAleatorio));
          jventana.getCancionEnReproduccion().play();
          jventana.getCancionEnReproduccion().setEstado(estadoSiguienteCancion);
        }
        catch (Exception e)
          { e.printStackTrace();

          }

      }

}
