#!/bin/python3

import math
import os
import random
import re
import sys


# Complete the maxSubarray function below.
# https://www.youtube.com/watch?v=E5r1cQ-vLgM
def maxSubarray(arr):
    # table : i번째 원소가 마지막 원소값인 부분 배열의 최대값
    # max(arr[2], arr[1] + arr[2], arr[0] + arr[1] + arr[2])
    table = [0 for _ in range(len(arr))]
    table[0] = arr[0]

    result = 0 if arr[0] < 0 else arr[0]

    for i in range(1, len(arr)):
        table[i] = max(table[i - 1] + arr[i], arr[i])
        result += arr[i] if arr[i] > 0 else 0

    if result == 0:
        result = max(arr)

    return max(table), result


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        n = int(input())

        arr = list(map(int, input().rstrip().split()))

        result = maxSubarray(arr)

        fptr.write(' '.join(map(str, result)))
        fptr.write('\n')

    fptr.close()
