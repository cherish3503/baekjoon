# Baekjoon_11725
# dict를 사용한 트리 구현

import sys
sys.setrecursionlimit(10**6)

class Node:
  def __init__(self, data, left_node, right_node):
    self.data = data
    self.left_node = left_node
    self.right_node = right_node

def findParentTree(node):
  # 자식노드의 부모 노드를 기록
  if node.left_node != None:
    parent_node[node.left_node.data] = node.data
    if node.left_node.data in tree:
      findParentTree(node.left_node)
  if node.right_node != None:
    parent_node[node.right_node.data] = node.data
    if node.right_node.data in tree:
      findParentTree(node.right_node)

def makeTree(node):
  left, right = None, None
  for i in graph[node.data]:
    if i not in tree:
      if left == None:
        left = Node(i, None, None)
        tree[node.data].left_node = left
        tree[i] = left
      else:
        right = Node(i, None, None)
        tree[node.data].right_node = right
        tree[i] = right
  
  if left != None:
    makeTree(left)
  if right != None:
    makeTree(right)


n = int(input())
tree = dict() # dict를 사용한 트리
graph = [[] for _ in range(n+1)]
for _ in range(n-1):
  i1, i2 = map(int, sys.stdin.readline().split())
  graph[i1].append(i2)
  graph[i2].append(i1)

tree[1] = Node(1, None, None)
makeTree(tree[1]) # 1을 루트로 하는 트리 생성
parent_node = [None]*(n+1)
findParentTree(tree[1]) # 루트부터 자식노드의 부모 노드를 기록
for i in range(2,len(parent_node)):
  print(parent_node[i])
