package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtopiasCoinTest {
    UtopiasCoin coin = new UtopiasCoin();

    @Test
    void test() {
        Assertions.assertEquals(coin.getUtopiaCoins(100),List.of(22,22,22,22,10,1,1));
    }

    @Test
    void stackTest() {
        coin.getUtopiaCoins(1000000);
    }
}