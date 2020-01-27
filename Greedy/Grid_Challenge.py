#!/bin/python3

import math
import os
import random
import re
import sys

def gridChallenge(grid):
    r = len(grid[0])
    c = len(grid)

    for i in range(0, r):
        for j in range(1, c):
            if grid[j][i] < grid[j-1][i]:
                return 'NO'

    return 'YES'

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        n = int(input())

        grid = []

        for _ in range(n):
            grid_item = input()
            # sort
            sorted_grid_item = sorted(grid_item)
            grid.append(sorted_grid_item)

        result = gridChallenge(grid)

        fptr.write(result + '\n')

    fptr.close()
