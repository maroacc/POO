package PracticaFinal.ui;
import PracticaFinal.logica.ReproductorMusica;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.UIManager;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MiJButton extends JButton
  { public static final Color COLOR_DEFECTO = new Color(200, 200, 200);
    public MiJButton()
      { super();
      }
    public MiJButton(String text, Color color)
      { super(text);
        this.customButtom(color);

      }
    public MiJButton(String text, Icon icon, Color color)
      { super(text, icon);
        this.customButtom(color);
      }
    public MiJButton(Icon icon, Color color)
      { super(icon);
        this.customButtom(color);

      }

    private void customButtom(Color color)
      { UIManager.put("Button.select", Color.RED);
        this.setHorizontalAlignment(SwingConstants.LEFT);
        this.setFont(JVentana.FONT_TITLE);
        //this.setBackground(color);
        this.setContentAreaFilled(false);
        this.setForeground(COLOR_DEFECTO);
        this.setBorder(BorderFactory.createEmptyBorder());
      }
  }
