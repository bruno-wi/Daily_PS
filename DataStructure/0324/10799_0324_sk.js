const fs = require("fs");
const stdin = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : `(((()(()()))(())()))(()())`
).split("\n");

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const brackets = input().split("");
const stack = [];
let stickCnt = 0;
for (let i = 0; i < brackets.length; i++) {
  if (brackets[i] === "(") {
    stack.push(brackets[i]);
  } else {
    stack.pop();
    if (brackets[i - 1] === "(") {
      stickCnt += stack.length;
    } else {
      stickCnt += 1;
    }
  }
}

console.log(stickCnt);
