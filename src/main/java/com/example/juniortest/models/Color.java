package com.example.juniortest.models;


import java.util.Random;

public enum Color {
    Red,Orange,Yellow,Green,Blue,Indigo,Violet;

    // Получить рандомный цвет
//    https://developer.alexanderklimov.ru/android/java/random.php
    public static Color getRandomColor(){
        Color[] colors = Color.values();
        final Random random = new Random();
        int pos = random.nextInt(colors.length);
        return colors[pos];
    }
//    public void onClick(View view) {
//        Random random = new Random();
//        // Массив из пяти цветов
//        int colors[] = { Color.BLUE, Color.GREEN, Color.MAGENTA, Color.RED,
//                Color.CYAN };
//        int pos = random.nextInt(colors.length);
//        // Меняем цвет у кнопки
//        mButton.setBackgroundColor(colors[pos]);
//    }
}
