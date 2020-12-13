import com.zjx.island.IslandApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Junit单元测试Demo
 *
 * @author trevor.zhao
 * @date 2020/12/9
 */
@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest(classes = IslandApplication.class)
//一般使用Test作为单测类的后缀
public class JunitTest {

    /**
     * 测试方法必须用@Test修饰,测试方法必须是public void
     * 一般将单测放在单独的test文件夹内,测试代码的包应该和代码包结构一致
     * 测试单元中的每个方法必须可以独立测试，方法间不能有任何依赖
     *
     */
    @Test
    //一般采用test作为方法名前缀
    public void test_f() {
        System.out.println("my first junit test");
    }
}
