//Clase Gestora
//Contiene:
//ArrayList de Artistas
//ArrayList de Albumes
package PracticaFinal.logica;
import PracticaFinal.dominio.Album;

import javax.swing.ImageIcon;

import java.util.ArrayList;
//import java.lang.Math;

public class ReproductorMusica
{ private ArrayList albumes = new ArrayList();
  private ArrayList artistas = new ArrayList();

  public void addAlbum(Album album)
    { albumes.add(album);

    }

  public ArrayList getAlbumes()
    { return albumes;

    }


}
