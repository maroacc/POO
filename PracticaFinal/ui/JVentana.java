package PracticaFinal.ui;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.SwingConstants;


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


public class JVentana extends JFrame
{ private MiJButton btnInicio = new MiJButton("Inicio", new ImageIcon("PracticaFinal/iconos/home-icon-silhouette.png"));
  private MiJButton btnArtistas = new MiJButton("Artistas", new ImageIcon("PracticaFinal/iconos/karaoke-microphone-icon.png"));
  private MiJButton btnAlbumes = new MiJButton("Albumes", new ImageIcon("PracticaFinal/iconos/compact-disc.png"));
  private MiJButton btnCanciones = new MiJButton("Canciones", new ImageIcon("PracticaFinal/iconos/music-player.png"));
  private MiJButton btnPlayLists = new MiJButton("PlayLists", new ImageIcon("PracticaFinal/iconos/playlist.png"));

  private JTextField txtBuscador = new JTextField("Buscar", 10);
  private MiJLabel lblCancion = new MiJLabel("Call it what you want");
  private MiJLabel lblArtista = new MiJLabel("Taylor Swift");

  private MiJButton btnShuffle = new MiJButton(new ImageIcon("PracticaFinal/iconos/shuffle-arrows-hand-drawn-symbol.png"));
  private MiJButton btnPrevious = new MiJButton(new ImageIcon("PracticaFinal/iconos/previous.png"));
  private MiJButton btnPlay = new MiJButton(new ImageIcon("PracticaFinal/iconos/play-button-1.png"));
  private MiJButton btnNext = new MiJButton(new ImageIcon("PracticaFinal/iconos/next.png"));
  private MiJButton btnRepeat = new MiJButton(new ImageIcon("PracticaFinal/iconos/repeat.png"));

  public static final Font FONT = new Font("SANS_SERIF", Font.BOLD, 80);

  public static void main(String[] args)
  { new JVentana();
  }

  public JVentana()
    { this.setBackground(Color.BLACK);
      this.iniciarComponentes();
      this.iniciarJFrame();
    }

  private void iniciarComponentes()
    { //Establece el Layout como BorderLayout
      this.setLayout(new BorderLayout());

      //Añadir los paneles de la ventana
      JPanel panelPrincipal = new JPanel();
      this.add(panelPrincipal, BorderLayout.CENTER);
      panelPrincipal.add(new MiJLabel(new ImageIcon("PracticaFinal/caratulas/Captura.jpg")));
      this.setPanelSuperior();
      this.setPanelIzquierdo();
      this.setPanelInferior();
    }

  private void setPanelSuperior()
    { JPanel panelSuperior = new JPanel();  //Contiene el botón de Incio, el buscador y el nombre de usuario
      this.add(panelSuperior, BorderLayout.NORTH);
      panelSuperior.setLayout(new BorderLayout());
      panelSuperior.add(btnInicio, BorderLayout.WEST);
      JPanel panelSuperiorCentral = new JPanel();
      panelSuperiorCentral.setLayout(new FlowLayout());
      panelSuperior.add(panelSuperiorCentral);
      panelSuperiorCentral.add(new MiJLabel(new ImageIcon("PracticaFinal/iconos/magnifying-glass.png")));
      panelSuperiorCentral.add(txtBuscador);
      panelSuperior.add(new MiJLabel("maroacc  ", new ImageIcon("PracticaFinal/iconos/man-user.png"), SwingConstants.CENTER), BorderLayout.EAST);
    }

  private void setPanelIzquierdo()
    { JPanel panelIzquierdo = new JPanel(); //Contiene las opciones del menú y la carátula del disco en reproducción
      this.add(panelIzquierdo, BorderLayout.WEST);
      panelIzquierdo.setLayout(new BorderLayout());

      // MENÚ
      // Artistas
      // Albumes
      // Canciones
      // PlayLists

      JPanel panelIzquierdoSuperior = new JPanel();
      panelIzquierdo.add(panelIzquierdoSuperior, BorderLayout.NORTH);
      panelIzquierdoSuperior.setLayout(new GridLayout(4, 1));
      panelIzquierdoSuperior.add(btnArtistas);
      panelIzquierdoSuperior.add(btnAlbumes);
      panelIzquierdoSuperior.add(btnCanciones);
      panelIzquierdoSuperior.add(btnPlayLists);

      JPanel panelIzquierdoInferior = new JPanel();
      panelIzquierdo.add(panelIzquierdoInferior, BorderLayout.SOUTH);
      //Hay que hacer un resize de la imagen
      panelIzquierdoInferior.add(new MiJLabel(new ImageIcon("PracticaFinal/iconos/standard-cover-grayscale-Taylor-Swift-reputation-644x640.jpg")));
    }

  private void setPanelInferior()
    { JPanel panelInferior = new JPanel(); //Contiene la canción en reproducción
      this.add(panelInferior, BorderLayout.SOUTH);
      panelInferior.setLayout(new BorderLayout());

      //Nombre de la cancion y del artista en reproducción
      JPanel panelInferiorIzquierdo = new JPanel();
      panelInferior.add(panelInferiorIzquierdo, BorderLayout.WEST);
      panelInferiorIzquierdo.setLayout(new BorderLayout());
      panelInferiorIzquierdo.add(lblCancion, BorderLayout.NORTH);
      panelInferiorIzquierdo.add(lblArtista, BorderLayout.SOUTH);

      //Botones para controlar la canción en reproducción
      JPanel panelInferiorCentral = new JPanel();
      panelInferior.add(panelInferiorCentral, BorderLayout.CENTER);
      panelInferiorIzquierdo.setLayout(new FlowLayout());
      btnShuffle.setBackground(Color.PINK);
      panelInferiorIzquierdo.add(btnShuffle);
      btnPrevious.setBackground(Color.PINK);
      panelInferiorIzquierdo.add(btnPrevious);
      btnPlay.setBackground(Color.PINK);
      panelInferiorIzquierdo.add(btnPlay);
      btnNext.setBackground(Color.PINK);
      panelInferiorIzquierdo.add(btnNext);
      btnRepeat.setBackground(Color.PINK);
      panelInferiorIzquierdo.add(btnRepeat);


    }

  private void iniciarJFrame()
    {   this.setTitle("Spotify");
        //Añade el logo de Spotify
        ImageIcon iconImage = new ImageIcon("PracticaFinal/iconos/spotify.png");
        this.setIconImage(iconImage.getImage());
    		this.pack();
    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		this.setVisible(true);

    }

  private class MiJButton extends JButton
    { private Font font = JVentana.this.getFont();
      public MiJButton()
        { super();
          this.setFont(JVentana.FONT);
        }
      public MiJButton(String text)
        { super(text);
          this.setFont(JVentana.FONT);
        }
      public MiJButton(String text, Icon icon)
        { super(text, icon);
          this.setFont(JVentana.FONT);
        }
      public MiJButton(Icon icon)
        { super(icon);
          this.setFont(JVentana.FONT);
        }
    }

  private class MiJLabel extends JLabel
    {  public MiJLabel()
        { super();
          this.setFont(JVentana.FONT);
        }

      public MiJLabel(Icon image)
        { super(image);
          this.setFont(JVentana.FONT);
        }

      public MiJLabel(String text)
        { super(text);
          this.setFont(JVentana.FONT);
        }

      public MiJLabel(String text, Icon icon, int horizontalAlignment)
        { super(text, icon, horizontalAlignment);
          this.setFont(JVentana.FONT);
        }

    }

}
