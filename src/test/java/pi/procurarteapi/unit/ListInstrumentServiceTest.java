package pi.procurarteapi.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pi.procurarteapi.app.instrument.dtos.ListInstrument.ListInstrumentResponseDto;
import pi.procurarteapi.app.instrument.services.ListInstrumentService;

@SpringBootTest
public class ListInstrumentServiceTest {
    
    @Autowired
    private ListInstrumentService listInstrumentsService;

    @Test
    void listInstrumentShouldSucceed() throws Exception {

        ListInstrumentResponseDto response = listInstrumentsService.execute();

        assertThat(response).isNotNull();
        assertThat(response.getInstrument().size()).isGreaterThan(0);
    }
}
