const fs = require("fs");
const stdin = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : `10+20+30+40`
).split("\n");

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const expression = input().split("-");
const minusResult = [];
for (const item of expression) {
  const plusAccumulation = item
    .split("+")
    .map(Number)
    .reduce((accumulation, current) => accumulation + current);
  minusResult.push(plusAccumulation);
}

console.log(
  minusResult.reduce((accumulation, current) => accumulation - current)
);
