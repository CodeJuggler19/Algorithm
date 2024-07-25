# DFS와 BFS
from collections import deque

n, m, v = map(int, input().split())

graph = []
for i in range(m):
    graph.append(list(map(int, input().split())))

visited_dfs = [False] * (n + 1)
visited_bfs = [False] * (n + 1)

list_1 = [i[0] for i in graph]
list_2 = [i[1] for i in graph]

for i in range(m):
    graph.append([list_2[i], list_1[i]])


def dfs(v):
    visited_dfs[v] = True
    print(v, end=' ')

    list = [i[1] for i in graph if i[0] == v]
    list.sort()

    for i in list:
        if not visited_dfs[i]:
            dfs(i)


def bfs(v):
    queue = deque([v])

    visited_bfs[v] = True

    while queue:
        v = queue.popleft()

        print(v, end=' ')

        list = [i[1] for i in graph if i[0] == v]
        list.sort()

        for i in list:
            if not visited_bfs[i]:
                queue.append(i)
                visited_bfs[i] = True

dfs(v)
print()
bfs(v)