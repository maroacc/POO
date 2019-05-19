
package PracticaFinal.ui;
import PracticaFinal.dominio.Album;
import PracticaFinal.dominio.Artista;
import PracticaFinal.dominio.Cancion;

import PracticaFinal.dominio.Representable;
import PracticaFinal.logica.GestorReproductorMusica;

import PracticaFinal.io.IOOReproductorMusica;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JComponent;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineEvent;


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


public class JVentana extends JFrame
{ public static final ImageIcon iconImage = new ImageIcon("PracticaFinal/iconos/TMariajoMahGrande.png");
  public static final Color COLOR_FONDO = Color.BLACK;
  public static final Color COLOR_SECUNDARIO = new Color(38, 38, 38);

  public static final Font FONT_REGULAR = new Font("Font.SERIF_MD", Font.BOLD, 16);
  public static final Font FONT_TITLE = new Font("Font.SERIF_MD", Font.BOLD, 20);
  public static final Font FONT_BIG_TITLE = new Font("Font.SERIF_MD", Font.BOLD, 60);
  public static final float FONT_SIZE_SELECTED_BTN = 23;

  private Cancion cancionEnReproduccion;
  private JScrollPane ventanaActual;
  private Album albumEnReproduccion = new Album("Reputation", 1975, new ImageIcon("PracticaFinal/caratulas/REPUTATION.jpg"));
  private Artista artistaEnReproduccion = new Artista("Taylor Swift", new ImageIcon("PracticaFinal/caratulas/REPUTATION.jpg"));

  private JScrollPane jsp;
  private MiJPanel panelPrincipal;


  public static MiJButton BTN_INICIO = new MiJButton("Inicio", new ImageIcon("PracticaFinal/iconos/home-icon-silhouette.png"));
  public static MiJButton BTN_ARTISTAS = new MiJButton("Artistas", new ImageIcon("PracticaFinal/iconos/karaoke-microphone-icon.png"));
  public static MiJButton BTN_ALBUMES = new MiJButton("Álbumes", new ImageIcon("PracticaFinal/iconos/compact-disc.png"));
  public static MiJButton BTN_CANCIONES = new MiJButton("Canciones", new ImageIcon("PracticaFinal/iconos/music-player.png"));
  public static MiJButton BTN_PLAYLISTS = new MiJButton("PlayLists", new ImageIcon("PracticaFinal/iconos/playlist.png"));

  private JTextField txtBuscador = new JTextField("Buscar", 10);
  private MiJLabel lblCancion = new MiJLabel();
  private MiJLabel lblArtista = new MiJLabel();

  private MiJButtonDosEstados btnShuffle = new MiJButtonDosEstados(new ImageIcon("PracticaFinal/iconos/shuffle-arrows-hand-drawn-symbol-grey.png"), new ImageIcon("PracticaFinal/iconos/shuffle-arrows-hand-drawn-symbol-white.png"), new ImageIcon("PracticaFinal/iconos/shuffle-arrows-hand-drawn-symbol-blue.png"), new ImageIcon("PracticaFinal/iconos/shuffle-arrows-hand-drawn-symbol-cyan.png"));
  private MiJButton btnPrevious = new MiJButton(new ImageIcon("PracticaFinal/iconos/previous-grey.png"), new ImageIcon("PracticaFinal/iconos/previous-white.png"));
  public static MiJButtonDosEstados BTN_PLAY = new MiJButtonDosEstados(new ImageIcon("PracticaFinal/iconos/play-juan-grey.png"), new ImageIcon("PracticaFinal/iconos/play-juan-white.png"), new ImageIcon("PracticaFinal/iconos/pause-juan-grey.png"), new ImageIcon("PracticaFinal/iconos/pause-juan-white.png"));
  private MiJButton btnNext = new MiJButton(new ImageIcon("PracticaFinal/iconos/next-grey.png"), new ImageIcon("PracticaFinal/iconos/next-white.png"));
  private MiJButtonDosEstados btnRepeat = new MiJButtonDosEstados(new ImageIcon("PracticaFinal/iconos/repeat-grey.png"), new ImageIcon("PracticaFinal/iconos/repeat-white.png"), new ImageIcon("PracticaFinal/iconos/repeat-blue.png"), new ImageIcon("PracticaFinal/iconos/repeat-cyan.png"));

