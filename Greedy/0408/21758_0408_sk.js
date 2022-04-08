const fs = require("fs");
const stdin = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : `7
9 9 4 1 4 9 9`
).split("\n");

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const N = Number(input());
const honeyBuckets = input().split(" ").map(Number);

const honeySum = Array(N).fill(0);
honeySum[0] = honeyBuckets[0];

for (let i = 1; i < N; i++) {
  honeySum[i] += honeySum[i - 1] + honeyBuckets[i];
}

const total = honeySum[N - 1];
let max = 0;

for (let i = 1; i < N - 1; i++) {
  max = Math.max(
    max,
    total - honeySum[i] + total - (honeyBuckets[i] + honeyBuckets[0])
  );
}

for (let i = 1; i < N - 1; i++) {
  max = Math.max(
    max,
    honeySum[i - 1] + total - (honeyBuckets[i] + honeyBuckets[N - 1])
  );
}

for (let i = 1; i < N - 1; i++) {
  max = Math.max(
    max,
    total + honeyBuckets[i] - (honeyBuckets[0] + honeyBuckets[N - 1])
  );
}

console.log(max);
