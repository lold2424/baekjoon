def solution(survey, choices):
    answer = ''
    survey_element = ["R", "T", "C", "F", "J", "M", "A", "N"]
    arr = [0, 0, 0, 0, 0, 0, 0, 0]
    cnt = 0
    for i in survey:
        if choices[cnt] == 1:
            for j in range(0, 8):
                if i[0] == survey_element[j]:
                    arr[j] += 3
        elif choices[cnt] == 2:
            for j in range(0, 8):
                if i[0] == survey_element[j]:
                    arr[j] += 2
        elif choices[cnt] == 3:
            for j in range(0, 8):
                if i[0] == survey_element[j]:
                    arr[j] += 1
        elif choices[cnt] == 5:
            for j in range(0, 8):
                if i[1] == survey_element[j]:
                    arr[j] += 1
        elif choices[cnt] == 6:
            for j in range(0, 8):
                if i[1] == survey_element[j]:
                    arr[j] += 2
        elif choices[cnt] == 7:
            for j in range(0, 8):
                if i[1] == survey_element[j]:
                    arr[j] += 3
        cnt += 1
    for i in range(0, 8, 2):
        if arr[i] >= arr[i + 1]:
            answer += survey_element[i]
        else:
            answer += survey_element[i+1]
    return answer