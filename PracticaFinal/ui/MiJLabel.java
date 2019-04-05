package PracticaFinal.ui;
import PracticaFinal.logica.ReproductorMusica;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MiJLabel extends JLabel
  { public static final Color COLOR_DEFECTO = Color.WHITE;
    public MiJLabel()
      { super();
        this.setFont(JVentana.FONT_REGULAR);
        this.setForeground(COLOR_DEFECTO);

      }

    public MiJLabel(Icon image)
      { super(image);
        this.setFont(JVentana.FONT_REGULAR);
        this.setForeground(COLOR_DEFECTO);

      }

    public MiJLabel(String text)
      { super(text);
        this.setFont(JVentana.FONT_REGULAR);
        this.setForeground(COLOR_DEFECTO);
        this.setHorizontalAlignment(SwingConstants.CENTER);
      }

    public MiJLabel(String text, Icon icon, int horizontalAlignment)
      { super(text, icon, horizontalAlignment);
        this.setFont(JVentana.FONT_REGULAR);
        this.setForeground(COLOR_DEFECTO);
      }

  }
