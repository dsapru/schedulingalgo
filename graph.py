import matplotlib.pyplot as plt
from mpldatacursor import datacursor

k = []
data = [-1, 1, 2, 4, 3, 5, 1, 2, 4, 5, 1, 2, 6, 6, 4, 5, 6, 1, 2, 5, 7, 6, 2, 6, -1, -1, -1, -1, -1, -1, -1, -1, 8, 8,
        -1, -1, -1, -1, -1, -1, 9, 9, 9, -1, -1, -1, -1, -1, -1, -1]
for i in range(1, len(data) + 1):
    k.append(i)

    # plt.xlabel("0=cv(2) 1=cv(3) 2=cv(5) 3=cv(10)")
print(k)
print(len(data))
plt.xlim(1, 50)
plt.ylim(-1, 10)
datacursor(plt.scatter(k, data))
plt.show()
