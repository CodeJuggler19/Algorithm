SELECT YEAR(SALES_DATE) AS YEAR, MONTH(SALES_DATE) AS MONTH
        , COUNT(DISTINCT O.USER_ID) AS PURCHASED_USERS
        , ROUND(
            (COUNT(DISTINCT O.USER_ID) /(SELECT COUNT(*)
                                        FROM USER_INFO
                                            WHERE YEAR(JOINED) = '2021')),1) 
                 AS PUCHASED_RATIO
FROM ONLINE_SALE AS O
WHERE O.USER_ID IN (SELECT USER_ID
                        FROM USER_INFO
                        WHERE YEAR(JOINED) = '2021')
GROUP BY YEAR(SALES_DATE), MONTH(SALES_DATE);



