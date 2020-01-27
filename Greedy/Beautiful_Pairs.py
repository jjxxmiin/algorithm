#!/bin/python3

import math
import os
import random
import re
import sys


# Complete the beautifulPairs function below.
def beautifulPairs(A, B, n):
    A = sorted(A, reverse=True)
    B = sorted(B, reverse=True)

    i = 0
    j = 0
    cnt = 0

    while i < n and j < n:
        if A[i] == B[j]:
            cnt += 1
            i += 1
            j += 1

        elif A[i] < B[j]:
            j += 1
        else:
            i += 1

    if cnt == n:
        cnt -= 1
    else:
        cnt += 1

    return cnt


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    A = list(map(int, input().rstrip().split()))
    B = list(map(int, input().rstrip().split()))

    result = beautifulPairs(A, B, n)

    fptr.write(str(result) + '\n')

    fptr.close()
