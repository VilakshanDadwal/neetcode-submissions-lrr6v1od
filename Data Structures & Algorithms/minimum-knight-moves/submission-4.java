class Solution {
    public int minKnightMoves(int x, int y) {
        var cache = new int[303][303];
        x = Math.abs(x);
        y = Math.abs(y);
        for(int i=0; i<303; i++) {
            Arrays.fill(cache[i], -1);
        }

        minMoves(x, y, cache);
        return cache[x][y];
    }

    private int minMoves(int x, int y, int[][] cache) {
        if(x==0 && y==0) cache[x][y] = 0;
        if(x==1 && y==1) cache[x][y] = 2;
        if(x==2 && y==0) cache[x][y] = 2;
        if(x==0 && y==2) cache[x][y] = 2;

        if(cache[x][y] != -1) return cache[x][y];

        cache[x][y] = 1 + Math.min(minMoves(Math.abs(x-1), Math.abs(y-2), cache),
                                    minMoves(Math.abs(x-2), Math.abs(y-1), cache));
        
        return cache[x][y];
    }
}
