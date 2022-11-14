package com.outlook.me_litao.controller;

import com.outlook.me_litao.exception.Winning;
import java.io.IOException;
import java.util.Scanner;

/**
 * OperatingDOS
 */
public class OperatingDOS extends Operating {
    static int[] up_ = new int[]{-1,0};
    static int[] down_ = new int[]{1,0};
    static int[] left_ = new int[]{0,-1};
    static int[] right_ = new int[]{0,1};

    static int[] notMove_ = new int[]{0,0};
    public OperatingDOS() {
    }

    public int[] _up_(){
        // move( -1 , 0 );
        return up_;
    }
    public int[] _down_(){
        // move( 1 , 0);
        return down_;
    }
    public int[] _left_(){
        // move( 0 , -1);
        return left_;
    }
    public int[] _right_(){
        // move( 0 , 1);
        return right_;
    }
    
    @Override
    public int[] getOperating() {
        try{
            
            System.out.print("上W下S左A右D, 输入后需回车");

            int oi = System.in.read();
            char o = (char) oi;
            if (o =='W'  || o == 'w' ) {
                return _up_();
            } else if (o == 'S' || o == 's' ) {
                return _down_();
            } else if (o == 'A' || o == 'a' ) {
                return _left_();
            } else if (o == 'D' || o == 'd' ) {
                return _right_();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return notMove_;
    }

    @Deprecated
    void start(){
        try{
            this.s.refreshMap();
            while (true){

                Scanner sc = new Scanner(System.in);
                System.out.print("上U下D左L右R");
                String o = sc.nextLine();
                if (o.equals("U") || o.equals("u") ) {
                    up();
                } else if (o.equals("D") || o.equals("d") ) {
                    down();
                } else if (o.equals("L") || o.equals("l") ) {
                    left();
                } else if (o.equals("R") || o.equals("r") ) {
                    right();
                }


            }
        } catch ( Winning w){
            return;
        }
    }

    
}