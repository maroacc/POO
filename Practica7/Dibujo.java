import java.awt.*;
import javax.swing.JFrame;

/**
	Facilita la representación gráfica de objetos creados por el alumno mediante una ventana gráfica y un lienzo
*/
public class Dibujo extends JFrame
{
	private Lienzo lienzo;

	public Dibujo()
	{
		super("Dibujo");
		lienzo = new Lienzo();
		lienzo.setSize(800,600);
		this.add(lienzo);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
		Pinta la figura recibido por el App y actualiza el lienzo (canvas)
		@param figura figura a pintar
	*/
	public void pintar(String grupo, Figura figura)
		{ lienzo.pintar(grupo, figura);
			lienzo.repaint();
		}
	public void ocultarGrupo(String grupo)
		{ lienzo.ocultarGrupo(grupo);
			lienzo.repaint();
		}
	public void mostrarTodasFiguras()
		{ lienzo.mostrarTodasFiguras();
			lienzo.repaint();

		}

}
