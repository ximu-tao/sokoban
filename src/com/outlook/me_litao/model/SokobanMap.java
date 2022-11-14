package com.outlook.me_litao.model;

/**
 * Map
 */
abstract public class SokobanMap {

    SokobanMap(){}

    SokobanMap( int a[][] ){
        
    }

    byte characterPosition[] = new byte[]{-1,-1};
    byte targerCount = 0;
    byte boxCount = 0;


    abstract public void setWall( int x , int y , boolean wall);
    abstract public void setTarger( int x , int y , boolean targer );
    abstract public void setBox( int x , int y , boolean box );
    abstract public void setCharacter( int x , int y , boolean character );
    
    abstract public boolean isWall( int x , int y );
    abstract public boolean isTarger( int x , int y );
    abstract public boolean isBox( int x , int y );
    abstract public boolean isCharacter( int x , int y );


    abstract public int getHigh();
    abstract public int getWidth();
    
    public byte[] getCharacterPosition(){
        return characterPosition;
    }
    
    public int getTargerCount(){
        return targerCount;
    }
    public int getBoxCount(){
        return boxCount;
    }
}