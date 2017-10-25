package com.leshukov.disk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DiskController {

    @GetMapping("/disk/add")
    public String addDisk(){
        return "disk/add-disk";
    }

    @GetMapping({"/","/disk/free"})
    public String freeDiskList() {
        return "disk/free-disk-list";
    }

    @GetMapping("/disk/hold/me")
    public String holdByMeDiskList() {
        return "disk/hold-me-disk-list";
    }

    @GetMapping("/disk/hold/other")
    public String holdByOthersDiskList() {
        return "disk/hold-other-disk-list";
    }

}
