const fs = require("fs");
const stdin = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : `5
marina
josipa
nikola
vinko
filipa
josipa
filipa
marina
nikola`
).split("\n");

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

// 해시를 사용 문제풀이라서  Map()을 사용하였는데 더 나은 방법이 있을 것 같다.

const N = Number(input());
const participantMap = new Map();
for (let i = 0; i < N; i++) {
  const name = input();
  participantMap.set(name, {
    sameCnt: participantMap.get(name)
      ? participantMap.get(name).sameCnt + 1
      : 1,
  });
}
for (let i = 0; i < N - 1; i++) {
  participantMap.get(input()).sameCnt -= 1;
}

let notCompletedName = "";
[...participantMap.entries()].flatMap((item) => {
  if (item[1].sameCnt === 1) notCompletedName = item[0];
});
console.log(notCompletedName);
