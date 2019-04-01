//Mª José Medina Hernández 2º GITT
//Aplicación para pintar figuras por grupos de colores en una ventana gráfica

import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;


public class JVentanaDibujo extends JFrame
{ Dibujo dibujo = new Dibujo();
  Lienzo lienzo = new Lienzo(this);
  public static void main(String args[])
  { new JVentanaDibujo();
  }

  public JVentanaDibujo()
  { super("Dibujo");
    this.pintar("Grupo Rojo", new Cuadrado(100, 400, 100, true, Color.RED, true));
    this.pintar("Grupo Rojo", new Cuadrado(100, 100, 50, true, Color.RED, true));
    this.pintar("Grupo Rojo", new Cuadrado(200, 100, 50, true, Color.RED, true));
    this.pintar("Grupo Verde", new Cuadrado(300, 100, 50, true, Color.GREEN, true));
    this.pintar("Grupo Azul", new Cuadrado(200, 400, 50, true, Color.BLUE, true));

		lienzo.setSize(800,600);
    this.setLayout(new BorderLayout());
		this.add(lienzo, BorderLayout.CENTER);

    JPanel jpanel1 = new JPanel();
    jpanel1.setLayout(new FlowLayout());
    jpanel1.add(new JLabel("x: "));
    jpanel1.add(new JTextField(6));
    jpanel1.add(new JLabel("y: "));
    jpanel1.add(new JTextField(6));
    jpanel1.add(new JLabel("lado/radio: "));
    jpanel1.add(new JTextField(6));
    jpanel1.add(new JButton("Circulo"));
    jpanel1.add(new JButton("Cuadrado"));
    this.add(jpanel1, BorderLayout.NORTH);

    JPanel jpanel2 = new JPanel();
    jpanel2.setLayout(new BorderLayout());
    jpanel2.add(new JLabel("JPaint 2018"), BorderLayout.WEST);
    jpanel2.add(new JLabel("Programaci�n Orientada a objetos (ICAI)"),  BorderLayout.CENTER);
    jpanel2.add(new JLabel("Por mariajo"),  BorderLayout.EAST);
    this.add(jpanel2, BorderLayout.SOUTH);

		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

  }

  public void pintar(String grupo, Figura figura)
		{ dibujo.pintar(grupo, figura);
			lienzo.repaint();
		}
	public void ocultarGrupo(String grupo)
		{ dibujo.ocultarGrupo(grupo);
			lienzo.repaint();
		}
	public void mostrarTodasFiguras()
		{ dibujo.mostrarTodasFiguras();
			lienzo.repaint();
		}
  public Dibujo getDibujo()
    { return dibujo;
    }

}
