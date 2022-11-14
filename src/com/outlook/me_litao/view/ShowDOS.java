package com.outlook.me_litao.view;

import java.io.IOException;

public class ShowDOS extends Show {
    
    char gap = '\t';

    private static void cls() 
    throws IOException , InterruptedException {
        new ProcessBuilder( "cmd" , "/c" , "cls")
        .inheritIO().start().waitFor();
    }
    
    
    public void refreshMap(){
        try{
            cls();
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

        for (int i = 0; i < map.getHigh(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                if ( map.isBox( i , j )) {
                    showBox();
                } else if ( map.isWall( i , j )) {
                    showWall();
                } else if ( map.isTarger( i , j ) && map.isCharacter( i , j ) ) {
                    showCharacterAndTarger();
                } else if ( map.isTarger( i , j )) {
                    showTarger();
                } else if ( map.isCharacter( i , j )) {
                    showCharacter();
                } else {
                    showNULL();
                }
            }
            newLine();
        }
    }
    
    public void showNULL(){
        System.out.print(" "+gap);
    }
    
    public void showTarger(){
        System.out.print("丶"+gap);
    }
    public void showWall(){
        System.out.print("墙"+gap);
        
    }
    public void showBox(){
        System.out.print("箱"+gap);
        
    }
    public void showCharacter(){
        System.out.print("人"+gap);

    }

    public void showCharacterAndTarger(){
        System.out.print("太"+gap);
    }

    public void newLine(){
        System.out.print("\n");
    }

    public void winning(){

        System.out.print("胜利");
    }
    
}