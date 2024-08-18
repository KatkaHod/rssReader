package cz.engeto.rssReader.controller;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@RestController
public class EndPointController {

    @GetMapping("/scifi")
    public String getScifiBook() throws IOException {
        return getFileContent("static/sci-fi.txt");
    }

    @GetMapping("/romantic")
    public String getRomanticBook() throws IOException {
        return getFileContent("static/romantic.txt");
    }

    @GetMapping("/historic")
    public String getHistoricBook() throws IOException {
        return getFileContent("static/historic.txt");
    }


    /* # The function reads the contents of a file from the path specified by the filePath argument then its returns contents as a string.
       # The file content is read into String by StreamUtils.copyToString */
    private String getFileContent(String filePath) throws IOException {
        InputStream inputStream = new ClassPathResource(filePath).getInputStream();
        String content = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        return Optional.of(content)
                .filter(c -> !c.isEmpty())
                .orElse("no content available");
    }


}