  private MiJLabel lblTiempoReproduccion = new MiJLabel("0:58");
  private MiJLabel lblDuracion;
  private JSlider sliderEnReproduccion = new JSlider();


  private GestorReproductorMusica reproductorMusica = new GestorReproductorMusica(this);

  public static void main(String[] args)
  { JVentana jv = new JVentana();
    while(true)
      { //System.out.println(jv.getCancionEnReproduccion().getClip().getMicrosecondPosition());
          long minutos = jv.getCancionEnReproduccion().getClip().getMicrosecondPosition()/60000000;
          long segundos = jv.getCancionEnReproduccion().getClip().getMicrosecondPosition()/1000000 - 60*minutos;
          jv.lblTiempoReproduccion.setText(String.valueOf(String.format("%02d", minutos) + " : " + String.format("%02d", segundos)));
          jv.getSliderEnReproduccion().setValue((int)( 100*jv.getCancionEnReproduccion().getClip().getMicrosecondPosition()/jv.getCancionEnReproduccion().getClip().getMicrosecondLength()));
          jv.repaint();
          jv.esperar();
      }
  }

  public JVentana()
    { try { this.getAlbumEnReproduccion().addCancion(new Cancion("Ready For It?", "PracticaFinal/audios/TaylorSwift/01 ...Ready For It_.wav"));
            this.getAlbumEnReproduccion().addCancion(new Cancion("End Game", "PracticaFinal/audios/TaylorSwift/02 End Game.wav"));
            this.getAlbumEnReproduccion().addCancion(new Cancion("I did Something bad", "PracticaFinal/audios/TaylorSwift/03 I Did Something Bad.wav"));
            this.getAlbumEnReproduccion().addCancion(new Cancion("Don’t Blame Me", "PracticaFinal/audios/TaylorSwift/04 Don’t Blame Me.wav"));

            this.getAlbumEnReproduccion().addCancion(new Cancion("Delicate", "PracticaFinal/audios/TaylorSwift/05 Delicate.wav"));

            this.getAlbumEnReproduccion().addCancion(new Cancion("Look What You Made Me Do", "PracticaFinal/audios/TaylorSwift/06 Look What You Made Me Do.wav"));

            this.getAlbumEnReproduccion().addCancion(new Cancion("So It Goes...", "PracticaFinal/audios/TaylorSwift/07 So It Goes....wav"));

            this.getAlbumEnReproduccion().addCancion(new Cancion("Gorgeous", "PracticaFinal/audios/TaylorSwift/08 Gorgeous.wav"));

            this.getAlbumEnReproduccion().addCancion(new Cancion("Getaway Car", "PracticaFinal/audios/TaylorSwift/09 Getaway Car.wav"));

            this.getAlbumEnReproduccion().addCancion(new Cancion("King Of My Heart", "PracticaFinal/audios/TaylorSwift/10 King Of My Heart.wav"));

            this.getAlbumEnReproduccion().addCancion(new Cancion("Dancing With Our Hands Tied", "PracticaFinal/audios/TaylorSwift/11 Dancing With Our Hands Tied.wav"));

            this.getAlbumEnReproduccion().addCancion(new Cancion("Dress", "PracticaFinal/audios/TaylorSwift/12 Dress.wav"));

            this.getAlbumEnReproduccion().addCancion(new Cancion("This Is Why We Can’t Have Nice Things", "PracticaFinal/audios/TaylorSwift/13 This Is Why We Can’t Have Nice Things.wav"));

            this.getAlbumEnReproduccion().addCancion(new Cancion("Call It What You Want", "PracticaFinal/audios/TaylorSwift/14 Call It What You Want.wav"));

            this.getAlbumEnReproduccion().addCancion(new Cancion("New Year’s Day", "PracticaFinal/audios/TaylorSwift/15 New Year’s Day.wav"));


            this.setCancionEnReproduccion((Cancion) this.getAlbumEnReproduccion().getCanciones().get(0));
            lblDuracion = new MiJLabel(String.valueOf(this.getCancionEnReproduccion().getClip().getMicrosecondLength()/1000000));
            this.iniciarComponentes();
            this.actualizarEtiquetas();
            this.iniciarJFrame();
            IOOReproductorMusica.escribirFicheroArtistas(reproductorMusica.getArtistas());

          }
      catch (Exception e)
        { e.printStackTrace();
        }
    }

  public void esperar() {
    try{
      Thread.sleep(50);
    } catch (Exception e) {

    }
  }

