# 바닥 장식
n, m = map(int, input().split())

graph = []

for i in range(n):
    graph.append(list(input()))


def dfs(x, y, before):
    if x < 0 or y < 0 or x >= n or y >= m:
        return False
    if graph[x][y] == '#':
        return False
    # 처음 시작
    if graph[x][y] == '-' and before == 'X':
        graph[x][y] = '#'
        dfs(x, y+1, '-')
        dfs(x, y-1, '-')
        return True
    elif graph[x][y] == '|' and before == 'X':
        graph[x][y] = '#'
        dfs(x+1, y, '|')
        dfs(x-1, y, '|')
        return True
    if graph[x][y] == '-' and before == '-':
        graph[x][y] = '#'
        dfs(x, y+1, '-')
        dfs(x, y-1, '-')
        return True
    elif graph[x][y] == '|' and before == '|':
        graph[x][y] = '#'
        dfs(x+1, y, '|')
        dfs(x-1, y, '|')
        return True
    return False


result = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j, 'X'):
            result += 1

print(result)
