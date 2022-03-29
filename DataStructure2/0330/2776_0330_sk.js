const fs = require("fs");
const stdin = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : ` 1
5
4 1 5 2 3
5
1 3 7 9 5`
).split("\n");

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const T = Number(input());

for (let i = 0; i < T; i++) {
  const N = Number(input());
  const dict1Arr = input().split(" ").map(Number);
  const dictSet = new Set();
  for (const num of dict1Arr) {
    dictSet.add(num);
  }
  const M = Number(input());
  const dict2Arr = input().split(" ").map(Number);

  console.log(dict2Arr.map((value) => (dictSet.has(value) ? 1 : 0)).join("\n"));
}
