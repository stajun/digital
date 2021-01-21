-- 수강테이블의 이수 여부가 N->Y로 수정되면 학생 이수학점을
-- 계산하는 트리거
drop trigger if exists update_attend;
delimiter //
create trigger update_attend after update on attend
for each row
begin
	-- 정보가 변경된 학생의 학번 => new.at_st_num
    -- 이수 여부가 N->Y로 수정되면
    if old.at_pass <> new.at_pass then
		call update_student(new.at_st_num);
    end if;
end//
delimiter ;



