package party.dongdong.validator;

import com.google.common.base.Enums;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import party.dongdong.exception.InvalidExtensionException;

import java.util.List;

@Component
public class ImageValidator{
    private enum Extension {
        jpg,
        png,
        jpeg
    }

    public boolean extensionValid(List<MultipartFile> files) {
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            int dotIdx = fileName.indexOf('.');
            String extension = fileName.substring(dotIdx + 1);

            if (!Enums.getIfPresent(Extension.class, extension).isPresent()) {
                throw new InvalidExtensionException("허용 되지 않은 파일 확장자 입니다.");
            }
        }
        return true;
    }
}
