const fs = require("fs");
const stdin = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : `10
100 9 77 65 39 27 45 1 80 495`
).split("\n");

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const N = Number(input());
const drinks = input().split(" ").map(Number);

drinks.sort((a, b) => b - a);

let accDrinks = drinks[0];
for (let i = 1; i < drinks.length; i++) {
  accDrinks += drinks[i] / 2;
}
console.log(accDrinks);
