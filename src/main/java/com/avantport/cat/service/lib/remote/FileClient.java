package com.avantport.cat.service.lib.remote;

import com.avantport.cat.platform.core.web.domain.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author lml
 * @Date 2022-04-11 11:12f
 */
@FeignClient(name = "file")
public interface FileClient {
    @RequestMapping(path = "/upload", method = RequestMethod.GET)
    AjaxResult upload(MultipartFile file);
}
