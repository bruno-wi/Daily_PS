const fs = require("fs");
const stdin = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : `5
2 3 3 2 1`
).split("\n");

// 성호 풀이 참조해서 다시 풀었습니다.
// 위에 풀이 방법도 있지만 아래 방법이 바로 적용하기 좋을 것 같다.
// 신박해..

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const N = input();
const cardSkills = input().split(" ").map(Number);
const cardLen = cardSkills.length;
const deque = [];
const frontResult = [];

for (let i = 1; i <= cardLen; i++) {
  const skill = cardSkills.pop();

  if (skill === 1) {
    deque.push(i);
  } else if (skill === 2) {
    const temp = deque.pop();
    deque.push(i);
    deque.push(temp);
  } else if (skill === 3) {
    frontResult.push(i);
  }
}
console.log(deque.reverse().concat(frontResult).join(" "));
