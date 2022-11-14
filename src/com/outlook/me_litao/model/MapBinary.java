package com.outlook.me_litao.model;

import com.outlook.me_litao.exception.CharacterRepeat;
import com.outlook.me_litao.exception.TargerBoxNotEqual;

/**
 * MapBinary
 *
 * 使用一个变量的二进制状态存储物品
 * 对应关系如下:
 * Wall         墙          00000001
 * Targer       目标点      00000010
 * Box          箱子        00000100
 * Character    人物        00001000
 */
public class MapBinary extends SokobanMap {

    byte[][] map ;

    public MapBinary(int[][] a){
        newMap( a.length , a[0].length );
        buildMap(a);
    }

    void buildMap( int[][]a ){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                switch ( a[i][j] ) {
                    case 1: setWall( i , j , true );
                        break;
                    case 2: setTarger( i , j , true );
                        targerCount++;
                        break;
                    case 3: setBox( i , j , true );
                        boxCount++;
                        break;
                    case 4: setCharacter( i , j , true );
                        if ( characterPosition[0] != -1
                                || characterPosition[1] != -1
                        ) {
                            throw new CharacterRepeat(
                                    characterPosition[0] ,
                                    characterPosition[1] ,
                                    i ,
                                    j
                            );
                        }
                        characterPosition[0] = (byte)i;
                        characterPosition[1] = (byte)j;
                        break;
                }
            }
        }

        if ( targerCount != boxCount) {
            throw new TargerBoxNotEqual( targerCount , boxCount);
        }
    }

    void newMap( int x , int y){
        this.map = new byte[x][y];
    }

    public int getHigh(){
        return map.length;
    }
    public int getWidth(){
        return map[0].length;
    }



    /**
     * 二进制移位量
     */
    private static byte Wall        = 0;
    private static byte Targer      = 1;
    private static byte Box         = 2;
    private static byte Character   = 3;

    public void setWall( int x , int y , boolean wall){
        map[x][y]^=(1<<Wall);
    }
    public void setTarger( int x , int y , boolean targer ){
        map[x][y]^=(1<<Targer);
    }
    public void setBox( int x , int y , boolean box ){
        if ( isTarger(x, y)  ){
            if ( box ){
                targerCount--;
            } else {
                targerCount++;
            }
        }
        map[x][y]^=(1<<Box);
    }

    public void setCharacter( int x , int y , boolean character ){
        map[x][y]^=(1<<Character);
    }

    public boolean isWall( int x , int y ){
        return ((map[x][y]>>Wall)&1) == 1;
    }
    public boolean isTarger( int x , int y ){
        return ((map[x][y]>>Targer)&1) == 1;
    }
    public boolean isBox( int x , int y ){
        return ((map[x][y]>>Box)&1) == 1;
    }
    public boolean isCharacter( int x , int y ){
        return ((map[x][y]>>Character)&1) == 1;

        // return (map[x][y] ^ (1<<Character) ^ 0) != 0;
    }



}