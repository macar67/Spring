import com.example.demo.DemoApplication;
import com.example.demo.model.Transports;
import com.example.demo.repository.RouteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = DemoApplication.class )
@WebAppConfiguration
public class RouteAssigmentTest
{

    protected MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;


    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    private ObjectMapper objectMapper = new ObjectMapper();

    // Buradaki testin amacı Araçlara yeni bir rota ataması yapıldığında kurallara uygun olmayan bir durum söz konusu ise işlemin 406 HTTP kodunu dönmesini bekliyorum.
    @Test
    public void routeAssigmentToVehicleTest_If_Does_Not_Rules() throws Exception {
        setUp();

        String uri = "/transport/updateRoute";
        Transports transports = new Transports();
        transports.setSpeed(45);
        transports.setCapacity(12);
        transports.setName("Test-Araci");
        transports.setPlate("99KM12");
        transports.setRouteid(9);

        String jsonString = objectMapper.writeValueAsString(transports);

        MvcResult mvcResult =
                mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonString).param("id", "99"))
                        .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(406, status);


    }
    // Buradaki testin amacı Araçlara yeni bir rota ataması yapıldığında kurallara uygun bir atama ise işlemin 200 HTTP kodunu dönmesini bekliyorum.
    @Test
    public void routeAssigmentToVehicleTest_If_Obey_Rules() throws Exception {
        setUp();

        String uri = "/transport/updateRoute";
        Transports transports = new Transports();
        transports.setSpeed(112);
        transports.setCapacity(95);
        transports.setName("Test-Araci2");
        transports.setPlate("11MK55");
        transports.setRouteid(3);

        String jsonString = objectMapper.writeValueAsString(transports);

        MvcResult mvcResult =
                mvc.perform(MockMvcRequestBuilders.put(uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(jsonString).param("id", "4"))
                        .andReturn();

        int statusSeconCondition = mvcResult.getResponse().getStatus();
        assertEquals(200, statusSeconCondition);


    }
}