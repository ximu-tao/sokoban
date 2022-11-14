package com.outlook.me_litao.exception;

/**
 * CharacterRepeat
 */
public class CharacterRepeat extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = -1553533561665289407L;

    private final int []a = new int[4];
    
    
    public CharacterRepeat(int x1, int y1, int x2, int y2){
        a[0] = x1;
        a[1] = y1;
        a[2] = x2;
        a[3] = y2;
    }

    public String getMessage(){
        return 
        "CharacterPositionRepeat for ("+a[0]+","+a[1]+") and ("+a[2]+","+a[3]+")"
        ;
        
    } 
}