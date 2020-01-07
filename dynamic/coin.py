#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'getWays' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. LONG_INTEGER_ARRAY c
#
"""
   2  3  5  6
0 [1, 1, 1, 1]
1 [0, 0, 0, 0]
2 [1, 1, 1, 1]
3 [0, 1, 1, 1]
4 [1, 1, 1, 1]
5 [0, 1, 2, 2]
6 [1, 2, 2, 3]
7 [0, 1, 2, 2]
8 [1, 2, 3, 4]
9 [0, 2, 3, 4]
0 [1, 2, 4, 5]
"""
def getWays(n, c):
    # Write your code here
    for idx,item in enumerate(c):
        if item > n:
            del c[idx]
    
    arr = [[0 for col in range(len(c))] for row in range(n+1)]
    arr[0] = [1] * len(c)
    
    c = sorted(c)
    
    for i in range(min(c), n+1):
        if i % c[0] == 0:
            arr[i][0] = 1
        else:
            arr[i][0] = 0
        
        for j in range(1, len(c)):
            if i-c[j] < 0:
                arr[i][j] = arr[i][j-1] + 0
            else:
                arr[i][j] = arr[i][j-1] + arr[i-c[j]][j]
            
    return arr[n][len(c)-1]

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    m = int(first_multiple_input[1])

    c = list(map(int, input().rstrip().split()))

    # Print the number of ways of making change for 'n' units using coins having the values given by 'c'

    ways = getWays(n, c)

    fptr.write(str(ways) + '\n')

    fptr.close()