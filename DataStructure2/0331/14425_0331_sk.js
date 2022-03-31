const fs = require("fs");
const stdin = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : `5 11
baekjoononlinejudge
startlink
codeplus
sundaycoding
codingsh
baekjoon
codeplus
codeminus
startlink
starlink
sundaycoding
codingsh
codinghs
sondaycoding
startrink
icerink`
).split("\n");

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const [N, M] = input().split(" ").map(Number);
const set = new Set();
for (let i = 0; i < N; i++) {
  set.add(input());
}

let cnt = 0;
for (let i = 0; i < M; i++) {
  if (set.has(input())) {
    cnt += 1;
  }
}
console.log(cnt);
