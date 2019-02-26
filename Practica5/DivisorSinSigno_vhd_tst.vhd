library ieee;
use ieee. std_logic_1164 .all;
use ieee. numeric_std .all;

entity DivisorSinSigno_vhd_tst is
end entity;

  signal clk   : std_logic =: '0';
  signal dvd   : std_logic_vector (7 downto 0);
  signal dvs   : std_logic_vector (3 downto 0);
  signal coc   : std_logic_vector (3 downto 0);
  signal res   : std_logic_vector (3 downto 0);
  signal ov    : std_logic;
  signal div_z : std_logic;

  constant clk_semiperiod : time := 10 ns;

  component DivisorSinSigno
  port (
    clk   : in  std_logic;
    dvd   : in  std_logic_vector (7 downto 0);
    dvs   : in  std_logic_vector (3 downto 0);
    coc   : out std_logic_vector (3 downto 0);
    res   : out std_logic_vector (3 downto 0);
    ov    : out std_logic;
    div_z : out std_logic
  );
  end component DivisorSinSigno;

architecture arch of DivisorSinSigno_vhd_tst is
 clk <= not(clk) after clk_semiperiod;

begin


  always: process()

  begin

    dvd <= (others => '0');
    dvs <= (others => '0');
    wait for 100 ns;

    for i in 0 to 255 loop
      dvd <= std_logic_vector(to_unsigned(i));
      wait for 100 ns;
      for j in 0 to 15 loop
        dvs <= std_logic_vector(to_unsigned(j));
        wait for 100 ns;

        if j = 0 then
          assert coc = "0000"
          report "El cociente no se pone a 0 al realizar div 0"
          severity failure;

          assert res = '0'
          report "rtdy"
          severity failure;

          assert ov = '0'
          report "rtdy"
          severity failure;

          assert div_z = '1'
          report "rtdy"
          severity failure;
        else
          if unsigned(dvd)/unsigned(dvd) > to_unsiged(15, 4) then
            assert coc = "0000"
            report "El cociente no se pone a 0 al realizar div 0"
            severity failure;

            assert res = '0'
            report "rtdy"
            severity failure;

            assert ov = '1'
            report "rtdy"
            severity failure;

            assert div_z = '0'
            report "rtdy"
            severity failure;


        assert
