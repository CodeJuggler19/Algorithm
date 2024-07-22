# 문자열
a, b = input().split()

# 비교 횟수
length = len(b) - len(a) + 1


result = 100
for i in range(length):
    temp = 0
    for j in range(len(a)):
        if a[j] != b[j+i]:
            temp += 1
    if result > temp:
        result = temp

print(result)
