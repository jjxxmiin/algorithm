#!/bin/python3

import os

# Complete the twoArrays function below.
def twoArrays(k, A, B):
    for i, j in zip(sorted(A), sorted(B,reverse=True)):
        if i+j < k:
            return "NO"

    return "YES"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input())

    for q_itr in range(q):
        nk = input().split()

        n = int(nk[0])

        k = int(nk[1])

        A = list(map(int, input().rstrip().split()))

        B = list(map(int, input().rstrip().split()))

        result = twoArrays(k, A, B)

        fptr.write(result + '\n')

    fptr.close()
