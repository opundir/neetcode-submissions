class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    TrieNode(){
        isEndOfWord = false;
    }
}
class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int idx = ch-'a';
            if(node.children[idx]==null){
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    boolean dfs(String word, int idx, TrieNode root){
        if(idx == word.length()){
            return root.isEndOfWord;
        }

        char ch = word.charAt(idx);
        if(ch=='.'){
            for(int i=0; i<26; i++){
                if(root.children[i]!=null){
                    if(dfs(word,idx+1,root.children[i])){
                        return true;
                    }
                }
            }
        return false;
        }

        int i = ch - 'a';
        if(root.children[i] == null) return false;
        return dfs(word,idx+1,root.children[i]);
        
    }
}
