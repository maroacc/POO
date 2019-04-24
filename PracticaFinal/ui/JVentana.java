package PracticaFinal.ui;
import PracticaFinal.dominio.Album;
import PracticaFinal.dominio.Artista;
import PracticaFinal.dominio.Cancion;

import PracticaFinal.dominio.Representable;
import PracticaFinal.logica.GestorReproductorMusica;

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

  private Cancion cancionEnReproduccion;
  private Album albumEnReproduccion = new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/REPUTATION.jpg"));

  private JScrollPane jsp = new JScrollPane();
  private MiJPanel panelPrincipal;


  private MiJButton btnInicio = new MiJButton("Inicio", new ImageIcon("PracticaFinal/iconos/home-icon-silhouette.png"));
  private MiJButton btnArtistas = new MiJButton("Artistas", new ImageIcon("PracticaFinal/iconos/karaoke-microphone-icon.png"));
  private MiJButton btnAlbumes = new MiJButton("Álbumes", new ImageIcon("PracticaFinal/iconos/compact-disc.png"));
  private MiJButton btnCanciones = new MiJButton("Canciones", new ImageIcon("PracticaFinal/iconos/music-player.png"));
  private MiJButton btnPlayLists = new MiJButton("PlayLists", new ImageIcon("PracticaFinal/iconos/playlist.png"));

  private JTextField txtBuscador = new JTextField("Buscar", 10);
  private MiJLabel lblCancion = new MiJLabel();
  private MiJLabel lblArtista = new MiJLabel("Taylor Swift");

  private MiJButtonDosEstados btnShuffle = new MiJButtonDosEstados(new ImageIcon("PracticaFinal/iconos/shuffle-arrows-hand-drawn-symbol-grey.png"), new ImageIcon("PracticaFinal/iconos/shuffle-arrows-hand-drawn-symbol-white.png"), new ImageIcon("PracticaFinal/iconos/shuffle-arrows-hand-drawn-symbol-blue.png"), new ImageIcon("PracticaFinal/iconos/shuffle-arrows-hand-drawn-symbol-cyan.png"));
  private MiJButton btnPrevious = new MiJButton(new ImageIcon("PracticaFinal/iconos/previous-grey.png"), new ImageIcon("PracticaFinal/iconos/previous-white.png"));
  private MiJButtonDosEstados btnPlay = new MiJButtonDosEstados(new ImageIcon("PracticaFinal/iconos/play-juan-grey.png"), new ImageIcon("PracticaFinal/iconos/play-juan-white.png"), new ImageIcon("PracticaFinal/iconos/pause-juan-grey.png"), new ImageIcon("PracticaFinal/iconos/pause-juan-white.png"));
  private MiJButton btnNext = new MiJButton(new ImageIcon("PracticaFinal/iconos/next-grey.png"), new ImageIcon("PracticaFinal/iconos/next-white.png"));
  private MiJButtonDosEstados btnRepeat = new MiJButtonDosEstados(new ImageIcon("PracticaFinal/iconos/repeat-grey.png"), new ImageIcon("PracticaFinal/iconos/repeat-white.png"), new ImageIcon("PracticaFinal/iconos/repeat-blue.png"), new ImageIcon("PracticaFinal/iconos/repeat-cyan.png"));

  private MiJLabel lblTiempoReproduccion = new MiJLabel("0:58");
  private MiJLabel lblDuracion;
  private JSlider sliderEnReproduccion = new JSlider();

  public static final Font FONT_REGULAR = new Font("SANS_SERIF", Font.BOLD, 16);
  public static final Font FONT_TITLE = new Font("SANS_SERIF", Font.BOLD, 20);
  public static final Font FONT_BIG_TITLE = new Font("SANS_SERIF", Font.BOLD, 60);


  private GestorReproductorMusica reproductorMusica = new GestorReproductorMusica(this);

  public static void main(String[] args)
  { new JVentana();
  }

  public JVentana()
    { try { this.getAlbumEnReproduccion().addCancion(new Cancion("Two Bros", "PracticaFinal/audios/two_bros.wav"));
            this.getAlbumEnReproduccion().addCancion(new Cancion("Ready?", "PracticaFinal/audios/TaylorSwift/01 ...Ready For It_.wav"));
            this.getAlbumEnReproduccion().addCancion(new Cancion("I did Something bad", "PracticaFinal/audios/TaylorSwift/03 I Did Something Bad.wav"));
            this.setCancionEnReproduccion((Cancion) this.getAlbumEnReproduccion().getCanciones().get(0));
            lblDuracion = new MiJLabel(String.valueOf(this.getCancionEnReproduccion().getClip().getMicrosecondLength()/1000000));
            this.iniciarComponentes();
            this.iniciarJFrame();
          }
      catch (Exception e)
        { e.printStackTrace();
        }
    }

  private void iniciarComponentes()
    { //Establece el Layout como BorderLayout
      this.setLayout(new BorderLayout(8, 4));
       reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/REPUTATION.jpg")));
       reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));
       reproductorMusica.addAlbum(new Album("Reputation", new ImageIcon("PracticaFinal/caratulas/MELODRAMA.jpg")));

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
       reproductorMusica.addArtista(new Artista("Taylor Swift", new ImageIcon("PracticaFinal/caratulas/REPUTATION.jpg")));

      this.iniciarPanelPrincipal("   Albumes", reproductorMusica.getAlbumes());
      this.setPanelSuperior();
      this.setPanelIzquierdo();
      this.setPanelInferior();
    }
  public void iniciarPanelPrincipal(String title, Collection collection)
    {   jsp = new JScrollPane(new JPanelBiblioteca(title, collection, this.COLOR_SECUNDARIO));
        jsp.setBorder(BorderFactory.createEmptyBorder());
        this.add(jsp, BorderLayout.CENTER);
    }
  public void setPanelPrincipal(String title, Collection collection)
    { jsp.setVisible(false);
      JScrollPane jsp2 = new JScrollPane(new JPanelBiblioteca(title, collection, this.COLOR_SECUNDARIO));
      jsp2.setBorder(BorderFactory.createEmptyBorder());
      this.add(jsp2, BorderLayout.CENTER);

    }

  private void setPanelSuperior()
    { MiJPanel panelSuperior = new MiJPanel(this.COLOR_FONDO);  //Contiene el botï¿½n de Incio, el buscador y el nombre de usuario
      panelSuperior.setPreferredSize(new Dimension(3000, 50));
      this.add(panelSuperior, BorderLayout.NORTH);
      panelSuperior.setLayout(new BorderLayout());
      btnInicio.addActionListener(new ActionListenerMiJButton(btnInicio, btnPlayLists, btnArtistas, btnAlbumes, btnCanciones));
      panelSuperior.add(btnInicio, BorderLayout.WEST);
      MiJPanel panelSuperiorCentral = new MiJPanel(this.COLOR_FONDO);
      panelSuperior.add(panelSuperiorCentral);
      panelSuperiorCentral.add(new MiJLabel(new ImageIcon("PracticaFinal/iconos/magnifying-glass.png")));
      txtBuscador.setBorder(new LineBorder(Color.WHITE, 3, true));
      panelSuperiorCentral.add(txtBuscador);
      panelSuperior.add(new MiJLabel("maroacc  ", new ImageIcon("PracticaFinal/iconos/man-user.png"), SwingConstants.CENTER), BorderLayout.EAST);
    }

  private void setPanelIzquierdo()
    { MiJPanel panelIzquierdo = new MiJPanel(this.COLOR_FONDO); //Contiene las opciones del menï¿½ y la carï¿½tula del disco en reproducciï¿½n
      this.add(panelIzquierdo, BorderLayout.WEST);
      panelIzquierdo.setLayout(new BorderLayout());

      // MENï¿½
      // Artistas
      // Albumes
      // Canciones
      // PlayLists

      MiJPanel panelIzquierdoSuperior = new MiJPanel(this.COLOR_FONDO);
      panelIzquierdo.add(panelIzquierdoSuperior, BorderLayout.NORTH);
      panelIzquierdoSuperior.setLayout(new GridLayout(4, 1, 4, 4));

      panelIzquierdoSuperior.add(btnArtistas);
      btnArtistas.addActionListener(new ActionListenerMiJButton(btnArtistas, btnInicio, btnAlbumes, btnCanciones, btnPlayLists)
          {
            @Override
            public void actionPerformed(ActionEvent e)
              {  super.actionPerformed(e);
                 JVentana.this.setPanelPrincipal("   Artistas", reproductorMusica.getArtistas());
                 //JVentana.this.repaint();
              }


          });

      panelIzquierdoSuperior.add(btnAlbumes);
      btnAlbumes.addActionListener(new ActionListenerMiJButton(btnAlbumes, btnInicio, btnArtistas, btnCanciones, btnPlayLists));


      panelIzquierdoSuperior.add(btnCanciones);
      btnCanciones.addActionListener(new ActionListenerMiJButton(btnCanciones, btnInicio, btnArtistas, btnAlbumes, btnPlayLists));


      panelIzquierdoSuperior.add(btnPlayLists);
      btnPlayLists.addActionListener(new ActionListenerMiJButton(btnPlayLists, btnInicio, btnArtistas, btnAlbumes, btnCanciones));



      MiJPanel panelIzquierdoInferior = new MiJPanel(this.COLOR_FONDO);
      panelIzquierdo.add(panelIzquierdoInferior, BorderLayout.SOUTH);
      //Hay que hacer un resize de la imagen
      panelIzquierdoInferior.add(new MiJLabel(new ImageIcon("PracticaFinal/caratulas/1989.jpg")));
    }

  private void setPanelInferior()
    { MiJPanel panelInferior = new MiJPanel(this.COLOR_SECUNDARIO); //Contiene la canciï¿½n en reproducciï¿½n
      panelInferior.setPreferredSize(new Dimension(3000, 100));
      panelInferior.setMaximumSize(new Dimension(3000, 100));

      this.add(panelInferior, BorderLayout.SOUTH);
      panelInferior.setLayout(new BorderLayout());

      //Nombre de la cancion y del artista en reproducciï¿½n
      MiJPanel panelInferiorIzquierdo = new MiJPanel(this.COLOR_SECUNDARIO);
      panelInferior.add(panelInferiorIzquierdo, BorderLayout.WEST);
      panelInferiorIzquierdo.setLayout(new BorderLayout(4,4));

      MiJPanel pnlCancion = new MiJPanel(this.COLOR_SECUNDARIO);
      panelInferiorIzquierdo.add(pnlCancion, BorderLayout.CENTER);
      pnlCancion.setLayout(new GridLayout(2,1, 4, 2));
      pnlCancion.add(lblCancion);
      lblArtista.setForeground(lblArtista.getForeground().darker());
      pnlCancion.add(lblArtista);
      pnlCancion.setPreferredSize(new Dimension(300, 100));

      //Botones para controlar la canciï¿½n en reproducciï¿½n
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
      panelBotonesReproduccion.add(btnPlay);
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
              { btnPlay.setIcon(btnPlay.getIcon2Bright());
                btnPlay.setEstado(MiJButtonDosEstados.ESTADO_2);
                lblCancion.setHorizontalAlignment(SwingConstants.CENTER);
                JVentana.this.getCancionEnReproduccion().play();
              }
              else
              { btnPlay.setIcon(btnPlay.getIcon1Bright());
                btnPlay.setEstado(MiJButtonDosEstados.ESTADO_1);
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
      panelSliderReproduccion.add(sliderEnReproduccion, BorderLayout.SOUTH);
      panelSliderReproduccion.add(lblDuracion);


    }

  private void iniciarJFrame()
    {   this.setTitle("REPlay");
        this.getContentPane().setBackground(Color.BLACK);
        //Aï¿½ade el logo de Spotify
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
                    reproductorMusica.reproducirSiguienteCancion();
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


}
