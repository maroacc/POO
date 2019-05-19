
package PracticaFinal.ui;
import PracticaFinal.dominio.Representable;
import PracticaFinal.dominio.Album;
import PracticaFinal.dominio.Artista;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;



import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.Image;
import java.awt.Dimension;


public class JPanelArtistas extends MiJPanel
{ MiJLabel lblTitulo = new MiJLabel();
  Collection collection = new ArrayList();
  JVentana jventana;

  public JPanelArtistas(JVentana jventana, String titulo, Collection collection, Color color)
    { super(color);
      this.jventana = jventana;
      this.setTitulo(titulo);
      this.setLayout(new BorderLayout(4, 40));

      lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
      lblTitulo.setFont(JVentana.FONT_BIG_TITLE);
      this.add(lblTitulo, BorderLayout.NORTH);

      this.setBorder(BorderFactory.createEmptyBorder());


      MiJPanel panelListaAlbumes = new MiJPanel(JVentana.COLOR_SECUNDARIO);
      this.add(panelListaAlbumes, BorderLayout.CENTER);
      panelListaAlbumes.setLayout(new GridLayout(0, 3, 16, 50));

      Iterator it = collection.iterator();
      while (it.hasNext())
      {		//Panel para cada Album. Incluye carátula, nombre y artista al que pertenece
          MiJPanel panelAlbum = new MiJPanel(JVentana.COLOR_SECUNDARIO);
          panelAlbum.setLayout(new BorderLayout());
          panelAlbum.setPreferredSize(new Dimension(252,300));
          panelAlbum.setMaximumSize(new Dimension(252,300));

          Artista artista = (Artista) it.next();
          panelAlbum.add(new MiJLabel(artista.getNombre()), BorderLayout.CENTER);
          MiJButton mjb = new MiJButton(artista.getImageIcon(), artista.getImageIcon());
          mjb.setHorizontalAlignment(SwingConstants.CENTER);
          mjb.addActionListener(new ActionListener()
            {@Override
              public void actionPerformed(ActionEvent e)
                {
                  jventana.remove(jventana.getVentanaActual());
                  JScrollPaneAlbumesDeArtista jventanaAlbumesArtista = new JScrollPaneAlbumesDeArtista(jventana, artista.getNombre(), artista.getAlbumes(), jventana.COLOR_SECUNDARIO);
                  jventana.add(jventanaAlbumesArtista, BorderLayout.CENTER);
                  jventana.setVentanaActual(jventanaAlbumesArtista);
                  jventana.BTN_ARTISTAS.setForeground(MiJButton.COLOR_DEFECTO);
                  jventana.BTN_ARTISTAS.setFont(JVentana.FONT_TITLE);
                  jventana.repaint();
                  jventana.setVisible(true);
                }

            });
          panelAlbum.add(mjb, BorderLayout.NORTH);
          panelListaAlbumes.add(panelAlbum);
      }

    }
    public void setTitulo(String titulo)
      { //Titulo del panel
        lblTitulo.setText(titulo);

      }

    public void setCollection(Collection collection)
      { this.collection = collection;

      }
}
