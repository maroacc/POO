import java.awt.*;
import javax.swing.JFrame;

public class Lienzo extends Canvas
{
	Figura figuras[]=new Figura[10];

	void pintar(Figura figura)
	{
		for(int i=0;i<figuras.length;i++)
			if(figuras[i]==null)
			{
				figuras[i] = figura;
				i=figuras.length;
			}
	}

	public void paint(Graphics g)
	{
		for(int i=0; i<figuras.length;i++)
		{
			if(figuras[i]!=null)
			{
				g.setColor(figuras[i].getColor());
			  figuras[i].pintar(g);

			}

		}

	}
}
