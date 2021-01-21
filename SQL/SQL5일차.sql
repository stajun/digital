/*
select 속성명1, 속성명2, ..., 속성명n from 테이블A
	join 테이블B
    on 테이블A.속성a = 테이블B.속성b;
*/
-- 속성a의 값은 속성b의 값이거나 null이어야한다.
-- 속성b의 값은 속성a의 값이거나 null이어야한다.

/*
select 보고싶은속성명 from 테이블;
select 보고싶은속성명 from 테이블 where 검색조건;
*/
-- 수강을 하고 있는 수강생들의 학번과 이름을 출력하는 쿼리문(중복 불가)
select * from attend;
select distinct at_st_num, st_name 
	from attend 
    join student 
    on at_st_num = st_num;
-- 2020123001학번 학생이 수강한 강의번호를 출력하는 쿼리문
select at_co_num from attend where at_st_num = 2020123001;

-- 2020123001학번 학생이 수강한 강의시간표를 출력하는 쿼리문
select co_timetable from attend 
	join course	on co_num = at_co_num
	where at_st_num = 2020123001;

-- 2020123001학번 학생이 2020년 2학기에 수강한 강의시간표를 출력하는 쿼리문
select co_timetable from attend 
	join course	on co_num = at_co_num
	where at_st_num = 2020123001 
    and co_year = 2020 
    and co_term = 2;

-- 2020123001학번 학생이 2020년 2학기에 수강한 과목명을 출력하는 쿼리문
select su_title from attend 
	join course	on co_num = at_co_num
    join `subject` on su_num = co_su_num
	where at_st_num = 2020123001 
    and co_year = 2020 
    and co_term = 2;

-- 교수번호가 2010160001인 교수님의 지도 학생학번을 출력하는 쿼리문
select gu_st_num from guide where gu_pr_num = 2010160001;

-- 교수번호가 2010160001인 교수님의 지도 학생이름을 출력하는 쿼리문
select st_num, st_name from guide 
		join student on gu_st_num = st_num
        where gu_pr_num = 2010160001;
        
-- 교수번호가 2010160001인 교수님의 지도 학생이름과 교수명을 출력하는 쿼리문
select pr_name as '교수명', st_num as '학생학번', st_name as '학생명' 
		from guide 
		join student on gu_st_num = st_num
        join professor on gu_pr_num = pr_num
        where gu_pr_num = 2010160001;

