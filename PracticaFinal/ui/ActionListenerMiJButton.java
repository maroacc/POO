//Clase que extiende de ActionListener
//Cuando un botón es pulsado, aumenta su tamaño y se pone más brillante

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
import javax.swing.JSlider;
import javax.swing.JComponent;
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

public class ActionListenerMiJButton implements ActionListener
{ public static final float FONT_SIZE = 23;
  private MiJButton btnSeleccionado;
  private MiJButton btn1;
  private MiJButton btn2;
  private MiJButton btn3;
  private MiJButton btn4;


  public ActionListenerMiJButton(MiJButton btnSeleccionado, MiJButton btn1, MiJButton btn2, MiJButton btn3, MiJButton btn4)
    { this.btnSeleccionado = btnSeleccionado;
      this.btn1 = btn1;
      this.btn2 = btn2;
      this.btn3 = btn3;
      this.btn4 = btn4;

    }

  @Override
  public void actionPerformed(ActionEvent e)
    { btn1.setForeground(MiJButton.COLOR_DEFECTO);
      btn1.setFont(JVentana.FONT_TITLE);
      btn2.setForeground(MiJButton.COLOR_DEFECTO);
      btn2.setFont(JVentana.FONT_TITLE);
      btn3.setForeground(MiJButton.COLOR_DEFECTO);
      btn3.setFont(JVentana.FONT_TITLE);
      btn4.setForeground(MiJButton.COLOR_DEFECTO);
      btn4.setFont(JVentana.FONT_TITLE);
      btnSeleccionado.setForeground(btnSeleccionado.getForeground().brighter());
      btnSeleccionado.setFont(btnSeleccionado.getFont().deriveFont(FONT_SIZE));

    }

}
