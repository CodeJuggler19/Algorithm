# 섬의 개수
import sys

read = sys.stdin.readline
sys.setrecursionlimit(10 ** 6)

dx = [-1, 0, 1, -1, 1, -1, 0, 1]
dy = [-1, -1, -1, 0, 0, 1, 1, 1]

def dfs(x, y):
    graph[x][y] = 0
    for i in range(8):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < h and 0 <= ny < w and graph[nx][ny] == 1:
            dfs(nx, ny)


while True:
    w, h = map(int, read().split())

    if w == 0 and h == 0:
        break

    graph = []
    for i in range(h):
        graph.append(list(map(int, read().split())))

    result = 0

    for i in range(h):
        for j in range(w):
            if graph[i][j] == 1:
                dfs(i, j)
                result += 1

    print(result)
