package edu.emory.restaurant.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.emory.restaurant.domain.Menu;
import edu.emory.restaurant.domain.MenuItem;
import edu.emory.restaurant.domain.Restaurant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class JsonController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @ResponseBody
    @PostMapping("/request-body-json")
    public void requestBodyJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody={}", messageBody);
        Menu menu = objectMapper.readValue(messageBody, Menu.class);
        log.info("{}", menu.getName());
//        Map<String, String> map = objectMapper.readValue(messageBody, Map.class);
//        for (String key : map.keySet()) {
//            log.info("key={}:value={}", key, map.get(key));
//            Restaurant[] restaurants = objectMapper.readValue(map.get(key), Restaurant[].class);
//        }
    }

//    @ResponseBody
//    @PostMapping("/request-body-json")
//    public String requestBodyJson(@RequestBody String messageBody) throws JsonProcessingException {
//        Map<String, String> map = objectMapper.readValue(messageBody, Map.class);
//        String json = map.get("restaurants");
//        log.info("json={}", json);
//        return "ok";
//    }
}
