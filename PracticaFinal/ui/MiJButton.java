//Clase que extiende de JButton con color de fuente por defecto
//Incluye Mouse Listeners para que se ilumine al pasar el raton por encima

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
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;


public class MiJButton extends JButton
  { public static final Color COLOR_DEFECTO = new Color(200, 200, 200);
    private Icon iconDefault;
    private Icon iconBright;

    public MiJButton()
      { super();
        this.customButtom();
      }
    public MiJButton(String text)
      { super(text);
        this.customButtom();
        this.addMouseListener(new MouseAdapter()
          { @Override
            public void mouseEntered(MouseEvent me)
              { MiJButton.this.setForeground(MiJButton.this.getForeground().brighter());


              }
            @Override
            public void mouseExited(MouseEvent me)
              { MiJButton.this.setForeground(COLOR_DEFECTO);
              }
          });
      }
   public MiJButton(Icon icon)
      { super(icon);
        this.customButtom();
      }

    public MiJButton(String text, Icon icon)
      { super(text, icon);
        this.customButtom();
        this.addMouseListener(new MouseAdapter()
          { @Override
            public void mouseEntered(MouseEvent me)
              { MiJButton.this.setForeground(MiJButton.this.getForeground().brighter());


              }
            @Override
            public void mouseExited(MouseEvent me)
              { MiJButton.this.setForeground(COLOR_DEFECTO);
              }
          });
      }

    public MiJButton(Icon iconDefault, Icon iconBright)
      { super(iconDefault);
        this.setIconDefault(iconDefault);
        this.setIconBright(iconBright);
        this.customButtom();
        this.addMouseListener(new MouseAdapter()
          { @Override
            public void mouseEntered(MouseEvent me)
              { MiJButton.this.setIcon(MiJButton.this.getIconBright());


              }
            @Override
            public void mouseExited(MouseEvent me)
              { MiJButton.this.setIcon(MiJButton.this.getIconDefault());
              }
          });
      }

    public void setIconDefault(Icon iconDefault)
      { this.iconDefault = iconDefault;

      }

    public Icon getIconDefault()
      { return iconDefault;

      }
    public void setIconBright(Icon iconBright)
      { this.iconBright = iconBright;

      }

    public Icon getIconBright()
      { return iconBright;

      }


    private void customButtom()
      { UIManager.put("Button.select", Color.RED);
        this.setHorizontalAlignment(SwingConstants.LEFT);
        this.setFont(JVentana.FONT_TITLE);
        this.setContentAreaFilled(false);
        this.setForeground(COLOR_DEFECTO);
        this.setBorder(BorderFactory.createEmptyBorder());
      }
  }
