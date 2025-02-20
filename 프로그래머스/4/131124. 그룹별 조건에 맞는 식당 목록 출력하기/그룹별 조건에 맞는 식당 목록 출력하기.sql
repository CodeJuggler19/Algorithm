select m.member_name, r.review_text
,date_format(r.review_date, '%Y-%m-%d') as REVIEW_DATE
from member_profile as m
inner join rest_review as r on m.member_id = r.member_id
where m.member_id =(select member_id
                   from rest_review
                   group by member_id
                   order by count(rest_id) desc limit 1)
order by r.review_date, r.review_text asc

# SELECT MEMBER_NAME
#      , REVIEW_TEXT
#      , DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d') AS "REVIEW_DATE"
# FROM REST_REVIEW r
# INNER JOIN MEMBER_PROFILE m
# ON r.MEMBER_ID = m.MEMBER_ID
# WHERE r.MEMBER_ID = (SELECT MEMBER_ID
#                      FROM REST_REVIEW
#                      GROUP BY MEMBER_ID
#                      ORDER BY COUNT(REVIEW_SCORE) DESC
#                      LIMIT 1)
# ORDER BY REVIEW_DATE, REVIEW_TEXT