  private void iniciarComponentes()
    { //Establece el Layout como BorderLayout
       this.setLayout(new BorderLayout(8, 4));
       reproductorMusica.addAlbum(new Album("Reputation",  2017, new ImageIcon("PracticaFinal/caratulas/HOMECOMING.jpg")));
       reproductorMusica.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));

       artistaEnReproduccion.addAlbum(albumEnReproduccion);
       artistaEnReproduccion.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       artistaEnReproduccion.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       artistaEnReproduccion.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       artistaEnReproduccion.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       artistaEnReproduccion.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       artistaEnReproduccion.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       artistaEnReproduccion.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       artistaEnReproduccion.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       artistaEnReproduccion.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       artistaEnReproduccion.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       artistaEnReproduccion.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       artistaEnReproduccion.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       artistaEnReproduccion.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       artistaEnReproduccion.addAlbum(new Album("Melodrama", 2017, new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));

       reproductorMusica.addArtista(artistaEnReproduccion);
       reproductorMusica.addArtista(new Artista("Taylor Swift", new ImageIcon("PracticaFinal/caratulas/REPUTATION.jpg")));
       reproductorMusica.addArtista(new Artista("Taylor Swift", new ImageIcon("PracticaFinal/caratulas/REPUTATION.jpg")));
       reproductorMusica.addArtista(new Artista("Taylor Swift", new ImageIcon("PracticaFinal/caratulas/REPUTATION.jpg")));
       reproductorMusica.addArtista(new Artista("Taylor Swift", new ImageIcon("PracticaFinal/caratulas/REPUTATION.jpg")));
       reproductorMusica.addArtista(new Artista("Taylor Swift", new ImageIcon("PracticaFinal/caratulas/REPUTATION.jpg")));
       reproductorMusica.addArtista(new Artista("Taylor Swift", new ImageIcon("PracticaFinal/caratulas/REPUTATION.jpg")));
       reproductorMusica.addArtista(new Artista("Taylor Swift", new ImageIcon("PracticaFinal/caratulas/REPUTATION.jpg")));
       reproductorMusica.addArtista(new Artista("Taylor Swift", new ImageIcon("PracticaFinal/caratulas/REPUTATION.jpg")));
       reproductorMusica.addArtista(new Artista("Taylor Swift", new ImageIcon("PracticaFinal/caratulas/REPUTATION.jpg")));
       reproductorMusica.addArtista(new Artista("Taylor Swift", new ImageIcon("PracticaFinal/caratulas/REPUTATION.jpg")));
       reproductorMusica.addArtista(new Artista("Taylor Swift", new ImageIcon("PracticaFinal/caratulas/REPUTATION.jpg")));


      this.iniciarPanelPrincipal("   Albumes", reproductorMusica.getAlbumes());
      this.setPanelSuperior();
      this.setPanelIzquierdo();
      this.setPanelInferior();
    }
  public void iniciarPanelPrincipal(String title, Collection collection)
    {   Pantallas.PANEL_ARTISTAS = new JScrollPaneArtistas(this, "   Artistas", reproductorMusica.getArtistas(), this.COLOR_SECUNDARIO);
        this.add(Pantallas.PANEL_ARTISTAS, BorderLayout.CENTER);
        this.setVentanaActual(Pantallas.PANEL_ARTISTAS);

        Pantallas.PANEL_CANCIONES = new JScrollPaneCanciones(this, "   Canciones", albumEnReproduccion.getCanciones(), this.COLOR_SECUNDARIO);

        Pantallas.PANEL_ALBUMES = new JScrollPaneAlbumes(this, title, collection, this.COLOR_SECUNDARIO);


    }
  public void setPanelPrincipal(JScrollPane ventanaNueva)
    { this.remove(ventanaActual);
      this.add(ventanaNueva, BorderLayout.CENTER);
      this.repaint();
      this.setVisible(true);
      this.setVentanaActual(ventanaNueva);

    }

  private void setPanelSuperior()
    { MiJPanel panelSuperior = new MiJPanel(this.COLOR_FONDO);  //Contiene el boton de Incio, el buscador y el nombre de usuario
      panelSuperior.setPreferredSize(new Dimension(3000, 50));
      this.add(panelSuperior, BorderLayout.NORTH);
      panelSuperior.setLayout(new BorderLayout());
      BTN_INICIO.addActionListener(new ActionListenerMiJButton(BTN_INICIO, BTN_PLAYLISTS, BTN_ARTISTAS, BTN_ALBUMES, BTN_CANCIONES));
      panelSuperior.add(BTN_INICIO, BorderLayout.WEST);
      MiJPanel panelSuperiorCentral = new MiJPanel(this.COLOR_FONDO);
      panelSuperior.add(panelSuperiorCentral);
      panelSuperiorCentral.add(new MiJLabel(new ImageIcon("PracticaFinal/iconos/magnifying-glass.png")));
      txtBuscador.setBorder(new LineBorder(Color.WHITE, 3, true));
      panelSuperiorCentral.add(txtBuscador);
      panelSuperior.add(new MiJLabel("maroacc  ", new ImageIcon("PracticaFinal/iconos/man-user.png"), SwingConstants.CENTER), BorderLayout.EAST);
    }

  private void setPanelIzquierdo()
    { MiJPanel panelIzquierdo = new MiJPanel(this.COLOR_FONDO); //Contiene las opciones del menuy la caratula del disco en reproduccion
      this.add(panelIzquierdo, BorderLayout.WEST);
      panelIzquierdo.setLayout(new BorderLayout());

      // MENu
      // Artistas
      // Albumes
      // Canciones
      // PlayLists

      MiJPanel panelIzquierdoSuperior = new MiJPanel(this.COLOR_FONDO);
      panelIzquierdo.add(panelIzquierdoSuperior, BorderLayout.NORTH);
      panelIzquierdoSuperior.setLayout(new GridLayout(4, 1, 4, 4));

      panelIzquierdoSuperior.add(BTN_ARTISTAS);
      BTN_ARTISTAS.addActionListener(new ActionListenerMiJButton(BTN_ARTISTAS, BTN_INICIO, BTN_ALBUMES, BTN_CANCIONES, BTN_PLAYLISTS)
          {
            @Override
            public void actionPerformed(ActionEvent e)
              {  super.actionPerformed(e);
                 JVentana.this.setPanelPrincipal(Pantallas.PANEL_ARTISTAS);
              }


          });

      panelIzquierdoSuperior.add(BTN_ALBUMES);
      BTN_ALBUMES.addActionListener(new ActionListenerMiJButton(BTN_ALBUMES, BTN_INICIO, BTN_ARTISTAS, BTN_CANCIONES, BTN_PLAYLISTS)
        { @Override
            public void actionPerformed(ActionEvent e)
              {  super.actionPerformed(e);
                 JVentana.this.setPanelPrincipal(Pantallas.PANEL_ALBUMES);
              }

        });


      panelIzquierdoSuperior.add(BTN_CANCIONES);
      BTN_CANCIONES.addActionListener(new ActionListenerMiJButton(BTN_CANCIONES, BTN_INICIO, BTN_ARTISTAS, BTN_ALBUMES, BTN_PLAYLISTS)
        { @Override
            public void actionPerformed(ActionEvent e)
              {  super.actionPerformed(e);
                 JVentana.this.setPanelPrincipal(Pantallas.PANEL_CANCIONES);
              }

        });


      panelIzquierdoSuperior.add(BTN_PLAYLISTS);
      BTN_PLAYLISTS.addActionListener(new ActionListenerMiJButton(BTN_PLAYLISTS, BTN_INICIO, BTN_ARTISTAS, BTN_ALBUMES, BTN_CANCIONES));



      MiJPanel panelIzquierdoInferior = new MiJPanel(this.COLOR_FONDO);
      panelIzquierdo.add(panelIzquierdoInferior, BorderLayout.SOUTH);
      //Hay que hacer un resize de la imagen
      panelIzquierdoInferior.add(new MiJLabel(new ImageIcon("PracticaFinal/caratulas/1989.jpg")));
    }

  private void setPanelInferior()
    { MiJPanel panelInferior = new MiJPanel(this.COLOR_SECUNDARIO); //Contiene la cancion en reproduccion
      panelInferior.setPreferredSize(new Dimension(3000, 100));
      panelInferior.setMaximumSize(new Dimension(3000, 100));

      this.add(panelInferior, BorderLayout.SOUTH);
      panelInferior.setLayout(new BorderLayout());

      //Nombre de la cancion y del artista en reproduccion
      MiJPanel panelInferiorIzquierdo = new MiJPanel(this.COLOR_SECUNDARIO);
      panelInferior.add(panelInferiorIzquierdo, BorderLayout.WEST);
      panelInferiorIzquierdo.setLayout(new BorderLayout(4,4));

      MiJPanel pnlCancion = new MiJPanel(this.COLOR_SECUNDARIO);
      panelInferiorIzquierdo.add(pnlCancion, BorderLayout.CENTER);
      pnlCancion.setLayout(new GridLayout(2,1, 4, 2));
      pnlCancion.add(lblCancion);
      lblCancion.setHorizontalAlignment(SwingConstants.CENTER);
      lblArtista.setHorizontalAlignment(SwingConstants.CENTER);
      lblArtista.setForeground(lblArtista.getForeground().darker());
      pnlCancion.add(lblArtista);
      pnlCancion.setPreferredSize(new Dimension(300, 100));

      //Botones para controlar la cancion en reproduccion
      MiJPanel panelInferiorCentral = new MiJPanel(this.COLOR_SECUNDARIO);
      panelInferior.add(panelInferiorCentral, BorderLayout.CENTER);
      panelInferiorCentral.setLayout(new BorderLayout());

      MiJPanel panelBotonesReproduccion = new MiJPanel(this.COLOR_SECUNDARIO);
      panelInferiorCentral.add(panelBotonesReproduccion, BorderLayout.CENTER);
      panelBotonesReproduccion.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 4));
      panelBotonesReproduccion.add(btnShuffle);
      btnShuffle.addMouseListener(new MouseAdapter()
        { @Override
          public void mouseEntered(MouseEvent me)
            { if (btnShuffle.getEstado() == MiJButtonDosEstados.ESTADO_1)
              btnShuffle.setIcon(btnShuffle.getIcon1Bright());
              else
              btnShuffle.setIcon(btnShuffle.getIcon2Bright());
            }
          @Override
          public void mouseExited(MouseEvent me)
            { if (btnShuffle.getEstado() == MiJButtonDosEstados.ESTADO_1)
              btnShuffle.setIcon(btnShuffle.getIcon1Default());
              else
              btnShuffle.setIcon(btnShuffle.getIcon2Default());
            }
        });
      btnShuffle.addActionListener(new ActionListener()
        { @Override
          public void actionPerformed(ActionEvent e)
            { if (btnShuffle.getEstado() == MiJButtonDosEstados.ESTADO_1)
              { btnShuffle.setIcon(btnShuffle.getIcon2Bright());
                btnShuffle.setEstado(MiJButtonDosEstados.ESTADO_2);
                btnRepeat.setIcon(btnRepeat.getIcon1Default());
                btnRepeat.setEstado(MiJButtonDosEstados.ESTADO_1);
                reproductorMusica.setModo(GestorReproductorMusica.MODO_ALEATORIO);
              }
              else
              { btnShuffle.setIcon(btnShuffle.getIcon1Bright());
                btnShuffle.setEstado(MiJButtonDosEstados.ESTADO_1);
                reproductorMusica.setModo(GestorReproductorMusica.MODO_NORMAL);
              }
            }

        });
      panelBotonesReproduccion.add(btnPrevious);
      btnPrevious.addActionListener(new ActionListener()
              { @Override
                public void actionPerformed(ActionEvent e)
                  { if (JVentana.this.getCancionEnReproduccion().getTiempoReproduccionActual() < Cancion.TIEMPO_MINIMO)
                    { reproductorMusica.reproducirCancionAnterior();
                      JVentana.this.actualizarEtiquetas();
                      JPanelCanciones.cambiarBntPlay(albumEnReproduccion.getCanciones().indexOf(JVentana.this.getCancionEnReproduccion()));
                      JPanelCanciones.BTN_PLAY_CANCION_SELECCIONADA.setIcon(BTN_PLAY.getIcon());
                      JPanelCanciones.BTN_PLAY_CANCION_SELECCIONADA.setEstado(BTN_PLAY.getEstado());

                    }
                    else
                    { try{ cancionEnReproduccion.restart();
                         }
                      catch (Exception ex)
                        { ex.printStackTrace();

                        }
                    }
                  }
              });
      panelBotonesReproduccion.add(BTN_PLAY);
      BTN_PLAY.addMouseListener(new MouseAdapter()
        { @Override
          public void mouseEntered(MouseEvent me)
            { if (BTN_PLAY.getEstado() == MiJButtonDosEstados.ESTADO_1)
              BTN_PLAY.setIcon(BTN_PLAY.getIcon1Bright());
              else
              BTN_PLAY.setIcon(BTN_PLAY.getIcon2Bright());
            }
          @Override
          public void mouseExited(MouseEvent me)
            { if (BTN_PLAY.getEstado() == MiJButtonDosEstados.ESTADO_1)
              BTN_PLAY.setIcon(BTN_PLAY.getIcon1Default());
              else
              BTN_PLAY.setIcon(BTN_PLAY.getIcon2Default());
            }
        });
      BTN_PLAY.addActionListener(new ActionListener()
        { @Override
          public void actionPerformed(ActionEvent e)
            { if (BTN_PLAY.getEstado() == MiJButtonDosEstados.ESTADO_1)
              { BTN_PLAY.setIcon(BTN_PLAY.getIcon2Bright());
                BTN_PLAY.setEstado(MiJButtonDosEstados.ESTADO_2);
                JPanelCanciones.BTN_PLAY_CANCION_SELECCIONADA.setIcon(BTN_PLAY.getIcon2Default());
                JPanelCanciones.BTN_PLAY_CANCION_SELECCIONADA.setEstado(MiJButtonDosEstados.ESTADO_2);
                lblCancion.setHorizontalAlignment(SwingConstants.CENTER);
                JVentana.this.getCancionEnReproduccion().play();

              }
              else
              { BTN_PLAY.setIcon(BTN_PLAY.getIcon1Bright());
                BTN_PLAY.setEstado(MiJButtonDosEstados.ESTADO_1);
                JPanelCanciones.BTN_PLAY_CANCION_SELECCIONADA.setIcon(BTN_PLAY.getIcon1Default());
                JPanelCanciones.BTN_PLAY_CANCION_SELECCIONADA.setEstado(MiJButtonDosEstados.ESTADO_2);
                JVentana.this.getCancionEnReproduccion().pause();
              }
            }

        });
      panelBotonesReproduccion.add(btnNext);
      btnNext.addActionListener(new ActionListener()
        { @Override
          public void actionPerformed(ActionEvent e)
            { reproductorMusica.reproducirSiguienteCancion();
              if (JVentana.this.getCancionEnReproduccion().getEstado()=="pause")
                  JVentana.this.getCancionEnReproduccion().pause();
                  JPanelCanciones.cambiarBntPlay(albumEnReproduccion.getCanciones().indexOf(JVentana.this.getCancionEnReproduccion()));
                  JPanelCanciones.BTN_PLAY_CANCION_SELECCIONADA.setIcon(BTN_PLAY.getIcon());
                  JPanelCanciones.BTN_PLAY_CANCION_SELECCIONADA.setEstado(BTN_PLAY.getEstado());
              JVentana.this.actualizarEtiquetas();


            }

        });
        panelBotonesReproduccion.add(btnRepeat);
        btnRepeat.addMouseListener(new MouseAdapter()
          { @Override
            public void mouseEntered(MouseEvent me)
              { if (btnRepeat.getEstado() == MiJButtonDosEstados.ESTADO_1)
                btnRepeat.setIcon(btnRepeat.getIcon1Bright());
                else
                btnRepeat.setIcon(btnRepeat.getIcon2Bright());
              }
            @Override
            public void mouseExited(MouseEvent me)
              { if (btnRepeat.getEstado() == MiJButtonDosEstados.ESTADO_1)
                btnRepeat.setIcon(btnRepeat.getIcon1Default());
                else
                btnRepeat.setIcon(btnRepeat.getIcon2Default());
              }
          });
        btnRepeat.addActionListener(new ActionListener()
          { @Override
            public void actionPerformed(ActionEvent e)
              { if (btnRepeat.getEstado() == MiJButtonDosEstados.ESTADO_1)
                { btnRepeat.setIcon(btnRepeat.getIcon2Bright());
                  btnRepeat.setEstado(MiJButtonDosEstados.ESTADO_2);
                  btnShuffle.setIcon(btnShuffle.getIcon1Default());
                  btnShuffle.setEstado(MiJButtonDosEstados.ESTADO_1);
                  reproductorMusica.setModo(GestorReproductorMusica.MODO_BUCLE);
                }
                else
                { btnRepeat.setIcon(btnRepeat.getIcon1Bright());
                  btnRepeat.setEstado(MiJButtonDosEstados.ESTADO_1);
                  reproductorMusica.setModo(GestorReproductorMusica.MODO_NORMAL);
                }
              }

          });

      MiJPanel panelSliderReproduccion = new MiJPanel(this.COLOR_SECUNDARIO);
      panelInferiorCentral.add(panelSliderReproduccion, BorderLayout.SOUTH);
      panelSliderReproduccion.add(lblTiempoReproduccion);
      sliderEnReproduccion.setBackground(this.COLOR_SECUNDARIO);
      sliderEnReproduccion.setPreferredSize(new Dimension(400, 50));
      sliderEnReproduccion.addChangeListener(new ChangeListener()
        { @Override
          public void stateChanged(ChangeEvent e)
            { //System.out.println(sliderEnReproduccion.getValue());
              if(BTN_PLAY.getIcon()== BTN_PLAY.getIcon1Default())
              { long tiempoSalto = sliderEnReproduccion.getValue()*cancionEnReproduccion.getClip().getMicrosecondLength()/100;
                try{  cancionEnReproduccion.jump(tiempoSalto);
                    }
                catch (Exception ex)
                    {

                    }
              }
            }

        });
      panelSliderReproduccion.add(sliderEnReproduccion, BorderLayout.SOUTH);
      panelSliderReproduccion.add(lblDuracion);


    }

  private void iniciarJFrame()
    {   this.setTitle("REPlay");
        this.getContentPane().setBackground(Color.BLACK);
        //Aade el logo de Spotify
        this.setIconImage(iconImage.getImage());
    		this.pack();
    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		this.setVisible(true);

    }
  public void setCancionEnReproduccion(Cancion cancionEnReproduccion)
    { this.cancionEnReproduccion = cancionEnReproduccion;
      this.cancionEnReproduccion.getClip().addLineListener(new LineListener()
        { @Override
          public void update(LineEvent evt)
          { if (evt.getType() == LineEvent.Type.STOP)
              {
                if (cancionEnReproduccion.getClip().getMicrosecondPosition() == cancionEnReproduccion.getClip().getMicrosecondLength())
                  if(reproductorMusica.getModo() == reproductorMusica.MODO_NORMAL)
                    {   reproductorMusica.reproducirSiguienteCancion();
                        JPanelCanciones.cambiarBntPlay(albumEnReproduccion.getCanciones().indexOf(JVentana.this.getCancionEnReproduccion()));
                        JPanelCanciones.BTN_PLAY_CANCION_SELECCIONADA.setIcon(BTN_PLAY.getIcon());
                        JPanelCanciones.BTN_PLAY_CANCION_SELECCIONADA.setEstado(BTN_PLAY.getEstado());
                    }
                  else if (reproductorMusica.getModo() == reproductorMusica.MODO_BUCLE)
                    {try
                      {cancionEnReproduccion.restart();

                      }
                     catch (Exception e)
                      { e.printStackTrace();

                      }
                    }
                  else if (reproductorMusica.getModo() == reproductorMusica.MODO_ALEATORIO)
                    reproductorMusica.reproducirCancionAleatoria();


                  JVentana.this.actualizarEtiquetas();
               }

          }
        });
      }

  public void actualizarEtiquetas()
    { lblCancion.setText(JVentana.this.getCancionEnReproduccion().getNombre());
      lblArtista.setText(JVentana.this.getArtistaEnReproduccion().getNombre());
      long minutos = JVentana.this.getCancionEnReproduccion().getClip().getMicrosecondLength()/60000000;
      long segundos = JVentana.this.getCancionEnReproduccion().getClip().getMicrosecondLength()/1000000 - 60*minutos;
      lblDuracion.setText(String.valueOf(String.format("%02d", minutos) + " : " + String.format("%02d", segundos)));
      this.repaint();

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

  public void setArtistaEnReproduccion(Artista artistaEnReproduccion)
    { this.artistaEnReproduccion = artistaEnReproduccion;

    }

  public Artista getArtistaEnReproduccion()
    { return artistaEnReproduccion;

    }
  public void setVentanaActual(JScrollPane ventanaActual)
    { this.ventanaActual = ventanaActual;

    }

  public JScrollPane getVentanaActual()
    { return ventanaActual;

    }

  public void setSliderEnReproduccion(JSlider sliderEnReproduccion)
    { this.sliderEnReproduccion = sliderEnReproduccion;

    }

  public JSlider getSliderEnReproduccion()
    { return sliderEnReproduccion;

    }

}
