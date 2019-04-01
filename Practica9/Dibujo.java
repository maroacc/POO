import java.awt.*;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;



public class Dibujo
{ //HashMap de grupos por colores
  private HashMap hm = new HashMap();

    void pintar(String grupo, Figura figura)
      { ArrayList figuras = new ArrayList();
        if (hm.containsKey(grupo))
          figuras = (ArrayList) hm.get(grupo);
        figuras.add(figura);
        hm.put(grupo, figuras);
      }


		public void ocultarGrupo(String grupo)
			{ ArrayList figuras = new ArrayList();
				figuras =  (ArrayList) hm.get(grupo);
		    Iterator it = figuras.iterator();
				while(it.hasNext())
				{		Figura figura = (Figura) it.next();
					  figura.setVisible(false);
				}
			}

			public void mostrarTodasFiguras()
			{ ArrayList figuras = new ArrayList();
				Iterator it = hm.values().iterator();
				while (it.hasNext())
					{ figuras =  (ArrayList) it.next();
						Iterator it2 = figuras.iterator();
						while (it2.hasNext())
						{		Figura figura = (Figura) it2.next();
								figura.setVisible(true);
						}

					}
			}

		public ArrayList getFiguras()
		{ ArrayList todasFiguras = new ArrayList();
			Iterator it = hm.values().iterator();
			while (it.hasNext())
				{ ArrayList figurasGrupo =  (ArrayList) it.next();
					Iterator it2 = figurasGrupo.iterator();
					while (it2.hasNext())
					{		todasFiguras.add(it2.next());
					}
				}
			return todasFiguras;
		}

}
