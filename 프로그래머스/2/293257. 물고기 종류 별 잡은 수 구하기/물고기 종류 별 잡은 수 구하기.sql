select count(*) as FISH_COUNT, FISH_NAME
from FISH_INFO as info
inner join FISH_NAME_INFO as name
on name.FISH_TYPE = info.FISH_TYPE
group by name.FISH_TYPE, FISH_NAME
order by FISH_COUNT desc