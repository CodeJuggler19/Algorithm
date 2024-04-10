n = int(input())

array = [[0 for col in range(101)] for row in range(101)]

for i in range(n):
    x, y = list(map(int, input().split()))

    for row in range(x, x+10):
        for col in range(y, y+10):
            array[row][col] = 1

result = 0
for row in range(101):
    for col in range(101):
        result += array[row][col]

print(result)

