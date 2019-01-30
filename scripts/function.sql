SET GLOBAL log_bin_trust_function_creators = 1;
SET lc_time_names = 'pl_PL';
CREATE FUNCTION dataString
(data date, r char(3))
RETURNS char(24)
RETURN CONCAT(YEAR(data), r, ' ', MONTHNAME(data), r, ' ', DAY(data));
-- Example
-- select imie, nazwisko, dataString(data_urodzenia, ",") AS funkcja from zawodnik;