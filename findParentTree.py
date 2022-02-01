# Baekjoon_11725

import sys

class Node:
  def __init__(self, data, left_node, right_node):
    self.data = data
    self.left_node = left_node
    self.right_node = right_node

def findParentTree(node):
  if node.left_node != None:
    parent_node[node.left_node] = node.data
    findParentTree(node.left_node)
  if node.right_node != None:
    parent_node[node.right_node] = node.data
    findParentTree(node.right_tree)

def makeTree(data):
  left, right = None, None
  for i in graph[data]:
    if i not in tree:
      if left == None:
        left = i
      else:
        right = i
  
  if not (left == None and right == None):
    tree[data] = Node(data, left, right)


n = int(input())
tree = dict()
graph = [[] for _ in range(n+1)]
for _ in range(n-1):
  i1, i2 = map(int, sys.stdin.readline().split())
  graph[i1].append(i2)
  graph[i2].append(i1)

makeTree(1)

parent_node = []*(n+1)
findParentTree(tree(1))
print(tree)
