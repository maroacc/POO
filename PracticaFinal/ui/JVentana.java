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
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JComponent;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;
import javax.swing.UIDefaults;
import javax.swing.UIManager;


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
{ public static final ImageIcon iconImage = new ImageIcon("PracticaFinal/iconos/spotify.png");
  public static final Color COLOR_FONDO = Color.BLACK;
  public static final Color COLOR_SECUNDARIO = new Color(38, 38, 38);


  private MiJButton btnInicio = new MiJButton("Inicio", new ImageIcon("PracticaFinal/iconos/home-icon-silhouette.png"), COLOR_FONDO);
  private MiJButton btnArtistas = new MiJButton("Artistas", new ImageIcon("PracticaFinal/iconos/karaoke-microphone-icon.png"), COLOR_FONDO);
  private MiJButton btnAlbumes = new MiJButton("�lbumes", new ImageIcon("PracticaFinal/iconos/compact-disc.png"), COLOR_FONDO);
  private MiJButton btnCanciones = new MiJButton("Canciones", new ImageIcon("PracticaFinal/iconos/music-player.png"), COLOR_FONDO);
  private MiJButton btnPlayLists = new MiJButton("PlayLists", new ImageIcon("PracticaFinal/iconos/playlist.png"), COLOR_FONDO);

  private JTextField txtBuscador = new JTextField("Buscar", 10);
  private MiJLabel lblCancion = new MiJLabel("Call it what you want");
  private MiJLabel lblArtista = new MiJLabel("Taylor Swift");

  private MiJButton btnShuffle = new MiJButton(new ImageIcon("PracticaFinal/iconos/shuffle-arrows-hand-drawn-symbol.png"), COLOR_SECUNDARIO);
  private MiJButton btnPrevious = new MiJButton(new ImageIcon("PracticaFinal/iconos/previous.png"), COLOR_SECUNDARIO);
  private MiJButton btnPlay = new MiJButton(new ImageIcon("PracticaFinal/iconos/play-button-1.png"), COLOR_SECUNDARIO);
  private MiJButton btnNext = new MiJButton(new ImageIcon("PracticaFinal/iconos/next.png"), COLOR_SECUNDARIO);
  private MiJButton btnRepeat = new MiJButton(new ImageIcon("PracticaFinal/iconos/repeat.png"), COLOR_SECUNDARIO);

  private MiJLabel lblTiempoReproduccion = new MiJLabel("0:58");
  private MiJLabel lblDuracion = new MiJLabel("3:58");
  private JSlider sliderEnReproduccion = new JSlider();

  public static final Font FONT_REGULAR = new Font("SANS_SERIF", Font.BOLD, 16);
  public static final Font FONT_TITLE = new Font("SANS_SERIF", Font.BOLD, 25);
  public static final Font FONT_BIG_TITLE = new Font("SANS_SERIF", Font.BOLD, 60);


  private ReproductorMusica reproductorMusica = new ReproductorMusica();

  public static void main(String[] args)
  { new JVentana();
  }

  public JVentana()
    { this.iniciarComponentes();
      this.iniciarJFrame();
    }

  private void iniciarComponentes()
    { //Establece el Layout como BorderLayout
      this.setLayout(new BorderLayout(8, 8));

      //Añadir los paneles de la ventana
      this.setPanelPrincipal();
      this.setPanelSuperior();
      this.setPanelIzquierdo();
      this.setPanelInferior();
    }

  private void setPanelPrincipal()
    { MiJPanel panelPrincipal = new JPanelAlbumes(reproductorMusica, this.COLOR_SECUNDARIO);
      JScrollPane jsp = new JScrollPane(panelPrincipal);
      jsp.setBorder(BorderFactory.createEmptyBorder());
      JScrollBar jsb = jsp.getHorizontalScrollBar();
      this.add(jsp, BorderLayout.CENTER);
    }

  private void setPanelSuperior()
    { MiJPanel panelSuperior = new MiJPanel(this.COLOR_FONDO);  //Contiene el botón de Incio, el buscador y el nombre de usuario
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
    { MiJPanel panelIzquierdo = new MiJPanel(this.COLOR_FONDO); //Contiene las opciones del menú y la carátula del disco en reproducción
      this.add(panelIzquierdo, BorderLayout.WEST);
      panelIzquierdo.setLayout(new BorderLayout());

      // MENÚ
      // Artistas
      // Albumes
      // Canciones
      // PlayLists

      MiJPanel panelIzquierdoSuperior = new MiJPanel(this.COLOR_FONDO);
      panelIzquierdo.add(panelIzquierdoSuperior, BorderLayout.NORTH);
      panelIzquierdoSuperior.setLayout(new GridLayout(4, 1, 4, 4));
      
      panelIzquierdoSuperior.add(btnArtistas);
      btnArtistas.addActionListener(new ActionListenerMiJButton(btnArtistas, btnInicio, btnAlbumes, btnCanciones, btnPlayLists));

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
    { MiJPanel panelInferior = new MiJPanel(this.COLOR_SECUNDARIO); //Contiene la canción en reproducción
      panelInferior.setPreferredSize(new Dimension(3000, 100));
      panelInferior.setMaximumSize(new Dimension(3000, 100));

      this.add(panelInferior, BorderLayout.SOUTH);
      panelInferior.setLayout(new BorderLayout());

      //Nombre de la cancion y del artista en reproducción
      MiJPanel panelInferiorIzquierdo = new MiJPanel(this.COLOR_SECUNDARIO);
      panelInferior.add(panelInferiorIzquierdo, BorderLayout.WEST);
      panelInferiorIzquierdo.setLayout(new BorderLayout(4,4));
      panelInferiorIzquierdo.add(lblCancion, BorderLayout.CENTER);
      lblArtista.setForeground(lblArtista.getForeground().darker());
      panelInferiorIzquierdo.add(lblArtista, BorderLayout.SOUTH);

      //Botones para controlar la canción en reproducción
      MiJPanel panelInferiorCentral = new MiJPanel(this.COLOR_SECUNDARIO);
      panelInferior.add(panelInferiorCentral, BorderLayout.CENTER);
      panelInferiorCentral.setLayout(new BorderLayout());

      MiJPanel panelBotonesReproduccion = new MiJPanel(this.COLOR_SECUNDARIO);
      panelInferiorCentral.add(panelBotonesReproduccion, BorderLayout.CENTER);
      panelBotonesReproduccion.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 4));
      panelBotonesReproduccion.add(btnShuffle);
      panelBotonesReproduccion.add(btnPrevious);
      panelBotonesReproduccion.add(btnPlay);
      panelBotonesReproduccion.add(btnNext);
      panelBotonesReproduccion.add(btnRepeat);

      MiJPanel panelSliderReproduccion = new MiJPanel(this.COLOR_SECUNDARIO);
      panelInferiorCentral.add(panelSliderReproduccion, BorderLayout.SOUTH);
      panelSliderReproduccion.add(lblTiempoReproduccion);
      sliderEnReproduccion.setBackground(this.COLOR_SECUNDARIO);
      sliderEnReproduccion.setPreferredSize(new Dimension(400, 50));
      panelSliderReproduccion.add(sliderEnReproduccion, BorderLayout.SOUTH);
      panelSliderReproduccion.add(lblDuracion);


    }

  private void iniciarJFrame()
    {   this.setTitle("Spotify");
        this.getContentPane().setBackground(Color.BLACK);
        //Añade el logo de Spotify
        this.setIconImage(iconImage.getImage());
    		this.pack();
    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		this.setVisible(true);

    }





}
