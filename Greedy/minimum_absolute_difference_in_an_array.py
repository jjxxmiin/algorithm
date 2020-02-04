#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the minimumAbsoluteDifference function below.
def minimumAbsoluteDifference(arr):
    min_value = 1000000000

    sorted_arr = sorted(arr)

    for i in range(0, len(arr)-1):
        diff = abs(sorted_arr[i+1] - sorted_arr[i]) 
    
        if diff < min_value:
            min_value = diff

    return min_value


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    result = minimumAbsoluteDifference(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
