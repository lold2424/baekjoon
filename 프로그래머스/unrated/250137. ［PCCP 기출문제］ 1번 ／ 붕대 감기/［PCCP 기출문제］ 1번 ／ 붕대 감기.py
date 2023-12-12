def solution(bandage, health, attacks):
    attack_time = [sublist[0] for sublist in attacks]
    attack_cnt = 0
    heal_time = 0
    now_health = health
    stop = False
    for i in range(attacks[-1][0]):
        print(i+1, "초")
        print("stop 초기화", stop)
        for j in attacks:
            if stop == True:
                print("stop = True 입니다.")
                break
            if i+1 in attack_time:
                heal_time = 0
                stop = True
                now_health -= attacks[attack_cnt][1]
                print("공격 받았습니다.", attacks[attack_cnt][1], "데미지")
                attack_cnt += 1
                print("현재 체력 = ", now_health)
                if now_health <= 0:
                    return -1
            elif i+1 != j[0]:
                heal_time += 1
                if heal_time == bandage[0]:
                    print("붕대를 다 감아 추가 체력을 회복합니다.")
                    now_health += bandage[2] + bandage[1]
                    print("현재 체력 = ", now_health)
                    heal_time = 0
                    stop = True
                else:
                    print("붕대를 감는 중 입니다.")
                    now_health += bandage[1]
                    print("현재 체력 = ", now_health)
                    stop = True
                if now_health >= health:
                    stop = True
                    now_health = health
                    print("현재 체력 = ", now_health)
                    print("최대 체력입니다.")
        stop = False
    return now_health