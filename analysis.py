import matplotlib.pyplot as plt
from mpldatacursor import datacursor

# redblack = [37412373 / 1000, 112679601 / 1000, 152482659 / 1000, 219892824 ]
redblack = [10483701034, 20583646788, 43801864727, 89491311767, 196828564065, 403749239249, 1737372949111]
# heap = [30433429 / 1000, 107431423/1000, 144100246 / 1000, 228551977 / 1000]
heap = [10129146398, 20569858441, 40992147119, 88978224963, 177196415151, 534354941237, 1626088349660]
plt.xlabel('number of tasks 2^n')
plt.ylabel('time in nano seconds (n*1e11)')
plt.plot(heap)
plt.plot(redblack)
axes = plt.gca()
axes.set_xlim([1, 7])
axes.set_ylim([10000000000, 1800000000000])

plt.grid(True)

plt.show()
