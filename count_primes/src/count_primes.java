class count_primes {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        boolean[] numbers = new boolean[n];
        for (int p = 2; p <= (int) Math.sqrt(n); ++p) {
            if (!numbers[p])
                for (int j = p * p; j < n; j += p) numbers[j] = true;
        }
        int nPrimes = 0;
        for (int i = 2; i < n; i++) {
            if (!numbers[i]) ++nPrimes;
        }
        return nPrimes;
    }
}