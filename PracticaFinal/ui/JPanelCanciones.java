package PracticaFinal.ui;
import PracticaFinal.dominio.Representable;
import PracticaFinal.dominio.Album;
import PracticaFinal.dominio.Cancion;

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


public class JPanelCanciones extends MiJPanel
{ private MiJLabel lblTitulo = new MiJLabel();
  private MiJLabel lblCaratula;
  private Collection collection = new ArrayList();
  private JVentana jventana;
  public static ArrayList BOTONES_PLAY = new ArrayList();
  public static MiJButtonDosEstados BTN_PLAY_CANCION_SELECCIONADA = new MiJButtonDosEstados(new ImageIcon("PracticaFinal/iconos/play-juan-grey.png"),
                                                                    new ImageIcon("PracticaFinal/iconos/play-juan-white.png"),
                                                                    new ImageIcon("PracticaFinal/iconos/pause-juan-grey.png"),
                                                                    new ImageIcon("PracticaFinal/iconos/pause-juan-white.png"));

  public JPanelCanciones( JVentana jventana, String titulo, ImageIcon caratula, Collection collection, Color color)
    { super(color);
      this.jventana = jventana;
      this.setLayout(new BorderLayout(4, 40));
      MiJPanel panelSuperior = new MiJPanel(JVentana.COLOR_SECUNDARIO);
      this.add(panelSuperior, BorderLayout.NORTH);
      panelSuperior.setLayout(new BorderLayout());
      MiJPanel panelInfo = new MiJPanel(JVentana.COLOR_SECUNDARIO);
      panelSuperior.add(panelInfo, BorderLayout.CENTER);
      panelInfo.setLayout(new BorderLayout());

      this.setTitulo(titulo);
      lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
      lblTitulo.setFont(JVentana.FONT_BIG_TITLE);
      panelInfo.add(lblTitulo, BorderLayout.NORTH);
      panelInfo.add(new MiJLabel("De Beyoncé"), BorderLayout.CENTER);
      panelInfo.add(new MiJLabel("2018"), BorderLayout.SOUTH);
      this.setCaratula(caratula);
      panelSuperior.add(lblCaratula, BorderLayout.WEST);
      this.setCollection(collection);
      this.setBorder(BorderFactory.createEmptyBorder());
      this.setListaCanciones();
    }

    public JPanelCanciones( JVentana jventana, String titulo, Collection collection, Color color)
      { super(color);
        this.jventana = jventana;
        this.setLayout(new BorderLayout(4, 40));
        this.setTitulo(titulo);
        lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitulo.setFont(JVentana.FONT_BIG_TITLE);
        this.add(lblTitulo, BorderLayout.NORTH);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setCollection(collection);
        this.setListaCanciones();
      }
    public void setTitulo(String titulo)
      { //Titulo del panel
        lblTitulo.setText(titulo);

      }

    public void setCollection(Collection collection)
      { this.collection = collection;

      }

    public void setCaratula(ImageIcon caratula)
      { lblCaratula = new MiJLabel(caratula);
        lblCaratula.setPreferredSize(new Dimension(270, 270));

      }

    public void desactivarBOTONES_PLAY()
      { Iterator it = BOTONES_PLAY.iterator();
        while (it.hasNext())
          { MiJButtonDosEstados btnPlay = (MiJButtonDosEstados) it.next();
            btnPlay.setIcon(btnPlay.getIcon1Default());
            btnPlay.setEstado(MiJButtonDosEstados.ESTADO_1);

          }
      }
    public static void cambiarBntPlay(int numeroCancion)
      { BTN_PLAY_CANCION_SELECCIONADA.setIcon(JVentana.BTN_PLAY.getIcon1Default());
        BTN_PLAY_CANCION_SELECCIONADA.setEstado(MiJButtonDosEstados.ESTADO_1);
        BTN_PLAY_CANCION_SELECCIONADA = (MiJButtonDosEstados) BOTONES_PLAY.get(numeroCancion);

      }
    public void setListaCanciones()
      { MiJPanel panelListaCanciones = new MiJPanel(JVentana.COLOR_SECUNDARIO);
        this.add(panelListaCanciones, BorderLayout.CENTER);
        panelListaCanciones.setLayout(new GridLayout(0, 1, 5, 5));
        MiJPanel primerPanel = new MiJPanel(JVentana.COLOR_SECUNDARIO);
        primerPanel.setLayout(new BorderLayout());
        primerPanel.setPreferredSize(new Dimension(252,40));
        primerPanel.setMaximumSize(new Dimension(252,40));
        MiJLabel lblHashtag = new MiJLabel("#");
        lblHashtag.setPreferredSize(new Dimension(40, 40));
        primerPanel.add(lblHashtag, BorderLayout.WEST);
        primerPanel.add(new MiJLabel("TITULO"), BorderLayout.CENTER);
        MiJLabel lblReloj = new MiJLabel(new ImageIcon("PracticaFinal/iconos/clock.png"));
        lblReloj.setPreferredSize(new Dimension(250, 40));
        primerPanel.add(lblReloj , BorderLayout.EAST);

        panelListaCanciones.add(primerPanel);
        int numeroCancion = 1;

        Iterator it = collection.iterator();
        while (it.hasNext())
        {		//Panel para cada Album. Incluye carátula, nombre y artista al que pertenece
            MiJPanel panelCancion = new MiJPanel(JVentana.COLOR_SECUNDARIO);
            panelCancion.setLayout(new BorderLayout());
            panelCancion.setPreferredSize(new Dimension(252,40));
            panelCancion.setMaximumSize(new Dimension(252,40));
            panelCancion.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 1, JVentana.COLOR_FONDO));

