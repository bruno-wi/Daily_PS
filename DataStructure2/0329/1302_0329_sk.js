const fs = require("fs");
const stdin = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : `1
soul`
).split("\n");

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const booksSoldCnt = Number(input());
const bookMap = new Map();
for (let i = 0; i < booksSoldCnt; i++) {
  const bookName = input();
  bookMap.set(bookName, bookMap.has(bookName) ? bookMap.get(bookName) + 1 : 1);
}

const bestSeller = [...bookMap.entries()]
  .sort((a, b) => (a[0] < b[0] ? -1 : a[0] > b[0] ? 1 : 0))
  .sort((a, b) => b[1] - a[1]);

console.log(bestSeller[0][0]);
