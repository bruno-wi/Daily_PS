const fs = require("fs");
const [N, ...calculationInfo] = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : `18
1
-1
0
0
0
1
1
-1
-1
2
-2
0
0
0
0
0
0
0`
)
  .split("\n")
  .map(Number);

class MinHeap {
  constructor() {
    this.heap = [null];
  }

  insert(value) {
    this.heap.push(value);
    let currentIndex = this.heap.length - 1;
    let parentIndex = Math.floor(currentIndex / 2);
    while (parentIndex !== 0 && this._compare(value, this.heap[parentIndex])) {
      this._swap(parentIndex, currentIndex);
      currentIndex = parentIndex;
      parentIndex = Math.floor(currentIndex / 2);
    }
  }

  pop() {
    if (this.isEmpty()) return 0;
    if (this.heap.length === 2) return this.heap.pop();
    const returnValue = this.heap[1];
    this.heap[1] = this.heap.pop();
    let curIndex = 1;
    let leftIndex = 2;
    let rightIndex = 3;

    while (
      this._compare(this.heap[leftIndex], this.heap[curIndex]) ||
      this._compare(this.heap[rightIndex], this.heap[curIndex])
    ) {
      if (!this.heap[leftIndex]) this._swap(rightIndex, curIndex);
      else if (!this.heap[rightIndex]) this._swap(leftIndex, curIndex);
      else if (this._compare(this.heap[leftIndex], this.heap[rightIndex])) {
        this._swap(leftIndex, curIndex);
        curIndex = leftIndex;
      } else {
        this._swap(rightIndex, curIndex);
        curIndex = rightIndex;
      }
      leftIndex = curIndex * 2;
      rightIndex = curIndex * 2 + 1;
    }
    return returnValue;
  }

  isEmpty() {
    return this.heap.length === 1;
  }

  top() {
    return this.heap[1] ? this.heap[1] : 0;
  }

  _compare(a, b) {
    let dA = Math.abs(a);
    let dB = Math.abs(b);
    if (dA <= dB) {
      if (dA === dB) {
        if (a < b) return true;
        return false;
      }
      return true;
    }
    return false;
  }

  _swap(a, b) {
    [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]];
  }
}

// 최소 힙 클래스를 외부에서 가져다 사용하였다.. 다음에는 실제로 구현해서 사용해보자.

const answer = [];
const absoluteHeap = new MinHeap();
for (const number of calculationInfo) {
  if (number !== 0) {
    absoluteHeap.insert(number);
  } else {
    answer.push(absoluteHeap.pop());
  }
}

console.log(answer.join("\n"));
