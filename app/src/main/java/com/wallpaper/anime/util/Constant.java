package com.wallpaper.anime.util;

import android.util.Log;

import java.util.Random;

public class Constant {

    private static final String TAG = "Constant";

    public static int getRandomPage(String type) {
        int page = 1;
        int MIN = 1;
        int MOEIMG = 213;
        int COSPLAY = 129;
        int GAMERSKY = 60;
        int CDN = 70;
        int START=5;
        switch (type) {
            case "moeimg":
                page = new Random().nextInt(MOEIMG) % (MOEIMG - MIN + 1) + MIN;
                break;
            case "cosplay":
                page = new Random().nextInt(COSPLAY) % (COSPLAY - MIN + 1) + MIN;
                break;
            case "gamersky":
                page = new Random().nextInt(GAMERSKY) % (GAMERSKY - MIN + 1) + MIN;
            case "CDN":
                page = new Random().nextInt(CDN) % (CDN - MIN + 1) + MIN;
                break;
            case "START":
                page = new Random().nextInt(START) % (START - MIN + 1) + MIN;
                break;
        }
        Log.i(TAG, "getRandomPage: " + page);
        return page;
    }
}
