# 보물
n = int(input())


data1 = list(map(int, input().split()))

data1.sort(reverse=True)

data2 = list(map(int, input().split()))

data2.sort()

result = 0
for i in range(n):
    result += (data1[i] * data2[i])

print(result)
