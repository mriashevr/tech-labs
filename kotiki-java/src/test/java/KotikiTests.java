import Dao.KotikDao;
import Dao.OwnerDao;
import Entities.Kotik;
import Entities.Owner;
import Services.ServiceKotik;
import org.checkerframework.checker.units.qual.K;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static Entities.Breed.British;
import static Entities.Color.Black;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class KotikiTests {
    @Mock
    private KotikDao kotikDao;
    private OwnerDao ownerDao;
    private AutoCloseable closeable;
    private ServiceKotik serviceKotik;

    @BeforeEach
    void initService() {
        MockitoAnnotations.initMocks(this);
        this.serviceKotik = new ServiceKotik(kotikDao);
    }


    @Test
    public void checkKotikPresence() throws Exception{
        Owner owner = new Owner("naruto", LocalDate.of(2002,2,13));
        Kotik cat = new Kotik("saske", LocalDate.of(2012,12,12),British, Black, owner);
        when(kotikDao.get(1)).thenReturn(cat);

        Kotik savedKotik = serviceKotik.findById(1);

        verify(kotikDao).get(Mockito.anyInt());

        assertEquals(cat, savedKotik);
    }
}
