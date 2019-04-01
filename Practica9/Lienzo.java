import java.awt.*;
import javax.swing.JFrame;
import java.util.Iterator;
import java.util.ArrayList;


public class Lienzo extends Canvas
{ private JVentanaDibujo jventanadibujo;

  public Lienzo (JVentanaDibujo jventanadibujo)
  { this.jventanadibujo = jventanadibujo;
  }

	public void paint(Graphics g)
	{	Dibujo dibujo = jventanadibujo.getDibujo();
    ArrayList figuras = dibujo.getFiguras();

		Iterator it = figuras.iterator();
		while (it.hasNext())
				{		Figura figura = (Figura) it.next();
						if (figura.isVisible())
							{ g.setColor(figura.getColor());
								figura.pintar(g);
							}
				}
	 }
}
