public class TrieNode {
        char data;
        TrieNode[] nodes = new TrieNode[26];

        boolean isLastNode;

        public TrieNode(char data){
            this.data = data;
            isLastNode = false;
        }
}
