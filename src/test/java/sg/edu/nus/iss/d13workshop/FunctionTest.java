package sg.edu.nus.iss.d13workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
public class FunctionTest {

    private Logger logger = Logger.getLogger(FunctionTest.class.getName());
    private Path workingDir;

    @Autowired
    private ObjectMapper objectMapper;

    // unit testing

    @Test
    public void readContact() throws IOException {
        this.workingDir = Path.of("", "./data");
        Path file = this.workingDir.resolve("c9b20a83");
        String content = Files.readString(file);
        assertThat(content, is(notNullValue()));
    }

    @Test
    public void saveContact() throws Exception {

        MultiValueMap <String, String > payload = new LinkedMultiValueMap<String, String>();
        payload.add("name", "Darren");
        payload.add("email", "darren@gmail.com");
        payload.add("phone", "1234567890");

        logger.log(Level.INFO, "" + objectMapper.writeValueAsString(payload));
    }
    
}
