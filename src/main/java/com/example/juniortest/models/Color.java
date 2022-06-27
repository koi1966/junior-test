package com.example.juniortest.models;

import java.util.Random;

public enum Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET;

    // Получить рандомный цвет
//    https://developer.alexanderklimov.ru/android/java/random.php
    public static Color getRandomColor() {
        Color[] colors = Color.values();
        final Random random = new Random();
        int pos = random.nextInt(colors.length);
        return colors[pos];
    }
}
