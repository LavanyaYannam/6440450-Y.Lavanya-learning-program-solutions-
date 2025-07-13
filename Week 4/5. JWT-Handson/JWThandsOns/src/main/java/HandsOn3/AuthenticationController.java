package HandsOn3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START - authenticate()");
        LOGGER.debug("Authorization Header: {}", authHeader);

        String user = getUser(authHeader);
        LOGGER.debug("Decoded Username: {}", user);

        Map<String, String> map = new HashMap<>();
        map.put("token", ""); // For Hands-on 3, only user decoding is required
        LOGGER.info("END - authenticate()");
        return map;
    }

    private String getUser(String authHeader) {
        // Extract the base64 encoded string after "Basic "
        String encodedCredentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedCredentials = new String(decodedBytes);

        LOGGER.debug("Decoded Credentials: {}", decodedCredentials);

        // Extract username before ":"
        String username = decodedCredentials.split(":")[0];
        return username;
    }
}