            Cancion cancion = (Cancion) it.next();
            MiJLabel lblNumeroCancion = new MiJLabel(String.valueOf(numeroCancion));
            lblNumeroCancion.setPreferredSize(new Dimension(40,40));
            panelCancion.add(lblNumeroCancion, BorderLayout.WEST);
            numeroCancion++;
            MiJButton btnTituloCancion = new MiJButton(cancion.getNombre());
            //btnTituloCancion.setBorder(BorderFactory.createLineBorder(Color.PINK));
            panelCancion.add(btnTituloCancion, BorderLayout.CENTER);

            //Panel en el que se encuentra la duracion de la cancion y el boton de play
            MiJPanel panelDerecho = new MiJPanel(JVentana.COLOR_SECUNDARIO);
            panelDerecho.setLayout(new BorderLayout());
            panelCancion.add(panelDerecho, BorderLayout.EAST);

            //Duracion de la cancion
            long minutos = cancion.getClip().getMicrosecondLength()/60000000;
            long segundos =cancion.getClip().getMicrosecondLength()/1000000 - 60*minutos;
            MiJLabel lblDuracion = new MiJLabel(String.valueOf(String.format("%02d", minutos) + " : " + String.format("%02d", segundos)));
            lblDuracion.setPreferredSize(new Dimension(125, 40));
            lblDuracion.setHorizontalAlignment(SwingConstants.LEFT);
            panelDerecho.add(lblDuracion, BorderLayout.EAST);
            //panelDerecho.setBorder(BorderFactory.createLineBorder(Color.PINK));
            MiJButtonDosEstados btnPlay =   new MiJButtonDosEstados(new ImageIcon("PracticaFinal/iconos/play-juan-grey.png"),
                                            new ImageIcon("PracticaFinal/iconos/play-juan-white.png"),
                                            new ImageIcon("PracticaFinal/iconos/pause-juan-grey.png"),
                                            new ImageIcon("PracticaFinal/iconos/pause-juan-white.png"));
            BOTONES_PLAY.add(btnPlay);
            btnPlay.setHorizontalAlignment(SwingConstants.CENTER);
            btnPlay.setPreferredSize(new Dimension(60,40));
            btnPlay.addMouseListener(new MouseAdapter()
              { @Override
                public void mouseEntered(MouseEvent me)
                  { if (btnPlay.getEstado() == MiJButtonDosEstados.ESTADO_1)
                    btnPlay.setIcon(btnPlay.getIcon1Bright());
                    else
                    btnPlay.setIcon(btnPlay.getIcon2Bright());
                  }
                @Override
                public void mouseExited(MouseEvent me)
                  { if (btnPlay.getEstado() == MiJButtonDosEstados.ESTADO_1)
                    btnPlay.setIcon(btnPlay.getIcon1Default());
                    else
                    btnPlay.setIcon(btnPlay.getIcon2Default());
                  }
              });
            btnPlay.addActionListener(new ActionListener()
              { @Override
                public void actionPerformed(ActionEvent e)
                  { if (btnPlay.getEstado() == MiJButtonDosEstados.ESTADO_1)
                    { //jventana.BTN_PLAY.setIcon(jventana.BTN_PLAY.getIcon1Default());
                      jventana.repaint();
                      jventana.setVisible(true);
                      btnPlay.setEstado(MiJButtonDosEstados.ESTADO_2);
                      jventana.getCancionEnReproduccion().pause();
                      JPanelCanciones.this.desactivarBOTONES_PLAY();
                      btnPlay.setIcon(btnPlay.getIcon2Bright());
                      btnPlay.setEstado(MiJButtonDosEstados.ESTADO_2);
                      JPanelCanciones.BTN_PLAY_CANCION_SELECCIONADA = btnPlay;
                      jventana.BTN_PLAY.setIcon(jventana.BTN_PLAY.getIcon2Default());
                      jventana.BTN_PLAY.setEstado(MiJButtonDosEstados.ESTADO_2);
                      jventana.setCancionEnReproduccion(cancion);
                      jventana.actualizarEtiquetas();
                      cancion.play();

                    }
                    else
                    { btnPlay.setIcon(btnPlay.getIcon1Bright());
                      btnPlay.setEstado(MiJButtonDosEstados.ESTADO_1);
                      jventana.BTN_PLAY.setIcon(jventana.BTN_PLAY.getIcon1Default());
                      cancion.pause();
                    }
                  }

              });
            panelDerecho.add(btnPlay, BorderLayout.WEST);
            panelListaCanciones.add(panelCancion);
        }


      }

}
