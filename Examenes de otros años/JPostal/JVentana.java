package icai.examen.diciembre2014.ui;

public class JVentana extends JFrame

  { public static void main (String args[])
      { public new JVentana();

      }
    public  void JVentana()
      { VentanaDialogo vd = new VentanaDialogo();
        JButton btnVerVehiculo = new JButton("Ver Vehiculo");
        btnVerVehiculo.addActionListener(new ActionListener()
          { @Override
            public void ActionPerformed()
              { VentanaDialogo.show(JVentana.this.vehiculo.toString());

              }

          });

        btnVerPrecio.
        JButton btnVerPrecio = new JButton("Ver Precio");
        JButton btnExportar = new JButton("Ver Exportar");

        this.setLayout(new GridLayout());
        JPanel panelSuperior = new JPanel();
        this.add(panelSuperior, BorderLayout.NORTH);
        panelSuperior.setLayout(new FlowLayout());
        panelSuperior.add(new JLabel("identificador de envio: "));
        JTextField txtID = new JTextField();
        panelSuperior.add(txtID);
        txtID.addActionListener(new ActionListener()
          { @Override
            public void ActionPerformed()
              { txtID.getText();
                Envio envio = gestor.buscarEnvio();
                if (envio != null)
                  { btnVerVehiculo.setVisible(true);
                    btnVerPrecio.setVisible(true);
                    btnExportar.setVisible(true);
                  }

              }

          });

      }
  }
