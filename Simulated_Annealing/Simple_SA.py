import numpy as np

def func(x,y):
    z = np.power((x + 2 * y - 7), 2) + np.power((2 * x + y - 5), 2)
    return z
x0 = 3
y0 = 5

T0 = 1000       # init temp
M = 70         # number of temp
N = 15          # number of move at temp
alpha = 0.85    # move operate

# Matyas function
z = func(x0,y0)

print("===== init =====")
print("X is {}".format(x0))
print("Y is {}".format(y0))
print("Z is {}".format(z))

of_final = 0

for i in range(M):
    for j in range(N):
        xt = 0
        yt = 0

        # move operator
        ran_x_1 = np.random.rand()
        ran_x_2 = np.random.rand()
        ran_y_1 = np.random.rand()
        ran_y_2 = np.random.rand()

        # random solution
        if ran_x_1 >= 0.5:
            x1 = ran_x_2
        else:
            x1 = -ran_x_2

        if ran_y_1 >= 0.5:
            y1 = ran_y_2
        else:
            y1 = -ran_y_2

        xt = x0 + x1
        yt = y0 + y1

        # update
        of_new = func(xt,yt)
        # pre
        of_final = func(x0,y0)

        ran_1 = np.random.rand()
        form = 1 / (np.exp((of_new - of_final) / T0))

        # downhill
        if of_new <= of_final:
            x0 = xt
            y0 = yt
        # uphill
        elif ran_1 <= form:
            x0 = xt
            y0 = yt
        # stay
        else:
            x0 = x0
            y0 = y0

    # 온도가 줄어든다.
    T0 = alpha * T0

print("===== predict =====")
print("X is {}".format(x0))
print("Y is {}".format(y0))
print("Z is {}".format(of_final))