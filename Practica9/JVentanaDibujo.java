//Mª José Medina Hernández 2º GITT
//Aplicación para pintar figuras por grupos de colores en una ventana gráfica
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;


public class JVentanaDibujo extends JFrame
{ Dibujo dibujo = new Dibujo();
  Lienzo lienzo = new Lienzo(this);
  private JButton btnCuadrado = new JButton("Cuadrado");
  private JButton btnCirculo  = new JButton("Circulo");

  public static void main(String args[])
  { new JVentanaDibujo();
  }

  public JVentanaDibujo()
  { this.iniciarComponentes();
    this.iniciarJFrame();
  }

  public void iniciarComponentes()
  {   this.pintar("Grupo Rojo", new Cuadrado(100, 400, 100, true, Color.RED, true));
      this.pintar("Grupo Rojo", new Cuadrado(100, 100, 50, true, Color.RED, true));
      this.pintar("Grupo Rojo", new Cuadrado(200, 100, 50, true, Color.RED, true));
      this.pintar("Grupo Verde", new Cuadrado(300, 100, 50, true, Color.GREEN, true));
  		lienzo.setSize(800,600);
      this.setLayout(new BorderLayout());
  		this.add(lienzo, BorderLayout.CENTER);

      JPanel jpanel1 = new JPanel();
      jpanel1.setLayout(new FlowLayout());
      jpanel1.add(new JLabel("x: "));
      JTextField txtX = new JTextField(6);
      jpanel1.add(txtX);
      jpanel1.add(new JLabel("y: "));
      JTextField txtY = new JTextField(6);
      jpanel1.add(txtY);
      jpanel1.add(new JLabel("lado/radio: "));
      JTextField txtLadoRadio = new JTextField(6);
      jpanel1.add(txtLadoRadio);

      txtX.addKeyListener(new KeyAdapterTextBox(txtX, txtY));
      txtY.addKeyListener(new KeyAdapterTextBox(txtY, txtLadoRadio));
      txtLadoRadio.addKeyListener(new KeyAdapterTextBox(txtLadoRadio, btnCuadrado));


      btnCuadrado.addActionListener(new ActionListener()
        { @Override
          public void actionPerformed(ActionEvent e)
          { JVentanaDibujo.this.pintar("Grupo Azul", new Cuadrado(Integer.parseInt(txtX.getText()), Integer.parseInt(txtY.getText()), Integer.parseInt(txtLadoRadio.getText()), true, Color.BLUE, true));

          }
        });

      btnCuadrado.addKeyListener(new KeyAdapter()
        { @Override
          public void keyPressed(KeyEvent e)
          {
                  if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    JVentanaDibujo.this.pintar("Grupo Azul", new Cuadrado(Integer.parseInt(txtX.getText()), Integer.parseInt(txtY.getText()), Integer.parseInt(txtLadoRadio.getText()), true, Color.BLUE, true));

          }

        });

      btnCirculo.addActionListener(new ActionListener()
        { @Override
          public void actionPerformed(ActionEvent e)
          { System.out.println("Boton Circulo pulsado");
            JVentanaDibujo.this.pintar("Grupo Azul", new Circulo(Integer.parseInt(txtX.getText()), Integer.parseInt(txtY.getText()), Integer.parseInt(txtLadoRadio.getText()), true, Color.BLUE, true));

          }
        });

      jpanel1.add(btnCuadrado);
      jpanel1.add(btnCirculo);
      this.add(jpanel1, BorderLayout.NORTH);

      JPanel jpanel2 = new JPanel();
      jpanel2.setLayout(new BorderLayout());
      jpanel2.add(new JLabel("JPaint 2018"), BorderLayout.WEST);
      jpanel2.add(new JLabel("Programaci�n Orientada a objetos (ICAI)"),  BorderLayout.CENTER);
      jpanel2.add(new JLabel("Por mariajo"),  BorderLayout.EAST);
      this.add(jpanel2, BorderLayout.SOUTH);

  }

  private void iniciarJFrame()
    {   this.setTitle("Dibujo");
    		this.pack();
    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		this.setVisible(true);

    }

  private void pintar(String grupo, Figura figura)
		{ dibujo.pintar(grupo, figura);
			lienzo.repaint();
		}
	private void ocultarGrupo(String grupo)
		{ dibujo.ocultarGrupo(grupo);
			lienzo.repaint();
		}
	private void mostrarTodasFiguras()
		{ dibujo.mostrarTodasFiguras();
			lienzo.repaint();
		}
  public Dibujo getDibujo()
    { return dibujo;
    }

  private class KeyAdapterTextBox extends KeyAdapter
  { private JTextField jtxtfield;
    private Component nextComponentFocused;

          public KeyAdapterTextBox(JTextField jtxtfield)
            { super();
              this.jtxtfield = jtxtfield;
            }

          public KeyAdapterTextBox(JTextField jtxtfield, Component nextComponentFocused)
            { super();
              this.jtxtfield = jtxtfield;
              this.nextComponentFocused = nextComponentFocused;
            }
          public void keyPressed(KeyEvent e)
          {
                  if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
                    jtxtfield.setText("");
                  else if (e.getKeyCode()==KeyEvent.VK_ENTER)
                      nextComponentFocused.requestFocus();
          }

  }

}
