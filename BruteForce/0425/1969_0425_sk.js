const fs = require("fs");
let stdin = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : `5 8
TATGATAC
TAAGCTAC
AAAGATCC
TGAGATAC
TAAGATGT`
).split("\n");

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const [N, M] = input().split(" ").map(Number);
const DNA = Array.from(Array(N), () => input().split(""));
let smallestSumOfHammingDistance = "";
let sumOfHammingDistance = 0;

for (let i = 0; i < M; i++) {
  let [A, C, G, T] = [0, 0, 0, 0];
  for (let j = 0; j < N; j++) {
    const nucleotide = DNA[j][i];
    if (nucleotide === "A") {
      A += 1;
    } else if (nucleotide === "C") {
      C += 1;
    } else if (nucleotide === "G") {
      G += 1;
    } else if (nucleotide === "T") {
      T += 1;
    }
  }

  const maxCntOfNucleotide = Math.max.apply(null, [A, C, G, T]);
  const idxMaxNucleotide = [A, C, G, T].find(
    (cnt) => maxCntOfNucleotide === cnt
  );
  if (idxMaxNucleotide === A) {
    smallestSumOfHammingDistance += "A";
  } else if (idxMaxNucleotide === C) {
    smallestSumOfHammingDistance += "C";
  } else if (idxMaxNucleotide === G) {
    smallestSumOfHammingDistance += "G";
  } else if (idxMaxNucleotide === T) {
    smallestSumOfHammingDistance += "T";
  }
  sumOfHammingDistance += N - maxCntOfNucleotide;
}

console.log(smallestSumOfHammingDistance);
console.log(sumOfHammingDistance);
