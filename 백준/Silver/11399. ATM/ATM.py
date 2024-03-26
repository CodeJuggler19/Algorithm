n = int(input())

data = list(map(int, input().split()))

data.sort()

temp = 0
result =0
for i in range(n):
    temp += data[i]
    result += temp

print(result)