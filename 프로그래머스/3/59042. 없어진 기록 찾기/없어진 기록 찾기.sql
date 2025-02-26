# select outs.animal_id, outs.name
# from animal_outs as outs
# left join animal_ins as ins on ins.animal_id = outs.animal_id
# where ins.animal_id is null



SELECT OUTS.ANIMAL_ID, OUTS.NAME
FROM ANIMAL_OUTS AS OUTS
LEFT JOIN ANIMAL_INS AS INS ON OUTS.ANIMAL_ID = INS.ANIMAL_ID
WHERE INS.ANIMAL_ID IS NULL;

























