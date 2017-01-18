public class ProgressiveAlignment {

    //Hirschberg
    private static String x;
    private static String y;

    private String lcs;


    //Phylogeny
    public static final int MAX_LENGTH = 10;




    public ProgressiveAlignment(String str1, String str2){
        this.x = str1;
        this.y = str2;
        this.lcs = new String();
        System.out.println("Sequence 1: " + str1);
        System.out.println("Sequence 2: " + str2);
        lcs = hirschberg();
        System.out.println("Alignment: " + lcs);

    }

    public static String compute(char[][] matrix, int n) {

        // TODO: 18/01/2017
//        findStarIndex(n,sequence);
//        centerString = sequence[starIndex];
//        multipleAlign = new String[n];
//        multipleAlignment(n,sequence);
//        System.out.println("total cost: "+calculateTotalCost(matrix,n));
//
//        String result="";
//        for(int i=0 ; i< n; i++)
//            result +=multipleAlign[i]+"\n";
//        return result;
        return "ok";
    }


    /*
    ----------------------------Start Hirschberg----------------------------
     */
    public String hirschberg() {
        System.out.println("In Hirschberg");
//        System.out.println("LCS: " + algC(x.length(), y.length(), x, y)); //computes & prints out the result
        return algC(x.length(), y.length(), x, y);
    }

    public int[] algB(int m, int n, String a, String b) {

        // Step 1
        int[][] k = new int[2][n+1];
        for( int j=0; j<=n; j++) {
            k[1][j] = 0;
        }

        // Step 2
        for(int i=1; i<=m; i++) {
            // Step 3
            for(int j=0; j<=n; j++) {
                k[0][j] = k[1][j];
            }

            // Step 4
            for(int j=1; j<=n; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    k[1][j] = k[0][j-1] + 1;
                }else{
                    k[1][j] = max(k[1][j-1], k[0][j]);
                }
            }
        }

        //Step 5
        return k[1];

    }
    /**
     * This method returns the maximum number between two numbers.
     *
     * @param x
     * @param y
     * @return
     */
    public int max(int x, int y) {
        if(x>y) {
            return x;
        }else{
            return y;
        }
    }

    public String algC(int m, int n, String a, String b) {
        int i=0;
        int j=0;
        String c = "";
        // Step 1
        if( n==0 ) {
            c = "";
        } else if( m==1 ) {
            c = "";
            for( j=0; j<n; j++ ) {
                if( a.charAt(0)==b.charAt(j) ) {
                    c= ""+a.charAt(0);
                    break;
                }
            }
            // Step 2
        } else {
            i= (int) Math.floor(((double)m)/2);

            // Step 3
            int[] l1 = algB(i, n, a.substring(0,i), b);
            int[] l2 = algB(m-i, n, reverseString(a.substring(i)), reverseString(b));

            // Step 4
            int k = findK(l1, l2, n);

            // Step 5
            String c1 = algC(i, k, a.substring(0, i), b.substring(0, k));
            String c2 = algC(m-i, n-k, a.substring(i), b.substring(k));

            c = c1+c2;
        }

        return c; // The LCS
    }
    /**
     * This method takes a string as input reverses it and
     * returns the result
     *
     * @param in
     * @return
     */
    public String reverseString(String in) {
        String out = "";

        for(int i=in.length()-1; i>=0; i--) {
            out = out+in.charAt(i);
        }

        return out;
    }

    /**
     * This method finds the index of the maximum sum of L1 and L2,
     * as described by Hirschberg
     *
     * @param l1
     * @param l2
     * @param n
     * @return
     */
    public int findK(int[] l1, int[] l2, int n) {
        int m = 0;
        int k = 0;

        for(int j=0; j<=n; j++) {
            if(m < (l1[j]+l2[n-j])) {
                m = l1[j]+l2[n-j];
                k = j;
            }
        }

        return k;
    }

    /*
    ----------------------------End Hirschberg----------------------------
     */

    /*
    ----------------------------Start Phylogenetic Tree Algorithm----------------------------
     */


}
