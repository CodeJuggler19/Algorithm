# 피보나치 함수

t = int(input())

dp = [[0, 0]] * 41

dp[0] = [1, 0]
dp[1] = [0, 1]

case = []
for _ in range(t):
    case.append(int(input()))


def fibo(n):
    if n == 0 or n == 1:
        return True
    if dp[n - 1] == [0, 0]:
        fibo(n - 1)
    if dp[n - 2] == [0, 0]:
        fibo(n - 2)

    dp[n] = [dp[n - 1][0] + dp[n - 2][0], dp[n - 1][1] + dp[n - 2][1]]


for i in case:
    fibo(i)
    print(dp[i][0], dp[i][1])
