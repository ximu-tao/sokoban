package com.outlook.me_litao.view;

import com.outlook.me_litao.model.SokobanMap;

/**
 * Show
 */

abstract public class Show {
    
    SokobanMap map;

    public void setMapObject( SokobanMap a){
        this.map = a;
    }
    
    abstract public void refreshMap();
    abstract public void winning();
    
    // һЩ�������õķ���
    // abstract public void showNULL();
    // abstract public void showTarger();
    // abstract public void showWall();
    // abstract public void showBox();
    // abstract public void showCharacter();

}