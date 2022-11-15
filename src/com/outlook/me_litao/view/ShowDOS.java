package com.outlook.me_litao.view;

import java.io.IOException;
import java.io.PrintStream;

public class ShowDOS extends Show {
    PrintStream out;
    public ShowDOS(PrintStream printStream){
        out = printStream;
    }
    public ShowDOS(){
        out = System.out;
    }

    
    String gap = " ";

    private static void cls() 
    throws IOException , InterruptedException {
        new ProcessBuilder( "cmd" , "/c" , "cls")
        .inheritIO().start().waitFor();
    }

    private void welcome(){
        out.println("欢迎来到推箱子小游戏");
    }

    private void showTip(){
        out.println("游戏目标: 将箱子(口)推到目标点(丶), 控制你的人物(人)开始行动吧! ");
        out.println("提示: (回)表示 箱子在目标点上, (太)表示 人物在目标点上");
    }
    
    
    public void refreshMap(){
        try{
            cls();
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
        welcome();
        showTip();

        for (int i = 0; i < map.getHigh(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                if ( map.isWall( i , j )) {
                    showWall();
                }  else if ( map.isTarger( i , j )) {
                    if ( map.isCharacter( i , j ) ){
                        showCharacterAndTarger();
                    } else if ( map.isBox( i , j ) ) {
                        showBoxAndTarger();
                    }else {
                        showTarger();
                    }

                } else if ( map.isCharacter( i , j )) {
                    showCharacter();
                } else if ( map.isBox( i , j )) {
                    showBox();
                } else {
                    showNULL();
                }
            }
            newLine();
        }
    }
    
    public void showNULL(){
        // 半角空格地图会乱, 所以这里使用全角空格
        out.print("　"+gap);
    }
    
    public void showTarger(){
        out.print("丶"+gap);
    }
    public void showWall(){
        out.print("墙"+gap);
        
    }
    public void showBox(){
        out.print("口"+gap);
        
    }
    public void showCharacter(){
        out.print("人"+gap);

    }

    public void showCharacterAndTarger(){
        out.print("太"+gap);
    }

    public void showBoxAndTarger(){
        out.print("回"+gap);
    }

    public void newLine(){
        out.print("\n");
    }

    public void winning(){
        out.print("\n" +
                "\n" +
                "           _             _             \n" +
                "          (_)           (_)            \n" +
                " __      ___ _ __  _ __  _ _ __   __ _ \n" +
                " \\ \\ /\\ / / | '_ \\| '_ \\| | '_ \\ / _` |\n" +
                "  \\ V  V /| | | | | | | | | | | | (_| |\n" +
                "   \\_/\\_/ |_|_| |_|_| |_|_|_| |_|\\__, |\n" +
                "                                  __/ |\n" +
                "                                 |___/ \n" +
                "\n");
    }
    
}