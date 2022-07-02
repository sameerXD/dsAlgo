// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    public static int cutRope(int n , int a, int b, int c){
        if(n <= 0) return n;
        
        int[] temp = new int[3];
        
        temp[0] = cutRope(n-a, a, b,c);
        temp[1] = cutRope(n-b, a, b,c);
        temp[2] = cutRope(n-c, a, b,c);
        int max = temp[0];
        for(int i = 1; i<3; i++){
            if(max<temp[i]){
                max = temp[i];
            }
        }
        
        if (max<0) {return -1;}
        
        return max+1;
        
    }
    public static void main(String[] args) {
        int n = 5;
        int a = 2, b=5, c=1;
        
        int fin = cutRope(n, a,b,c);
        System.out.println(fin);
        
    }
}
