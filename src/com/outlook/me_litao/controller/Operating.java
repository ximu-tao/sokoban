package com.outlook.me_litao.controller;// package sokoban.operating;

import com.outlook.me_litao.domain.Sokoban;

/**
 * Operating
 * 该类用于确定以什么方式调用操作
 */

abstract public class Operating {
    Sokoban s;
    Operating(){
    }

    Operating(Sokoban s){
        setSokoban(s);
    }

    public void setSokoban( Sokoban s ){
        this.s = s;
    }
    @Deprecated
    void up(){
        this.s.moveUp();
    }

    @Deprecated
    void down(){
        this.s.moveDown();
    }

    @Deprecated
    void left(){
        this.s.moveLeft();
    }

    @Deprecated
    void right(){
        this.s.moveRight();
    }

    // abstract int start();
    public abstract int[] getOperating();

    @Deprecated
    abstract void start();
}