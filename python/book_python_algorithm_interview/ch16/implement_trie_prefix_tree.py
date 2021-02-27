# 리트코드 208. Implement Trie [Prefix Tree]

# 내 풀이
class Tree_mySolution:
    def __init__(self, val=None):
        self.val = val
        self.children = {}
        self.count = 0
        self.endpoint = False


class Trie_mySolution:
    def __init__(self):
        self.root = Tree_mySolution()

    def insert(self, word: str) -> None:
        node = self.root
        while word:
            if word[0] not in node.children:
                node.children[word[0]] = Tree_mySolution(word[0])
            node.count += 1
            node = node.children[word[0]]
            word = word[1:]
        node.endpoint = True

    def search(self, word: str) -> bool:
        node = self.root
        while word:
            if word[0] not in node.children:
                return False
            node = node.children[word[0]]
            word = word[1:]

        if node.endpoint is False:
            return False
        return True

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        while prefix:
            if prefix[0] not in node.children:
                return False
            node = node.children[prefix[0]]
            prefix = prefix[1:]

        return True

# 책 풀이. 딕셔너리를 이용해 간결한 트라이 구현


class TrieNode:
    def __init__(self):
        self.word = False
        self.children = {}


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.word = True

    def search(self, word: str) -> bool:
        node = self.root
        for char in word:
            if char not in node.children:
                return False
            node = node.children[char]

        return node.word

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for char in prefix:
            if char not in node.children:
                return False
            node = node.children[char]

        return True
