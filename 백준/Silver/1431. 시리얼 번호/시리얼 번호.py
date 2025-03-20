# 시리얼 번호
N = int(input())

num = []
for i in range(N):
    num.append(input())


def sum_num(x):
    result = 0
    for i in range(len(x)):
        if x[i].isdigit():
            result += int(x[i])
    return result


num.sort(key=lambda x: (len(x), sum_num(x), x))

for i in range(N):
    print(num[i])
