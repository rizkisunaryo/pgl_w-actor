package com.colouredtulips;

import com.badlogic.gdx.Game;
import com.colouredtulips.util.ThirdPartyUtil;

import pgl.screen.Classroom;

/**
 * Created by rizkisunaryo on 1/15/15.
 */
public class Main extends Game {
    public static Main main;
    public static ThirdPartyUtil thirdPartyUtil;

    public Main(ThirdPartyUtil thirdPartyUtil1) {
        this.thirdPartyUtil = thirdPartyUtil1;
    }

    @Override
    public void create () {
        main=this;
        setScreen(new Classroom());
    }
}
