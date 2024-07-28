# 토마토
from collections import deque

M, N = map(int, input().split())

graph = []

# 익지 않은 토마토의 개수
utc = 0

for i in range(N):
    temp = list(map(int, input().split()))
    utc += len([k for k in temp if k == 0])
    graph.append(temp)

# 익은 토마토의 위치
t = []

for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
            t.append([i, j])

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(ary):
    q = deque()
    for i in range(len(t)):
        q.append(t[i])
    day = 0
    life = len(t)
    cnt = 0
    global utc

    while q:
        if life == 0:
            life = cnt
            cnt = 0
            day += 1

        n = q.popleft()

        for i in range(4):
            nx = dx[i] + n[0]
            ny = dy[i] + n[1]

            if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 0:
                graph[nx][ny] = 1
                q.append([nx, ny])
                cnt += 1
                utc -= 1
        life -= 1

    if utc == 0:
        print(day)
    else:
        print(-1)


bfs(t)
