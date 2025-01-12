package be.avidoo.application.dossier;

import be.avidoo.application.AbstractIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DossierAggregateControllerIT extends AbstractIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void greetingShouldReturnMessageFromService() throws Exception {
        String result = this.mockMvc.perform(post("/api/dossier"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertThat(result).isNotNull();
    }

}