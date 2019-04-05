package PracticaFinal.ui;
import PracticaFinal.logica.ReproductorMusica;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        this.setForeground(Color.PINK);
      }

  }
