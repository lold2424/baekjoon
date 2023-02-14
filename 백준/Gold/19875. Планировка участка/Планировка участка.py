n, x = map(int, input().split())

# 모든 가능한 a, b, c, d 값을 확인합니다.
# a, b, c, d는 모두 자연수여야 하며, a > c, b > d, a ≠ x, b ≠ x 이어야 합니다.
count = 0
for a in range(1, n + 1):
    for b in range(1, n + 1):
        for c in range(1, a):
            for d in range(1, b):
                if a * b - c * d == n and a != x and b != x and a > c and b > d:
                    count += 1

print(count)