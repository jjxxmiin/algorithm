import numpy as np
# 적합도 평가
evalution = np.zeros(5)
# 우월한 유전자
dominant = 1
# 돌연변이가 나올 확률
mutation = 0.01
# 세대
gene = 0

# 최초 세대 생성
chromo = np.floor(np.random.rand(5, 10) * 10)
new_chromo = np.zeros((5, 10))
gene += 1

while (1):
    # 적합도 평가
    for i in range(len(chromo)):
        m_sum = 0
        for j in range(len(chromo[0])):
            if chromo[i][j] > dominant:
                m_sum += chromo[i][j] - dominant
            else:
                m_sum += dominant - chromo[i][j]

        evalution[i] = m_sum

    # 목표 적합도가 있으면 종료
    if 0 in evalution:
        break

    # 우월한 염색체 2개 선택
    select = np.argsort(evalution)[:2]

    for i in range(len(chromo)):
        for j in range(len(chromo[0])):
            # 돌연변이 발생
            if np.random.random() < mutation:
                new_chromo[i][j] = np.random.randint(0, 9)
            # 교배
            else:
                new_chromo[i][j] = chromo[select[np.random.randint(0, 1)]][j]

    chromo = np.copy(new_chromo)
    print("{}\n{}".format(gene, chromo))
    gene += 1

    if gene > 1000:
        break