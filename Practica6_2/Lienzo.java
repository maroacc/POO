import java.awt.*;
import javax.swing.JFrame;

public class Lienzo extends Canvas
{
	ArrayList figuras = new ArrayList();

	void pintar(Figura figura)
		{figuras.add(figura)
		}
	public void paint(Graphics g)
	{
		for(int i=0; i<figuras.size();i++)
		{		Figura figura = figuras.get(i);
				g.setColor(figura.getColor());
			  figura.pintar(g);

		}

	}
}
