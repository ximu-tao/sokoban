package com.outlook.me_litao.domain;

import com.outlook.me_litao.controller.Operating;
import com.outlook.me_litao.exception.Winning;
import com.outlook.me_litao.model.SokobanMap;
import com.outlook.me_litao.view.Show;

/**
 * Map
 */

public class Sokoban {
    private SokobanMap map;
    private Show show;
    private Operating o ;

    Sokoban(SokobanMap map , Operating o){
        setMapObject(map);
        setOperatingClass(o);
    }

    public Sokoban(SokobanMap map, Show s, Operating o){
        setMapObject(map);
        setShow(s);
        setOperatingClass(o);
    }

    Sokoban( Show s ){
        setShow(s);
    }

    void setMapObject( SokobanMap map ){
        this.map = map;
        cP = map.getCharacterPosition();
    }

    void setShow( Show s){
        this.show = s;
        this.show.setMapObject(map);
    }

    void setOperatingClass( Operating o ){
        this.o = o;
        o.setSokoban(this);
    }


    void showMap(){
        show.refreshMap();
    }

    public void refreshMap(){
        show.refreshMap();
    }

    @Deprecated
    public void moveUp(){
        move( -1 , 0 );
    }
    @Deprecated
    public void moveDown(){
        move( 1 , 0);
    }
    @Deprecated
    public void moveLeft(){
        move( 0 , -1);
    }
    @Deprecated
    public void moveRight(){
        move( 0 , 1);
    }

    private byte cP[] = new byte[2]; // characterPosition 0:行坐标 1:列坐标
    /**
     * 移动人物到目标点,如果不能移动,直接返回
     */
    private final void moveTo( int x , int y){
        // return  map.isBox( x , y )
        // ||      map.isWall( x , y )  ;

        if ( map.isWall( x , y ) || map.isBox( x , y ) ) {
            return;
        } else {
            map.setCharacter( cP[0] , cP[1] , false );

            cP[0] = (byte)x;
            cP[1] = (byte)y;

            map.setCharacter( cP[0] , cP[1] , true );
        }
    }

    /**
     * 判断是否能移动到目标位置
     */
    private boolean canMoveTo( int x , int y){
        return !( map.isBox(x, y) || map.isWall(x, y)  );
    }


    /**
     * 把箱子从 from 推到 to;
     * 并移动人物到 from
     */
    private final void pushBoxTo( int fromX , int fromY , int toX , int toY){
        // return  map.isBox( fromX , fromY )
        // &&      !map.isWall( toX , toY );
        if ( map.isBox( fromX , fromY ) && this.canMoveTo(toX, toY) ) {
            map.setBox( fromX , fromY ,  false  );
            map.setBox( toX , toY ,  true  );
        }
        moveTo(fromX, fromY);
    }

    /**
     * 移动人物 从 from 到 to
     */
    private final void move( int moveX , int moveY ) {
        pushBoxTo( cP[0]+moveX , cP[1]+moveY , cP[0]+moveX*2 , cP[1]+moveY*2 );
        refreshMap();
        if ( map.getTargerCount() == 0){
            this.show.winning();
            throw new Winning();
        }
        return ;
    }

    private final void move( int[] move ){
        // if ( (move[0] ^ move[1]) == 1)
        move( move[0] , move[1] );

    }

    public void start(){
        refreshMap();
        try{
            while ( true ){
                move( this.o.getOperating() );
            }
        } catch ( Winning w){
            return;
        }
    }
}