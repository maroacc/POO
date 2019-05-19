package icai.examen.diciembre2014.domi;

public class Gestora

  { private HashSet vehiculos;
    private TreeSet envios;

    public Gestora()
      { this.rellenarEnvios();
        this.rellenarVehiculos();

      }

    public void rellenarVehiculos()
      { boolean quedanVehiculos = true;
        while (quedanVehiculos)
        {  try
            {  vehiculos.add(IOObjetos.readObject("vehiculos.obj"));

            }
          catch (EOFException eofe)
            { quedanVehiculos = false;

            }
         }

      }

    public void rellenarEnvios()
      { boolean quedanEnvios = true;
        while (quedanEnvios)
        {  try
            {  envios.add(IOObjetos.readObject("envios.obj"));

            }
          catch (EOFException eofe)
            { quedanEnvios = false;

            }
         }

      }

    public Envio buscarEnvio(String id)
      { Envio envio = new envio(id);
        Envio envioEncontrado;

        Iterator it = envios.iterator();
        while(it.hasNext())
          { if(envio.equals(it.Next()))
              envioEncontrado = it.Next();
            
          }

      }

  }
