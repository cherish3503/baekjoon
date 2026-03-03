# Baekjoon_1991
# binary tree _ dict

import sys

class Node:
  def __init__(self, data, left_node, right_node):
    self.data = data
    self.left_node = left_node
    self.right_node = right_node

def preorderTraversal(node):
  print(node.data, end='')
  if node.left_node != None:
    preorderTraversal(node.left_node)
  if node.right_node != None:
    preorderTraversal(node.right_node)
    
def inorderTraversal(node):
  if node.left_node != None:
    inorderTraversal(node.left_node)
  print(node.data, end='')
  if node.right_node != None:
    inorderTraversal(node.right_node)

def postorderTraversal(node):
  if node.left_node != None:
    postorderTraversal(node.left_node)
  if node.right_node != None:
    postorderTraversal(node.right_node)
  print(node.data, end='')

def makeTree(tree):
  # left 값을 node로 변환
  for data in tree:
    if tree[data].left_node in tree:
      tree[data].left_node = tree[tree[data].left_node]
    if tree[data].right_node in tree:
      tree[data].right_node = tree[tree[data].right_node]

tree = dict()
for i in range(int(input())):
  data, left, right = map(str, sys.stdin.readline().split())
  if left == '.':
    left = None
  if right == '.':
    right = None
  tree[data] = Node(data, left, right)

makeTree(tree)
preorderTraversal(tree['A'])
print()
inorderTraversal(tree['A'])
print()
postorderTraversal(tree['A'])
print()
