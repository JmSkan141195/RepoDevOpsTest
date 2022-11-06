/*import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.esprit.examen.entities.*;
import com.esprit.examen.repositories.*;
import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class SpringBootWithUnitTestApplicationTests
{
    @Autowired
    MagasinRepository magasinRepository;


    @Test
    public void  contextLoads()
    {

    }

    @Test
    //@Order(0)
    public void ajouterMagasinTest()
    {
        Magasin m = new Magasin();
        magasinRepository.save(m);
        log.info(m.toString());
        Assert.assertNotNull(m.getMagasinId());
    }

}
*/
