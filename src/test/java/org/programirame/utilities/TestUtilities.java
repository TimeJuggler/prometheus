package org.programirame.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.programirame.models.Timetable;
import org.programirame.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class TestUtilities {

    public static String asJsonString(final Object obj) throws JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();
        final String jsonContent = mapper.writeValueAsString(obj);
        return jsonContent;
    }

    /**
     * Creates a {@link User}.
     *
     * @param userRequested The User to be created.
     * @param mockMvc The MockMvc object to be used for sending the requests.
     * @return the mockMvc result
     * @throws Exception in case something goes wrong.
     */
    public static User createUser(User userRequested, MockMvc mockMvc) throws Exception {

        MvcResult result = mockMvc.perform(post("/user").content(asJsonString(userRequested))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status()
                .is(HttpStatus.CREATED.value())).andReturn();

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(result.getResponse().getContentAsString(), User.class);
    }

    public static Timetable getTimetable(Long userId, MockMvc mockMvc) throws Exception {

        MvcResult result = mockMvc.perform(
                get("/user/"+userId+"/timetable")
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().is(HttpStatus.OK.value())).andReturn();

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(result.getResponse().getContentAsString(), Timetable.class);
    }
}
