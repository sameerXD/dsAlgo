import java.util.ArrayList;

public class Trie {
    public TrieNode root;

    public Trie(){
        root = new TrieNode('\0');
    }

    public void insertUtil(TrieNode root, String word){
        // base case
        if(word.length() == 0){
            root.isLastNode = true;
            return ;
        }

        TrieNode child ;
        // assuming that all the characters are caps
        int charIndex = word.charAt(0)-'A';
        
        // search character 
        if(root.nodes[charIndex]!=null){
            // if the character is found
            child = root.nodes[charIndex];
        }else{
            // if the character is not found
            TrieNode newRoot= new TrieNode(word.charAt(0));
            root.nodes[charIndex] = newRoot;
            child = newRoot;
        }

        // call recursion
        insertUtil(child, word.substring(1));
    }

    public void insertWord(String word){
        insertUtil(root, word);
    }

    public boolean searchUtil(TrieNode root ,String word){
        // base case
        if(word.length() == 0){
            // check if it is the terminating node
            return root.isLastNode;
        }

        TrieNode child ;

        // calculate the index of 0th character
        // assuming all the characters are in caps
        int tempIdx = word.charAt(0) - 'A';

        // search if this index is not null
        if(root.nodes[tempIdx]!=null){
            child = root.nodes[tempIdx];
        }else{
            // if the character is absent
            return false;
        }

        return searchUtil(child, word.substring(1));

    }
    public boolean searchWord(String word){
        return searchUtil(root, word);
    }


    public void removeUtil(TrieNode root, String word){
        // base case 
        if(word.length() == 0){
            root.isLastNode = false;

            // check if the root is not a prefix of any other string
            // if no then delete the root

            return;
        }

        TrieNode child;

        int tempIdx =word.charAt(0) - 'A';
        // search char
        if(root.nodes[tempIdx]!=null){
            child = root.nodes[tempIdx];
        }else{
            return;
        }

        removeUtil(child, word.substring(1));
    }


    public void removeWord(String word){
        removeUtil(root, word);
    }

    public TrieNode searchLastUtil(TrieNode root, String word){
        if(word.length() == 0){
            if(root.isLastNode){
                return root;
            }
            return null;
        }

        int tempIdx = word.charAt(0) - 'A';
        TrieNode child;
        if(root.nodes[tempIdx] != null){
            child = root.nodes[tempIdx];
        }else{
            return null;
        }

        return searchLastUtil(child, word.substring(1));
    }

    public TrieNode searchLastNode(String word){
        return searchLastUtil(root, word);
    }

    public void autoCompleteUtil(TrieNode root, ArrayList<String> ls, String str){
        if(root.isLastNode){
            ls.add(str);
        }


        for(int i= 0; i<26; i++){
            if(root.nodes[i]!=null){
                char c= (char) ('A'+i);
                autoCompleteUtil(root.nodes[i], ls, str+c);
            }
        }
    }

    public ArrayList<String> autoComplete(String word){
        ArrayList<String> ls = new ArrayList<>();

        TrieNode divergentNode = searchLastNode(word);

        if(divergentNode == null) {
            return ls;
        }
        autoCompleteUtil(divergentNode, ls, word);

        return ls;
    }


    public static void main(String[] args){
        Trie trie = new Trie();

        // insert
        trie.insertWord("AUTOGRAPH");
        trie.insertWord("AUTOBIOGRAPHY");
        trie.insertWord("AUTOMOBILE");
        trie.insertWord("AUTOMOTIVE");
        trie.insertWord("AUTO");
        trie.insertWord("AUTOMATION");
        trie.insertWord("AUTONOMOUS");



        trie.insertWord("SAMEER");

        // search
        System.out.println(trie.searchWord("ABCD"));
        System.out.println(trie.searchWord("ABC"));
        System.out.println(trie.searchWord("ABCDE"));
        System.out.println(trie.searchWord("SAMEER"));

        // remove
        trie.removeWord("ABCD");
        System.out.println(trie.searchWord("ABCD"));

        //auto complete
        ArrayList<String> ls = trie.autoComplete("AUTO");
        System.out.println(ls);
    }
}
