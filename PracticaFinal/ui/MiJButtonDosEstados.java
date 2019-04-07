//Clase que extiende de JButton con color de fuente por defecto
//Incluye Mouse Listeners para que se ilumine al pasar el raton por encima

package PracticaFinal.ui;
import PracticaFinal.logica.GestorReproductorMusica;


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


public class MiJButtonDosEstados extends MiJButton
  { public static final int ESTADO_1 = 1;
    public static final int ESTADO_2 = 2;
    private Icon icon1Default;
    private Icon icon2Default;
    private Icon icon1Bright;
    private Icon icon2Bright;


    private int estado = ESTADO_1;

    public MiJButtonDosEstados(Icon icon1Default, Icon icon1Bright, Icon icon2Default, Icon icon2Bright)
      { super(icon1Default);
        this.setIcon1Default(icon1Default);
        this.setIcon1Bright(icon1Bright);
        this.setIcon2Default(icon2Default);
        this.setIcon2Bright(icon2Bright);

        }

    public void setEstado(int estado)
      { this.estado = estado;

      }

    public int getEstado()
      { return estado;

      }

    public void setIcon1Default(Icon icon1Default)
      { this.icon1Default = icon1Default;

      }
    public void setIcon1Bright(Icon icon1Bright)
      { this.icon1Bright = icon1Bright;

      }
    public void setIcon2Default(Icon icon2Default)
      { this.icon2Default = icon2Default;

      }

    public void setIcon2Bright(Icon icon2Bright)
      { this.icon2Bright = icon2Bright;

      }
    public Icon getIcon1Default()
      { return icon1Default;

      }
    public Icon getIcon1Bright()
      { return icon1Bright;

      }
    public Icon getIcon2Default()
      { return icon2Default;

      }

    public Icon getIcon2Bright()
      { return icon2Bright;

      }

  }
