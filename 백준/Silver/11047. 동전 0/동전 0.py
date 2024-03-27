n, k = map(int, input().split())

count = 0
coin = []
for i in range(n):
    c = int(input())
    coin.append(c)

while k > 0:
    if (k - coin[n - 1]) >= 0:
        temp = int(k / coin[n - 1])
        k -= temp * coin[n - 1]
        count += temp
    else:
        n -= 1
print(count)
