package com.outlook.me_litao.test;

import com.outlook.me_litao.controller.OperatingDOS;
import com.outlook.me_litao.model.MapBinary;
import com.outlook.me_litao.domain.Sokoban;
import com.outlook.me_litao.controller.Operating;
import com.outlook.me_litao.view.ShowDOS;

/**
 * SokobanTest
 */

public class SokobanTest {
    public static void main(String[] args) {

        // 0: 空白 ; 1 : 墙 ; 2 : 目标点 ; 3 : 箱子 ; 4 : 人物 ;
        int[][] m = new int[][] {
            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 2, 3, 0, 0, 0, 0, 0, 0, 1 }, 
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            { 1, 1, 1, 1, 3, 2, 3, 0, 0, 1 },
            { 1, 0, 0, 0, 2, 0, 0, 0, 0, 1 }, 
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
            { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1 }, 
            { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 1, 4, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1 }, 
            { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1 }, 
            { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1 }, 
            { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1 }, 
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
        };

        Operating o = new OperatingDOS();
        
        new Sokoban(
            new MapBinary(m) ,
            new ShowDOS() ,
            o
        ).start();

    }
}