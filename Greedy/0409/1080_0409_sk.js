const fs = require("fs");
const stdin = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `3 4
1001
1011
1001
1001
1011
1001`
).split("\n");

function solve(N, M, originalMatrix, wantedMatrix) {
  let ans = 0;

  function checkSame() {
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        if (originalMatrix[i][j] !== wantedMatrix[i][j]) return 0;
      }
    }
    return 1;
  }

  function changeArr(x, y) {
    for (let i = x; i < x + 3; i++) {
      for (let j = y; j < y + 3; j++) {
        originalMatrix[i][j] = originalMatrix[i][j] === 1 ? 0 : 1;
      }
    }
  }

  if (checkSame()) {
    console.log(0);
    return;
  }

  for (let i = 0; i < N - 2; i++) {
    for (let j = 0; j < M - 2; j++) {
      if (originalMatrix[i][j] !== wantedMatrix[i][j]) {
        ans++;
        changeArr(i, j);
        if (checkSame()) {
          console.log(ans);
          return;
        }
      }
    }
  }
  console.log(-1);
}

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const [N, M] = input().split(" ").map(Number);
const originalMatrix = [];
const wantedMatrix = [];
for (let i = 0; i < 2; i++) {
  for (let j = 0; j < N; j++) {
    i === 0
      ? originalMatrix.push(input().split("").map(Number))
      : wantedMatrix.push(input().split("").map(Number));
  }
}
solve(N, M, originalMatrix, wantedMatrix);
