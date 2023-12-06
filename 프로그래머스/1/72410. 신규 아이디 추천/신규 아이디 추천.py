def solution(new_id):
    answer = ""
    
    new_id = new_id.lower()
    print(new_id)
    
    for i in new_id:
        if i in ['-','_','.'] or i.islower() or i.isdigit():
            answer += i
    print(answer)
    
    while '..' in answer:
        answer = answer.replace('..', '.')
    print(answer)
    
    if answer.startswith('.'):
        answer = answer[1:]
    if answer.endswith('.'):
        answer = answer[:-1]
    print(answer)
    
    if answer == '':
        answer = 'a'
    print(answer)
    
    if len(answer) >= 16:
        answer = answer[:15]
    while answer[-1] == '.':
        answer = answer[:-1]
    print(answer)
    
    if len(answer) <= 2:
        while len(answer) != 3:
            answer += answer[-1]
    print(answer)
    
    return answer