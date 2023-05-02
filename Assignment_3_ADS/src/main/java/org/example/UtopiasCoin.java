package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtopiasCoin {
    private final int[] coins = {1, 7, 10, 22};
    private final Map<Integer, List<Integer>> map = new HashMap<>();

    public List<Integer> getUtopiaCoins(int value) {
        ArrayList<Integer> wallet = new ArrayList<>();
        makeCoins(wallet, value);

        map.put(value,wallet);
        return wallet;
    }

    private void makeCoins(ArrayList<Integer> wallet, int value) {
        if(map.containsKey(value))
        {
            wallet.addAll(map.get(value));
            return;
        }

        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] <= value) {
                int nrOfTimes = value / coins[i];
                value -= (coins[i] * nrOfTimes);
                for (int j = 0; j < nrOfTimes; j++) {
                    wallet.add(coins[i]);
                }
                makeCoins(wallet, value);
                break;
            }
        }
    }
}
