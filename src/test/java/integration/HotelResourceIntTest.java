package integration;

import com.cvc.corp.desafio.entity.Hotel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Marcos Pinho
 */
@RunWith(SpringRunner.class)
public class HotelResourceIntTest extends IntegrationSource {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveBuscarTodosOsHoteisComOCodigoDaCidadeFornecidaECalcularSeuValorTotalDeComissao() throws Exception {
        MockHttpServletResponse response = this.mockMvc.perform(get("/hotels/city/1032/checkin/2018-05-20/checkout/2018-05-25/adultos/2/criancas/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        Hotel hotel = objectMapper.readValue(response.getContentAsString(), Hotel.class);

        Assert.assertEquals(BigDecimal.valueOf(65372175.61), hotel.getRooms().get(0).getTotalPrice());
    }

    @Test
    public void deveBuscarOHotelComSeuRespectivoCodigoFornecidoECalcularSeuValorDeComissao() throws Exception {
        MockHttpServletResponse response = this.mockMvc.perform(get("/hotels/1/checkin/2018-05-20/checkout/2018-05-25/adultos/2/criancas/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        Hotel hotel = objectMapper.readValue(response.getContentAsString(), Hotel.class);

        Assert.assertEquals(BigDecimal.valueOf(25669.21), hotel.getRooms().get(0).getTotalPrice());
    }

}
