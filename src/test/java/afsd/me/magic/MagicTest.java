package afsd.me.magic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * User: XuHui
 * Date: 2016/3/9
 * Time: 15:04
 */
public class MagicTest {
    @Test
    public void setUp(){
        Magic magic=new Magic();
        magic.rotationSurface(0,true,1);
        magic.outPrint();
    }
}