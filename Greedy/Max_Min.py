#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the maxMin function below.
def maxMin(k, arr):
    sorted_arr = sorted(arr)
    min_value = sorted_arr[k-1] - sorted_arr[0]

    for i in range(1, n-k+1):
        #subset = sorted_arr[i : i + k]
        unfair = sorted_arr[i+k-1] - sorted_arr[i]

        if min_value > unfair:
            min_value = unfair

    return min_value

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    k = int(input())

    arr = []

    for _ in range(n):
        arr_item = int(input())
        arr.append(arr_item)

    result = maxMin(k, arr)

    fptr.write(str(result) + '\n')

    fptr.close()
