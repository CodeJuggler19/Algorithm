SELECT MONTH(A.START_DATE) AS MONTH, A.CAR_ID AS CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS A
WHERE DATE_FORMAT(A.START_DATE, '%Y-%m') >= '2022-08'
        AND DATE_FORMAT(A.START_DATE, '%Y-%m') <= '2022-10'
        AND A.CAR_ID IN (SELECT C.CAR_ID
                            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS C
                            WHERE DATE_FORMAT(C.START_DATE, '%Y-%m') >= '2022-08'
                            AND DATE_FORMAT(C.START_DATE, '%Y-%m') <= '2022-10'
                            GROUP BY C.CAR_ID
                            HAVING COUNT(CAR_ID) >= 5)
GROUP BY A.CAR_ID, MONTH(A.START_DATE)
HAVING RECORDS > 0
ORDER BY MONTH(A.START_DATE), A.CAR_ID DESC;