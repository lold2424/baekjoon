T = int(input())
for _ in range(T):
    N = int(input())
    one, zero = 1, 0
    for i in range(N):
        one, zero = zero, one + zero 
    print(one, zero)