package PracticaFinal.ui;
import PracticaFinal.logica.ReproductorMusica;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
