const fs = require('fs');
let stdin = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString().trim()
    : `500`
).split('\n');

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const N = Number(input());
let title = 666;
let cnt = 0;

while (1) {
  if (title.toString().includes('666')) {
    cnt += 1;

    if (cnt === parseInt(N)) {
      break;
    }
  }
  title += 1;
}

console.log(title);
