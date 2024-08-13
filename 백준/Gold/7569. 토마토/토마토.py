# 토마토
from collections import deque

m, n, h = map(int, input().split())

graph = []

for _ in range(h):
    temp_list = []
    for _ in range(n):
        temp_list.append(list(map(int, input().split())))

    graph.append(temp_list)

t = []

# 익은 토마토의 위치
for i in range(h):
    for j in range(n):
        for k in range(m):
            if graph[i][j][k] == 1:
                t.append([i, j, k])

dx = [0, 0, -1, 1, 0, 0]
dy = [0, 0, 0, 0, -1, 1]
dz = [-1, 1, 0, 0, 0, 0]


def bfs(tomato_location):
    queue = deque()
    queue.append(tomato_location)
    while queue:
        location = queue.popleft()
        for l in range(len(location)):
            for i in range(6):
                nz = dz[i] + location[l][0]
                nx = dx[i] + location[l][1]
                ny = dy[i] + location[l][2]

                if 0 <= nz < h and 0 <= nx < n and 0 <= ny < m:
                    if graph[nz][nx][ny] == 0:
                        graph[nz][nx][ny] = graph[location[l][0]][location[l][1]][location[l][2]] + 1
                        queue.append([[nz, nx, ny]])


bfs(t)


max_num = 0

for i in range(h):
    for j in range(n):
        for k in range(m):
            if graph[i][j][k] == 0:
                print(-1)
                exit()
            else:
                max_num = max(max_num, graph[i][j][k])

print(max_num - 1)
