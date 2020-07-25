package party.dongdong.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class FileUploadController {

    @Value("${file.upload}")
    private String uploadDir;

    @PostMapping("/uploadImages")
    public List<Long> save(HttpServletRequest request,
                           @RequestPart List<MultipartFile> files){
        try {
            for (MultipartFile file : files) {
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                File image = new File(uploadDir + fileName);
                file.transferTo(image);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
