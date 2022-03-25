const fs = require("fs");
const stdin = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : `10 3
2 9 5`
).split("\n");

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const [N, M] = input().split(" ").map(Number);
const target = input().split(" ").map(Number);
const deque = Array.from(Array(N), function (value, index) {
  return index + 1;
});
let calcCnt = 0;

for (const idx of target) {
  while (true) {
    if (deque.indexOf(idx) === 0) {
      deque.shift();
      break;
    }

    if (deque.indexOf(idx) < deque.length - deque.indexOf(idx)) {
      deque.push(deque.shift());
      calcCnt += 1;
    } else {
      deque.unshift(deque.pop());
      calcCnt += 1;
    }
  }
}

console.log(calcCnt);

//첫 번째 원소를 뽑아낸다.(arr.shift())
//왼쪽으로 한 칸 이동시킨다.(arr.push(arr.shift()))
//오른쪽으로 한 칸 이동 (arr.unshift(arr.pop()))
