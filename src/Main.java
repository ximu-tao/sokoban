import com.outlook.me_litao.controller.Operating;
import com.outlook.me_litao.controller.OperatingDOS;
import com.outlook.me_litao.domain.Sokoban;
import com.outlook.me_litao.model.MapBinary;
import com.outlook.me_litao.view.ShowDOS;

/**
 * @program: sokoban
 * @description: description
 * @author: Ximu-Tao
 * @create: 2022-11-14 16:39
 **/
public class Main {
    public static void main(String[] args) {

         int[][] m = new int[][] {
            { 0, 0, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 0, 0, 1, 0 },
            { 1, 2, 4, 3, 0, 0, 1, 0 },
            { 1, 1, 1, 0, 3, 2, 1, 0 },
            { 1, 2, 1, 1, 3, 0, 1, 0 },
            { 1, 0, 1, 0, 2, 0, 1, 1 },
            { 1, 3, 0, 0, 3, 3, 2, 1 },
            { 1, 0, 0, 0, 2, 0, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1 },
        };

        Operating o = new OperatingDOS();

        new Sokoban(
            new MapBinary(m) ,
            new ShowDOS() ,
            o
        ).start();

    }
}
