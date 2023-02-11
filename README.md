# 推箱子游戏
> 一个运行在终端窗口的推箱子小游戏

## 游玩
前往 [Releases](https://github.com/ximu-tao/sokoban/releases/) 下载游戏jar包

下载sokoban.jar后，使用```java -jar sokoban.jar```命令运行游戏

### 运行效果
![sokoban游戏运行效果](https://s3.bmp.ovh/imgs/2023/02/11/0fb9ecaa6dcd9cb9.png)

### 游戏胜利
![sokoban游戏胜利效果](https://s3.bmp.ovh/imgs/2023/02/11/939c0bdde3c15375.png)
# 推箱子游戏结构

## 接口定义

### SokobanMap 地图模型类(抽象)
确定地图上的物品信息在内存中的存储方式

提供Wall、Targer、Box、Character的set()和is()接口

### Show 界面类(抽象)
用于显示游戏地图
提供 refreshMap()接口刷新地图


### Operating 操作类(抽象)
提供 getOperating()接口 , 返回用户操作的移动方向
提供 winning()接口 , 向用户显示胜利

## Sokoban 主类
游戏主循环及部分交互逻辑的定义

必要的初始化操作
Sokoban( SokobanMap map , Show s , Operating o){
          地图信息          显示方式   操作方式
        

## 异常类定义

### CharacterRepeat
> 出现阶段: 地图初始化阶段
> 定义地图时, 人物重复

### TargerBoxNotEqual
> 出现阶段: 地图初始化阶段
> 定义地图时, 箱子数量与目标点数量不一致

### Winning
> 出现阶段: 游戏中
> 玩家胜利


## 实现类