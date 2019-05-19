
package PracticaFinal.io;

import PracticaFinal.dominio.Album;
import PracticaFinal.dominio.Artista;
import PracticaFinal.dominio.Cancion;

import PracticaFinal.dominio.Representable;
import PracticaFinal.logica.GestorReproductorMusica;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;


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

public  class IOOReproductorMusica
{ public static ArrayList leerFicheroArtistas()
    { ArrayList artistas = new ArrayList();
    try
      { FileInputStream fos = new FileInputStream("PracticaFinal/recursos/artistas.obj");
        ObjectInputStream oos = new ObjectInputStream(fos);
        Object o = oos.readObject();
        if (o instanceof ArrayList)
        artistas = (ArrayList) o;
        oos.close();
        fos.close();
      }
// Cambiar por un JOptionPane de error
      catch (IOException ioe)
        { ioe.printStackTrace();
        }
      catch (ClassNotFoundException cnfe)
        { cnfe.printStackTrace();
        }
        return artistas;
  }

  public static void escribirFicheroArtistas(ArrayList artistas)
    { try
        { FileOutputStream fos = new FileOutputStream("PracticaFinal/recursos/artistas.obj");
          ObjectOutputStream oos = new ObjectOutputStream(fos);

          oos.writeObject(artistas);

        }
  // Cambiar por un JOptionPane de error
        catch (IOException e)
          { e.printStackTrace();
          }

    }

}
