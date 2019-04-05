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

public class ActionListenerMiJButton extends ActionListener
{ public static final float FONT_SIZE = 20;
  public ActionListenerMiJButton(MiJButton btnSeleccionado, MiJButton btn1, MiJButton btn2, MiJButton btn3)
    { btn1.setForeground(MiJButton.COLOR_DEFECTO);
      btn1.setFont(FONT);
      btn2.setForeground(MiJButton.COLOR_DEFECTO);
      btn2.setFont(FONT);
      btn3.setForeground(MiJButton.COLOR_DEFECTO);
      btn3.setFont(FONT);
      btnSeleccionado.setForeground(btnSeleccionado.getForeground().brighter());
      btnSeleccionado.setFont(btnSeleccionado.getFont().deriveFont(FONT_SIZE);

    }

}
