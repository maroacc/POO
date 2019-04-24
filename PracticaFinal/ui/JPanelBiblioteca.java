package PracticaFinal.ui;
import PracticaFinal.dominio.Representable;
import PracticaFinal.dominio.Album;

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


public class JPanelBiblioteca extends MiJPanel
{ MiJLabel lblTitulo = new MiJLabel();
  Collection collection = new ArrayList();

  public JPanelBiblioteca(String titulo, Collection collection, Color color)
    { super(color);
      this.setTitulo(titulo);
      lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
      lblTitulo.setFont(JVentana.FONT_BIG_TITLE);
      this.add(lblTitulo, BorderLayout.NORTH);

      this.setLayout(new BorderLayout(4, 40));
      this.setBorder(BorderFactory.createEmptyBorder());


      MiJPanel panelListaAlbumes = new MiJPanel(JVentana.COLOR_SECUNDARIO);
      this.add(panelListaAlbumes, BorderLayout.CENTER);
      panelListaAlbumes.setLayout(new GridLayout(3, 4, 16, 50));

      Iterator it = collection.iterator();
      while (it.hasNext())
      {		//Panel para cada Album. Incluye carátula, nombre y artista al que pertenece
          MiJPanel panelAlbum = new MiJPanel(JVentana.COLOR_SECUNDARIO);
          panelAlbum.setLayout(new BorderLayout());
          panelAlbum.setPreferredSize(new Dimension(252,300));
          panelAlbum.setMaximumSize(new Dimension(252,300));

          Representable rpr = (Representable) it.next();
          panelAlbum.add(new MiJLabel(rpr.getNombre()), BorderLayout.CENTER);
          MiJButton mjb = new MiJButton(rpr.getImageIcon(), rpr.getImageIcon());
          mjb.setHorizontalAlignment(SwingConstants.CENTER);
          panelAlbum.add(mjb, BorderLayout.NORTH);
          MiJLabel lbl = new MiJLabel("Duran Duran");
          lbl.setForeground(lbl.getForeground().darker());
          panelAlbum.add(lbl, BorderLayout.SOUTH);
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
