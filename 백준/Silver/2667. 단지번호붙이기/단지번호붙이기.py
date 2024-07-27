# 단지 번호 붙이기

n = int(input())

graph = []
for i in range(n):
    graph.append(list(map(int, input())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dfs(x, y):
    graph[x][y] = 0
    global count
    count += 1
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] == 1:
            dfs(nx, ny)


count = 0

result = []

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            count = 0
            dfs(i, j)
            result.append(count)

result.sort()

print(len(result))
for i in range(len(result)):
    print(result[i])
