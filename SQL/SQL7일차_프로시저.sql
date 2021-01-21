-- 프로시저 : 함수(메소드) - 쿼리의 집합
--          일련의 쿼리를 마치 하나의 함수처럼 실행하기 위한 쿼리의 집합
-- 장점 : 하나의 요청으로 SQL문을 실행
-- 		 처리 시간이 줄어든다
-- 		 보수성이 뛰어나다
-- 단점 : 재사용성이 나쁘다
--  	 업무의 사양 변경 시 프로시저의 정의를 변경할 필요가 있다
-- 프로시저 목록 확인 : show procedure status;
show procedure status;

/*
drop procedure if exists 프로시저명;
delimiter //
create procedure 프로시저명(
	in 매개변수명 자료형, -- 매개변수
    out 리턴타입명 자료형, -- 리턴타입
)
begin
	쿼리문;
end //
delimiter ;
*/
use example;
drop procedure if exists select_buy;
delimiter //
create procedure select_buy(
	in in_name varchar(20),
    in in_mode int
)
begin
	if in_mode = 0 then
		select * from buy where product_name = in_name;
	end if;
    if in_mode <> 0 then
		select customer from buy where product_name = in_name;
	end if;
end //
delimiter ;
-- call 프로시저명(매개변수,리턴타입);
call select_buy('에이 나시',1);

use test;
-- attend 테이블에서 학생 성적을 합한 결과에 따라 at_score를 결정하는
-- 프로시저를 생성하고 테스트하세요.
-- 매개변수로 at_num이 주어짐
drop procedure if exists update_attend;
delimiter //
create procedure update_attend(
	in in_at_num int
)
begin
	-- 성적의 합을 저장할 변수 선언
    declare _sum int default 0;
    declare _score varchar(2) default 0;
	-- 성적의 합을 가져옴 : select를 통해
    set _sum = 
		(select at_mid + at_final + at_homework + at_attend 
			from attend where at_num = in_at_num);
    -- 성적에 따라 
    if _sum >= 90 and _sum <= 100 then
		set _score = 'A';
	end if;
    if _sum >= 80 and _sum < 90 then
		set _score = 'B';
	end if;
    if _sum >= 70 and _sum < 80 then
		set _score = 'C';
	end if;
    if _sum >= 60 and _sum < 70 then
		set _score = 'D';
	end if;
    if _sum >= 0 and _sum < 60 then
		set _score = 'F';
	end if;
    update attend 
		set at_score = _score 
        where at_num = in_at_num;
	select * from attend where at_num = in_at_num;
end //
delimiter ;
-- call 프로시저명(매개변수,리턴타입);
call update_attend(1);

-- 학생의 학번이 주어지면 주어진 학생의 이수학점을 계산하는 프로시저
drop procedure if exists update_student;
delimiter //
create procedure update_student(
	in in_st_num int
)
begin
	-- 수강 정보에는 과목에 대한 학점이 없다.
    -- 학점에 대한 정보를 가져오기 위해서는? 
    -- =>join을 이용하여 강의와 과목 수강 세 테이블을 join해야함
    -- 조건 : 해당 학생(at_st_num)이 이수한(이수는 어떻게 확인=>at_pass) 
    -- 		 학점들의 합을 구함
    declare _sum int default 0;
    set _sum = (
		select sum(su_point) from attend 
			join course on co_num = at_co_num
			join subject on su_num = co_su_num
			where at_st_num = in_st_num and at_pass='Y');
    -- 구한 학생들의 학점을 student에 업데이트함
    update student 
		set st_point = _sum
        where st_num = in_st_num;
	-- 학생 학점이 잘 입력됐는지 확인
	-- select * from student where st_num = in_st_num;	
end //
delimiter ;
call update_student(2020456001);




