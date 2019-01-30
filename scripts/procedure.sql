drop procedure if exists procedura;
DELIMITER  //
create procedure procedura(
	IN we1 integer,
    OUT wy1 integer
)
begin
	declare temp int;
    select count(*) into temp from rozgrywka where druzyna_id_druzyny1 = we1 and punkty_druzyna1 > punkty_druzyna2;
    SET wy1 = temp;
    select count(*) into temp from rozgrywka where druzyna_id_druzyny2 = we1 and punkty_druzyna1 < punkty_druzyna2;
    SET wy1 = wy1 + temp;
end //
DELIMITER ;
-- example
-- call procedura(1, @out_value);
-- select @out_value;