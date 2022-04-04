const fs = require("fs");
const [N, ...rope] = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : `5
27
23
15
11
3`
)
  .split("\n")
  .map(Number);

rope.sort((a, b) => b - a);

let maxWeight = [];
for (let i = 0; i < N; i++) {
  maxWeight.push(rope[i] * (i + 1));
}
console.log(Math.max.apply(null, maxWeight));
