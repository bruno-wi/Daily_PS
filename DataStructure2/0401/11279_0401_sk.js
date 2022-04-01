const fs = require("fs");
const [N, ...calculationInfo] = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : `11
2
2
3
3
1
0
0
0
0
0
0`
)
  .split("\n")
  .map(Number);

class MaxHeap {
  constructor() {
    this.heap = [];
  }

  empty() {
    return this.heap.length === 0 ? true : false;
  }

  insert(value) {
    this.heap.push(value);
    this.bubbleUp();
  }

  bubbleUp() {
    let currentIndex = this.heap.length - 1;
    while (currentIndex > 0) {
      const parentIndex = Math.floor((currentIndex - 1) / 2);
      if (this.heap[parentIndex] >= this.heap[currentIndex]) break;
      [this.heap[currentIndex], this.heap[parentIndex]] = [
        this.heap[parentIndex],
        this.heap[currentIndex],
      ];
      currentIndex = parentIndex;
    }
  }

  pop() {
    if (this.heap.length === 1) return this.heap.pop();
    const max = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.bubbleDown(0);
    return max;
  }

  bubbleDown(index) {
    const leftNodeIndex = 2 * index + 1;
    const rightNodeIndex = 2 * index + 2;
    const length = this.heap.length;
    let maxIndex = index;
    if (
      leftNodeIndex < length &&
      this.heap[leftNodeIndex] > this.heap[maxIndex]
    ) {
      maxIndex = leftNodeIndex;
    }
    if (
      rightNodeIndex < length &&
      this.heap[rightNodeIndex] > this.heap[maxIndex]
    ) {
      maxIndex = rightNodeIndex;
    }
    if (maxIndex !== index) {
      [this.heap[index], this.heap[maxIndex]] = [
        this.heap[maxIndex],
        this.heap[index],
      ];
      this.bubbleDown(maxIndex);
    }
  }
}

const answer = [];
const maxHeap = new MaxHeap();
for (const number of calculationInfo) {
  if (number === 0) {
    answer.push(maxHeap.empty() ? 0 : maxHeap.pop());
  }
  maxHeap.insert(number);
}

console.log(answer.join("\n"));
