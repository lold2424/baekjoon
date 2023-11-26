N, K = map(int, input().split())
arr = [i for i in range(1, N + 1)]

answer = []
delete = 0

while arr:
    delete = (delete + K - 1) % len(arr)
    answer.append(str(arr.pop(delete)))

print("<" + ", ".join(answer) + ">")