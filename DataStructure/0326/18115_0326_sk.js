const fs = require("fs");
const stdin = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : `5
2 3 3 2 1`
).split("\n");

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

// 문제 풀이 실패 : 시간 초과 해결 못함
// 덱 클래스를 만들어서 문제를 푸는 방법
// *[Symbol.iterator]()
// 아직 위에 함수를 알기에는 많이 부족하다. 따로 공부해보겠습니다.

class Node {
  prev = null;
  next = null;
  constructor(value) {
    this.value = value;
  }
}

class Deque {
  constructor() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  pushFront(value) {
    const newNode = new Node(value);
    if (this.empty()) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.next = this.head;
      this.head.prev = newNode;
      this.head = newNode;
    }
    this.length += 1;
  }

  pushBack(value) {
    const newNode = new Node(value);
    if (this.empty()) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.next = newNode;
      newNode.prev = this.tail;
      this.tail = newNode;
    }
    this.length += 1;
  }

  popFront() {
    if (this.empty()) return -1;
    const front = this.front();
    this.head = this.head.next;
    this.length -= 1;
    return front;
  }

  popBack() {
    if (this.empty()) return -1;
    const back = this.back();
    this.tail = this.tail.prev;
    this.length -= 1;
    return back;
  }

  size() {
    return this.length;
  }

  empty() {
    return this.length === 0 ? 1 : 0;
  }

  front() {
    if (this.empty()) return -1;
    return this.head.value;
  }

  back() {
    if (this.empty()) return -1;
    return this.tail.value;
  }

  *[Symbol.iterator]() {
    let tmp = this.head;
    while (tmp) {
      yield tmp.value;
      tmp = tmp.next;
    }
  }
}

const N = input();
const cardSkills = input().split(" ").map(Number);
const cardLen = cardSkills.length;
const deque = new Deque();

for (let i = 1; i <= cardLen; i++) {
  const skill = cardSkills.pop();

  if (skill === 1) {
    deque.pushFront(i);
  } else if (skill === 2) {
    const temp = deque.popFront();
    deque.pushFront(i);
    deque.pushFront(temp);
  } else if (skill === 3) {
    deque.pushBack(i);
  }
}
console.log([...deque].join(" "));
