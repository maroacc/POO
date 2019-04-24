package PracticaFinal.dominio;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineEvent;




public class Cancion
{ public static final long TIEMPO_MINIMO = (long) 1000000;
  private String nombre;
  private String filePath;
  Long tiempoReproduccionActual;
  Clip clip;
  //Estado actual (play, pause...)
  String estado;
  AudioInputStream audioInputStream;

  public Cancion()
    { this.setNombre(null);
      this.setFilePath(null);
    }

  public Cancion(String nombre, String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    { try
      { this.setNombre(nombre);
        this.setFilePath(filePath);
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
      }

      catch (Exception e)
      { e.printStackTrace();

      }

    }

  public void setNombre(String nombre)
    { this.nombre = nombre;

    }

  public void setFilePath(String filePath)
    { this.filePath = filePath;

    }

  public void setEstado(String estado)
    { this.estado = estado;

    }
  public String getEstado()
    { return estado;

    }
  public String getNombre()
    { return nombre;

    }

  public long getTiempoReproduccionActual()
    { return this.getClip().getMicrosecondPosition();

    }

  public Clip getClip()
    { return clip;

    }

  public void play()
    { this.getClip().start();
      this.setEstado("play");
    }

  public void pause()
  {
      // if (estado.equals("paused"))
      //   {
      //       System.out.println("audio is already paused");
      //       return;
      //   }
        this.tiempoReproduccionActual = this.getClip().getMicrosecondPosition();
        this.getClip().stop();
        estado = "pause";
    }

  public void resume() //throws UnsupportedAudioFileException, IOException, LineUnavailableException
    { try
        {if (estado.equals("play")==false)
            { this.getClip().close();
              resetAudioStream();
              this.getClip().setMicrosecondPosition(tiempoReproduccionActual);
              this.play();
            }
         }
      catch (Exception e)
        { e.printStackTrace();

        }

    }
  public void restart() throws IOException, LineUnavailableException, UnsupportedAudioFileException
    {   try { this.getClip().stop();
              this.getClip().close();
              resetAudioStream();
              tiempoReproduccionActual = 0L;
              this.getClip().setMicrosecondPosition(0);
              this.play();
              if (this.getEstado() == "pause")
                this.pause();
            }
        catch (Exception e)
          { e.printStackTrace();

          }
    }

  public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    { try { tiempoReproduccionActual = 0L;
            this.getClip().stop();
            this.getClip().close();
          }
      catch (Exception e)
        { e.printStackTrace();

        }
    }


    public void jump(long tiempoSalto) throws UnsupportedAudioFileException, IOException, LineUnavailableException
      { try { if (tiempoSalto > 0 && tiempoSalto < this.getClip().getMicrosecondLength())
                  {
                      this.getClip().stop();
                      this.getClip().close();
                      resetAudioStream();
                      tiempoReproduccionActual = tiempoSalto;
                      this.getClip().setMicrosecondPosition(tiempoSalto);
                      this.play();
                  }

             }
        catch (Exception e)
          { e.printStackTrace();

          }
      }

    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException
      {   try { audioInputStream = AudioSystem.getAudioInputStream(
                new File(filePath).getAbsoluteFile());
                this.getClip().open(audioInputStream);

              }
          catch (Exception e)
              { e.printStackTrace();

              }
      }

}
