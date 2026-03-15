package leetcode_dcc.mar_26;

import java.util.*;
/*
1622. Fancy Sequence (hard)

Write an API that generates fancy sequences using the append, addAll, and multAll operations.

Implement the Fancy class:

Fancy() Initializes the object with an empty sequence.
void append(val) Appends an integer val to the end of the sequence.
void addAll(inc) Increments all existing values in the sequence by an integer inc.
void multAll(m) Multiplies all existing values in the sequence by an integer m.
int getIndex(idx) Gets the current value at index idx (0-indexed) of the sequence modulo 109 + 7. If the index is greater or equal than the length of the sequence, return -1.

Streak->221


 */
class Fancy {

    ArrayList<Long> list;
    long mul, add;
    long MOD = 1_000_000_007L;

    public Fancy() {
        list = new ArrayList<>();
        mul = 1;
        add = 0;
    }

    public void append(int val) {
        long stored = ((val - add + MOD) % MOD * modInverse(mul)) % MOD;
        list.add(stored);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= list.size()) return -1;
        long ans = (list.get(idx) * mul) % MOD;
        ans = (ans + add) % MOD;
        return (int) ans;
    }

    private long modInverse(long x) {
        return power(x, MOD - 2);
    }

    private long power(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}

public class FancySequence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Fancy fancy = new Fancy();

        System.out.println("Enter number of operations:");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("Enter operation:");
            int op = sc.nextInt();

            switch (op) {

                case 1: // append
                    int val = sc.nextInt();
                    fancy.append(val);
                    break;

                case 2: // addAll
                    int inc = sc.nextInt();
                    fancy.addAll(inc);
                    break;

                case 3: // multAll
                    int m = sc.nextInt();
                    fancy.multAll(m);
                    break;

                case 4: // getIndex
                    int idx = sc.nextInt();
                    System.out.println(fancy.getIndex(idx));
                    break;

                default:
                    System.out.println("Invalid operation");
            }
        }

        sc.close();
    }
}