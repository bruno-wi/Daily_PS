const fs = require('fs');
const stdin = (process.platform === 'linux' ? fs.readFileSync('/dev/stdin').toString().trim() : `7 3`).split('\n');

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const [N, K] = input().split(' ').map(Number);
const personCds = Array.from(Array(N), (value, idx) => idx + 1);
const answer = [];
while (personCds.length) {
  for (let i = 0; i < K; i++) {
    personCds.push(personCds.shift());
  }

  answer.push(personCds.pop());
}

console.log(`<${answer.join(', ')}>`);
