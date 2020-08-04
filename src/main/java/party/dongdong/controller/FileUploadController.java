package party.dongdong.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import party.dongdong.domain.Image;
import party.dongdong.modules.S3Uploader;
import party.dongdong.repository.ImageRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@PropertySource("classpath:application-file.yml")
@RestController
public class FileUploadController {

    @Value("${file.upload}")
    private String uploadDir;

    private final ImageRepository imageRepository;
    private final S3Uploader s3Uploader;

    @PostMapping("/uploadImages")
    public List<Long> save(HttpServletRequest request,
                           @RequestPart List<MultipartFile> files){
        List<Long> images = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                String uuid = UUID.randomUUID().toString();
                String fileName = uuid + StringUtils.cleanPath(file.getOriginalFilename());
                s3Uploader.upload(file, "userImage", uploadDir, fileName);


                images.add(imageRepository.save(Image.createImage(fileName)).getId());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return images;
    }

}
