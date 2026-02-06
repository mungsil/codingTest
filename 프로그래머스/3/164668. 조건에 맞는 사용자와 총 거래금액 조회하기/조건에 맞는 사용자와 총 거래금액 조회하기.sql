-- 1. 중고 거래 상태 == 완료
-- 2. && 총 금액 >= 70
-- 
with king_of_sales as (
    select writer_id, sum(price) as TOTAL_SALES
    from used_goods_board
    where status = 'DONE'
    group by writer_id
) 
select user_id, nickname, TOTAL_SALES
from used_goods_user as u
inner join king_of_sales as king
on king.writer_id = u.user_id
where TOTAL_SALES >= 700000
order by total_sales asc