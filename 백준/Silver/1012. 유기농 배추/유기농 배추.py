# 유기농 배추
import sys
sys.setrecursionlimit(10**6)
T = int(input())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(T):
    M, N, K = map(int, input().split())

    graph = [[0 for col in range(M)] for row in range(N)]

    for j in range(K):
        x, y = map(int, input().split())
        graph[y][x] = 1


    def dfs(x, y):
        graph[x][y] = 0

        for k in range(4):
            nx = dx[k] + x
            ny = dy[k] + y

            if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 1:
                dfs(nx, ny)


    result = 0
    for y in range(N):
        for m in range(M):
            if graph[y][m] == 1:
                dfs(y, m)
                result += 1

    print(result)
