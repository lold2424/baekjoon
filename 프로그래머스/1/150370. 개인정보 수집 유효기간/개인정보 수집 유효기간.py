import datetime
def solution(today, terms, privacies):
    today_date = datetime.datetime.strptime(today, "%Y.%m.%d").date()
    answer = []
    cnt = 0
    for i in privacies:
        cnt += 1
        year = int(i[:4])
        month = int(i[5:7])
        day = int(i[-4:-2])
        for j in terms:
            if i[-1] == j[0]:
                month += int(j[2:])
                while month > 12:
                    year += 1
                    month -= 12
                privacies_date = datetime.date(year, month, day)
                if today_date >= privacies_date:
                    answer.append(cnt)
    return answer