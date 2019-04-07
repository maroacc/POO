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


public class MiJButtonDosEstados extends MiJButton
  { public static final int ESTADO_1 = 1;
    public static final int ESTADO_2 = 2;
    public MiJButtonDosEstados(Icon icon1Default, Icon icon1Bright, Icon icon2Default, Icon icon2Bright)
      { super(icon1Default);
        super.customButtom();
        this.addMouseListener(new MouseAdapter()
          { @Override
            public void mouseEntered(MouseEvent me)
              { if (estado = ESTADO_1)
                MiJButton.this.setIcon(icon1Bright);
                else
                MiJButton.this.setIcon(icon2Bright);
              }
            @Override
            public void mouseExited(MouseEvent me)
              { if (estado = ESTADO_2)
                MiJButton.this.setIcon(icon1Default);
                else
                MiJButton.this.setIcon(icon2Default);
              }
          });
        this.addActionListener(new ActionListener()
          { @Override
            public void actionPerformed(ActionEvent e)
              { if (estado = ESTADO_1)
                MiJButton.this.setIcon(icon2Bright);
                else
                MiJButton.this.setIcon(icon1Bright);

              }

          });
        }
  }
--*/
