# 정수 삼각형

n = int(input())

t = []
for i in range(n):
    t.append(list(map(int, input().split())))

dp = [[0] * i for i in range(1, n + 1)]
for i in range(n):
    if i == 0:
        dp[0][0] = t[0][0]
        continue
    if i == 1:
        dp[1][0] = dp[0][0] + t[i][0]
        dp[1][1] = dp[0][0] + t[i][1]
        continue
    lst = []
    for j in range(i + 1):
        if j == 0:
            dp[i][j] = dp[i - 1][j] + t[i][j]
        elif j == i:
            dp[i][j] = dp[i - 1][j - 1] + t[i][j]
        else:
            dp[i][j] = max(dp[i - 1][j - 1] + t[i][j], dp[i - 1][j] + t[i][j])

print(max(dp[n - 1]))
