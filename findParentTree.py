# Baekjoon_11725
# dict를 사용한 트리 구현 (이진트리가 아님)

import sys
sys.setrecursionlimit(10**6)

class Node:
  def __init__(self, data, child_node):
    self.data = data
    self.child_node = child_node # 노드로 이루어진 배열

def findParentTree(node):
  # 자식노드의 부모 노드를 기록
  if node.child_node == None or len(node.child_node) == 0:
    return # 자식이 없을 경우 탈출

  for ch_node in node.child_node:
    parent_node[ch_node.data] = node.data
    findParentTree(ch_node)

def makeTree(node):
  child_arr = list()
  for i in graph[node.data]:
    if i not in tree:
      child = Node(i,None)
      child_arr.append(child)
      tree[i] = child
  tree[node.data].child_node = child_arr
  
  for ch in child_arr:
    makeTree(ch)


n = int(input())
tree = dict() # dict를 사용한 트리
graph = [[] for _ in range(n+1)]
for _ in range(n-1):
  i1, i2 = map(int, sys.stdin.readline().split())
  graph[i1].append(i2)
  graph[i2].append(i1)

tree[1] = Node(1, None)
makeTree(tree[1]) # 1을 루트로 하는 트리 생성
parent_node = [None]*(n+1)
findParentTree(tree[1]) # 루트부터 자식노드의 부모 노드를 기록
for i in range(2,len(parent_node)):
  print(parent_node[i])
