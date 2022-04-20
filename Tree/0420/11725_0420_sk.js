const fs = require("fs");
let stdin = (
  process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString().trim()
    : `7
1 6
6 3
3 5
4 1
2 4
4 7`
).split("\n");

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const N = parseInt(input());
const tree = Array.from(Array(N + 1), () => Array());
const parentsNodeList = new Array(N + 1).fill(false);

const dfs = (root, tree, parentsNodeList) => {
  let nodeList = [root];
  while (nodeList.length > 0) {
    let node = nodeList.pop();
    for (let idx of tree[node]) {
      if (parentsNodeList[idx]) continue;
      parentsNodeList[idx] = node;
      nodeList.push(idx);
    }
  }
};

for (let i = 1; i < N; i++) {
  const [node1, node2] = input()
    .split(" ")
    .map((value) => parseInt(value));
  tree[node1].push(node2);
  tree[node2].push(node1);
}

dfs(1, tree, parentsNodeList);
console.log(parentsNodeList.slice(2).join("\n"));
