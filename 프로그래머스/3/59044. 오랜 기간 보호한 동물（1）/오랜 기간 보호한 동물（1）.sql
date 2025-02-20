-- 코드를 입력하세요
SELECT ins.name, ins.datetime
FROM ANIMAL_INS AS ins
LEFT JOIN ANIMAL_OUTS as outs on ins.animal_id = outs.animal_id
WHERE outs.datetime is NULL
ORDER BY ins.datetime ASC
LIMIT 3;