#!/bin/python3

import math
import os
import random
import re
import sys

"""
10 7 12

-> 3(1,2) 0 5

[0, 0, 0]
[2, 2, 3]
"""
def equal(arr):
    # 1 2 5

    min_num = min(arr)

    result = 100000000

    for base in [0, 1, 2, 5]:
        temp = 0

        for i in arr:
            dif = base + i - min_num
            
            temp += dif // 5
            dif = dif % 5
            temp += dif >> 1
            temp += dif & 1

        if temp < result:
            result = temp

    return result

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        n = int(input())

        arr = list(map(int, input().rstrip().split()))

        result = equal(arr)

        fptr.write(str(result) + '\n')

    fptr.close()
