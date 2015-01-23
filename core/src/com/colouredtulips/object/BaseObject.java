package com.colouredtulips.object;

import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by rizkisunaryo on 1/15/15.
 */
public class BaseObject extends Actor{
    private boolean isTouched;
    private boolean isMoved;
    private boolean isDragged;

    public boolean isTouched() {
        return isTouched;
    }

    public void setTouched(boolean isTouched) {
        this.isTouched = isTouched;
    }

    public boolean isMoved() {
        return isMoved;
    }

    public void setMoved(boolean isMoved) {
        this.isMoved = isMoved;
    }

    public boolean isDragged() {
        return isDragged;
    }

    public void setDragged(boolean isDragged) {
        this.isDragged = isDragged;
    }
}
