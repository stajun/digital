-- 대학수학을 들었던 모든 학생의 수
select sum(co_attendee) from course
	join subject on su_num = co_su_num
    where su_title = '대학수학';
-- 김영철 학생이 들었던 강의 정보를 출력(년도, 학기, 과목명 순으로 출력)
select co_year as '년도', co_term as '학기', su_title as '과목명'
	from attend 
	join (select * from student where st_name='김영철' ) as std
		on st_num = at_st_num
    join course on co_num = at_co_num
    join subject on su_num = co_su_num
    order by co_year desc, co_term desc, su_title asc;

-- 김영철 학생의 지도 교수님 이름을 출력
select st_name as'지도학생', pr_name as '지도교수' from guide 
	join (select * from student where st_name ='김영철') as std
		on gu_st_num = st_num
    join professor on pr_num = gu_pr_num;


-- 강의 중 재수강 과목이면 at_repitition에 Y로 수정하세요.
-- 수정 과정을 주석으로 설명하세요.
select at_num,co_year as '년도', co_term as '학기', su_title as '과목명'
	from attend 
	join (select * from student where st_name='강군' ) as std
		on st_num = at_st_num
    join course on co_num = at_co_num
    join subject on su_num = co_su_num
    order by co_year desc, co_term desc, su_title asc;
    
-- 2020년도에 개강한 강의 리스트
select su_title from course
	join subject on co_su_num = su_num
    where co_year = 2020 and co_term = 2;