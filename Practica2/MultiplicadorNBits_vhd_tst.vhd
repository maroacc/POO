-- entity MultiplicadorNBits is
-- generic (
-- g_data_w : integer := 32); -- No bits de los datos
-- port (
-- a, b : in std_logic_vector (g_data_w -1 downto 0);
-- p : out std_logic_vector (g_data_w -1 downto 0);
-- ov : out std_logic ); -- Desbordamiento
-- end MultiplicadorNBits ;

--Testbench para MultiplicadorNBits
--Instancia con 4 bits

library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;

entity MultiplicadorNBits_vhd_tst is
end MultiplicadorNBits_vhd_tst;

architecture MultiplicadorNBits_arch of MultiplicadorNBits is

  signal a, b  : std_logic_vector (3 downto 0);
  signal p     : std_logic_vector (3 downto 0);
  signal ov    : std_logic;

  component MultiplicadorNBits
      generic (
        g_data_w : integer := 32
      );
      port (
        b  : in  std_logic_vector (3 downto 0);
        p  : out std_logic_vector (3 downto 0);
        ov : out std_logic
      );
 end component MultiplicadorNBits;

begin --architecture

    MultiplicadorNBits_i : MultiplicadorNBits
    generic map (
        g_data_w => 4
        )
    port map (
        a  => a,
        b  => b,
        p  => p,
        ov => ov
        );

    always : PROCESS

      --Señales auxiliares para disponer de más Bits
      --Son necesarias para poder afirmar si hay desbordamiento
      signal a_aux, b_aux   : unsigned (7 downto 0);
      signal s_aux          : std_logic_vector (7 downto 0);

    begin --PROCESS

    for i in 0 to 15 loop

      a <= std_logic_vector(to_unsigned(i, 4));
      a_aux <= "0000" & a;

      for j in 0 to 15 loop

        b <= std_logic_vector(to_unsigned(i, 4));
        b_aux <= "0000" & b;

        s_aux <= std_logic_vector(a_aux * b_aux);

        assert p = s_aux(3 downto 0)
        report "Error en la multiplicación"
        severity failure;

        if s_aux(7 downto 4) /= "0000" then
          assert ov = '1'
          report "No se activa la señal de overflow"
          severity failure;
        end if;

      end loop;

      assert false
      report "Fin de la simulación"
      severity failure;

    end loop;

  end process; --always
end MultiplicadorNBits_arch;
