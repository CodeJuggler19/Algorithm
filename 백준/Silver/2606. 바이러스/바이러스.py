# 바이러스

# 컴퓨터의 수
n = int(input())

# 연결되어 있는 컴퓨터의 쌍
m = int(input())

graph = []
for i in range(m):
    graph.append(list(map(int, input().split())))

temp_1 = [i[0] for i in graph]
temp_2 = [i[1] for i in graph]

for i in range(m):
    graph.append([temp_2[i], temp_1[i]])

visited = [False] * (n + 1)


def dfs(start):
    visited[start] = True

    list = [i[1] for i in graph if i[0] == start]

    for i in list:
        if not visited[i]:
            dfs(i)


dfs(1)

result = [i for i in visited if i]

print(len(result) - 1)
