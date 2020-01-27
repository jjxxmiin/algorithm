#!/bin/python3

import math
import os
import random
import re
import sys


# Complete the decentNumber function below.
def decentNumber(n):
    result = ""

    if n % 3 == 0:
        print('5' * 3 * (n // 3))
    elif n % 3 == 2 and n >= 5:
        print('5' * 3 * (n // 3 - 1) + '3' * 5)
    elif n % 3 == 1 and n >= 10:
        print('5' * 3 * (n // 3 - 3) + '3' * 10)
    else:
        print('-1')

    return result


if __name__ == '__main__':
    t = int(input().strip())

    for t_itr in range(t):
        n = int(input().strip())

        decentNumber(n)
