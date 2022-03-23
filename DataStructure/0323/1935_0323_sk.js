const fs = require("fs");
const stdin = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : `5
    ABC*+DE/-
    1
    2
    3
    4
    5`
).split("\n");

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const calc = (op, numA, numB) => {
  if (op === "*") return numA * numB;
  if (op === "+") return numA + numB;
  if (op === "-") return numA - numB;
  if (op === "/") return numA / numB;
};

const N = parseInt(input());
const postfixNotation = input().split("");
const numbers = [];
const stack = [];

for (let i = 0; i < N; i++) {
  numbers.push(Number(input()));
}

for (const item of postfixNotation) {
  if (item >= "A" && item <= "Z") {
    stack.push(numbers[item.charCodeAt(0) - "A".charCodeAt(0)]);
  } else {
    const numA = stack.pop();
    const numB = stack.pop();
    stack.push(calc(item, numB, numA));
  }
}

console.log(stack.pop().toFixed(2));
