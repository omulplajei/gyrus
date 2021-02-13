package com.gyrus;

import com.gyrus.s3.S3Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api")
public class UploadController {

    @Autowired
    private S3Delegate s3Delegate;

    @PostMapping("/upload")
    public RedirectView upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        s3Delegate.upload(file);
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename());

        return new RedirectView("/success", true);
    }
}
