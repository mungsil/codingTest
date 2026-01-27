WITH USER_2021 AS (
    SELECT count(user_id) as TOTAL_NUM
    FROM USER_INFO
    WHERE YEAR(JOINED) = 2021
) 
select 
    year(sales_date) as year,
    month(sales_date) as month,
    count(distinct S.user_id) AS PURCHASED_USERS,
    ROUND(count(distinct S.user_id) / (
        SELECT TOTAL_NUM FROM USER_2021
    ), 1) as PUCHASED_RATIO
from online_sale AS S
INNER JOIN USER_INFO AS U
ON U.USER_ID = S.USER_ID
WHERE YEAR(JOINED) = 2021
group by year, month
order by year, month ASC
;