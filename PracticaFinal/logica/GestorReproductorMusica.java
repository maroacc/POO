//Clase Gestora
//Contiene:
//ArrayList de Artistas
//ArrayList de Albumes
package PracticaFinal.logica;
import PracticaFinal.dominio.Album;
import PracticaFinal.dominio.Artista;


import javax.swing.ImageIcon;

import java.util.ArrayList;
//import java.lang.Math;

public class GestorReproductorMusica
{ private ArrayList albumes = new ArrayList();
  private ArrayList artistas = new ArrayList();

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

  // public void reproducirCancion(Cancion cancion)
  //   { ReproductorMusica.reproducirCancion(cancion.getFilePath());
  //
  //   }


}
