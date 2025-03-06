SELECT E.DEPT_ID, D.DEPT_NAME_EN, ROUND(AVG(E.SAL),0) AS AVG_SAL
FROM HR_EMPLOYEES AS E
JOIN HR_DEPARTMENT AS D ON E.DEPT_ID = D.DEPT_ID
GROUP BY DEPT_ID
ORDER BY AVG_SAL DESC;