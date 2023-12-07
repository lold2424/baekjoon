def solution(numbers, hand):
    answer = ''
    line = [[3, 1], [0, 0], [0, 1], [0, 2], [1, 0], [1, 1], [1, 2], [2, 0], [2, 1], [2, 2]]
    left, right = [3, 0], [3, 2]
    for i in numbers:
        if i % 3 == 1:
            answer += 'L'
            left = line[i]
        elif i % 3 == 0 and i != 0:
            answer += 'R'
            right = line[i]
        else:
            l = abs(line[i][0] - left[0]) + abs(line[i][1] - left[1])
            r = abs(line[i][0] - right[0]) + abs(line[i][1] - right[1])
            if l < r:
                answer += 'L'
                left = line[i]
            elif l > r:
                answer += 'R'
                right = line[i]
            else:
                answer += hand[0].upper()
                if hand == 'right':
                    right = line[i]
                else:
                    left = line[i]                

    return answer