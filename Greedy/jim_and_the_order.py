#!/bin/python3

import math
import os
import random
import re
import sys


# Complete the jimOrders function below.
def jimOrders(orders):
    index_item = []
    rank = []

    for idx, order in enumerate(orders):
        index_item.append([sum(order), idx + 1])

    sorted_item = sorted(index_item)

    for _, idx in sorted_item:
        rank.append(idx)

    return rank


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    orders = []

    for _ in range(n):
        orders.append(list(map(int, input().rstrip().split())))

    result = jimOrders(orders)

    fptr.write(' '.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
