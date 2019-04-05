package PracticaFinal.ui;
import PracticaFinal.dominio.Album;
import PracticaFinal.logica.ReproductorMusica;

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


public class JPanelAlbumes extends MiJPanel
{ ReproductorMusica reproductorMusica;

  public JPanelAlbumes(ReproductorMusica reproductorMusica, Color color)
    { super(color);
      this.reproductorMusica = reproductorMusica;

      this.setLayout(new BorderLayout());
      this.setBorder(BorderFactory.createEmptyBorder());
      //Titulo del panel
      JLabel lblAlbumes = new MiJLabel("  ¡lbumes");
      lblAlbumes.setHorizontalAlignment(SwingConstants.LEFT);
      lblAlbumes.setFont(JVentana.FONT_BIG_TITLE);
      this.add(lblAlbumes, BorderLayout.NORTH);

      MiJPanel panelListaAlbumes = new MiJPanel(JVentana.COLOR_SECUNDARIO);
      this.add(panelListaAlbumes, BorderLayout.CENTER);
      panelListaAlbumes.setLayout(new GridLayout(3, 4, 16, 50));
      reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/REPUTATION.jpg")));
      reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/RIO.jpg")));
      reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/RIO.jpg")));
      reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/RIO.jpg")));
      reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/RIO.jpg")));
      reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/RIO.jpg")));
      reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/RIO.jpg")));
      reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/RIO.jpg")));
      reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/RIO.jpg")));

      ArrayList albumes = reproductorMusica.getAlbumes();
      Iterator it = albumes.iterator();
      while (it.hasNext())
      {		//Panel para cada Album. Incluye car√°tula, nombre y artista al que pertenece
          MiJPanel panelAlbum = new MiJPanel(JVentana.COLOR_SECUNDARIO);
          panelAlbum.setLayout(new BorderLayout());
          panelAlbum.setPreferredSize(new Dimension(252,300));
          panelAlbum.setMaximumSize(new Dimension(252,300));

          Album album = (Album) it.next();
          //panelListaAlbumes.add(new JLabel(album.getCaratula()));
          panelAlbum.add(new MiJLabel(album.getCaratula()), BorderLayout.NORTH);
          panelAlbum.add(new MiJLabel(album.getNombre()), BorderLayout.CENTER);
          MiJLabel lbl = new MiJLabel("Duran Duran");
          lbl.setForeground(lbl.getForeground().darker());
          panelAlbum.add(lbl, BorderLayout.SOUTH);
          panelListaAlbumes.add(panelAlbum);
      }



    }

}
