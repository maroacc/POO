package PracticaFinal.dominio;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



public class Cancion
{ private String nombre;
  private String filePath;
  Long tiempoReproduccionActual;
  Clip clip;
  //Estado actual (play, pausa...)
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
      { System.out.println("Su puta vida");
        e.printStackTrace();

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

  public void play()
    { clip.start();
      this.setEstado("play");
    }

  public void pause()
  {
      // if (estado.equals("paused"))
      //   {
      //       System.out.println("audio is already paused");
      //       return;
      //   }
        this.tiempoReproduccionActual = this.clip.getMicrosecondPosition();
        clip.stop();
        estado = "pausa";
    }

  public void resume() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    { try
        {if (estado.equals("play")==false)
            { clip.close();
              resetAudioStream();
              clip.setMicrosecondPosition(tiempoReproduccionActual);
              this.play();
            }
        }
      catch (Exception e)
        { e.printStackTrace();

        }

    }
  public void restart() throws IOException, LineUnavailableException, UnsupportedAudioFileException
    {   try { clip.stop();
              clip.close();
              resetAudioStream();
              tiempoReproduccionActual = 0L;
              clip.setMicrosecondPosition(0);
              this.play();
            }
        catch (Exception e)
          { e.printStackTrace();

          }
    }

  public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    { try { tiempoReproduccionActual = 0L;
            clip.stop();
            clip.close();
          }
      catch (Exception e)
        { e.printStackTrace();

        }
    }


    public void jump(long tiempoSalto) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    { try { if (tiempoSalto > 0 && tiempoSalto < clip.getMicrosecondLength())
                {
                    clip.stop();
                    clip.close();
                    resetAudioStream();
                    tiempoReproduccionActual = tiempoSalto;
                    clip.setMicrosecondPosition(tiempoSalto);
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
              clip.open(audioInputStream);
              clip.loop(Clip.LOOP_CONTINUOUSLY);

            }
        catch (Exception e)
            { e.printStackTrace();

            }
    }
}
