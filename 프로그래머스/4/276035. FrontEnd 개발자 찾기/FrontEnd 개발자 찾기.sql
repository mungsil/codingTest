-- 비트연산자: 두 숫자의 대응하는 비트가 모두 1일 때만 1
select ID, EMAIL,FIRST_NAME,LAST_NAME 
from DEVELOPERS as d
where skill_code & ( 
    select sum(code) 
    from SKILLCODES
    where category = 'Front End'
)
order by ID ASC;



-- 1. 스킬 코드를 확인한다
-- 1024
-- 2. 스킬 코드를 해독한다
-- 1024 = 1+2+4+16+256+512
-- 3. 해독된 코드를 가지는 스킬이 프론트엔드인 경우 join

-- 프론트엔드 스킬을 '가지기만' 하면 된다
-- my skil < skil code
-- if. sill code = 4라면, c++은 해당안됨?