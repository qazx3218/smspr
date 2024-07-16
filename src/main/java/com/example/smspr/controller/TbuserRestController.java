package com.example.smspr.controller;

import com.example.smspr.domain.Tbuser;
import com.example.smspr.repository.TbuserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/tbuser")
@RestController
public class TbuserRestController {

    private final TbuserRepository tbuserRepository;
    public TbuserRestController(
            TbuserRepository tbuserRepository
    ) {
        this.tbuserRepository = tbuserRepository;
    }

    //2024-07-10
    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params){
        Map<String, Object> returnData = new HashMap<String, Object>();
        int resultCode = 0;
        String resultData = "";
        String name = params.get("name") + "";
        String phone = params.get("phone") + "";
        String gender = params.get("gender") + "";
        String birth = params.get("birth") + "";
        if (name.isEmpty() || "null".equals(name)) {
            resultCode = -100;
        } else if (phone.isEmpty() || "null".equals(phone)) {
            resultCode = -200;
        } else if ("".equals(gender) || "null".equals(gender)) {
            resultCode = -300;
        } else if (birth == null) {
            resultCode = -400;
        } else {
            resultCode = 200;
            Tbuser tbuser = Tbuser.of(name, phone, gender, birth);
            tbuserRepository.save(tbuser);
            resultData = tbuser.getId();
        }

        returnData.put("resultCode", resultCode);
        returnData.put("resultData", resultData);
        return returnData;
    }
    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params) {
        Map<String, Object> returnData = new HashMap<>();
        int resultCode = 0;
        String resultData = "";
        String id = params.get("id") + "";
        Tbuser tbuser = tbuserRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        String name = params.get("name") + "";
        String phone = params.get("phone") + "";
        String gender = params.get("gender") + "";
        String birth = params.get("birth") + "";

        if (!"".equals(name) && !"null".equals(name)) {
            tbuser.setName(name);
            resultCode = 200;
        }
        if (!"".equals(phone) && !"null".equals(phone)) {
            tbuser.setPhone(phone);
            resultCode = 200;
        }
        if (!"".equals(gender) && !"null".equals(gender)) {
            tbuser.setGender(gender);
            resultCode = 200;
        }
        if (birth != null) {
            tbuser.setBirth(birth);
            resultCode = 200;
        }
        tbuserRepository.save(tbuser);

        returnData.put("resultCode", resultCode);
        return returnData;
    }

    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params) {
        Map<String, Object> returnData = new HashMap<>();
        int resultCode = 200;
        String id = params.get("id") + "";
        Tbuser tbuser = tbuserRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        tbuserRepository.delete(tbuser);

        returnData.put("resultCode", resultCode);
        return returnData;
    }

    @GetMapping("/list")
    public Map<String, Object> list() {
        Map<String, Object> returnData = new HashMap<>();
        int resultCode = 200;
        returnData.put("resultCode", resultCode);
        returnData.put("resultData", tbuserRepository.findAll());
        return returnData;
    }

    @GetMapping("/detail")
    public Map<String, Object> detail(@RequestParam String id) {
        Map<String, Object> returnData = new HashMap<>();
        int resultCode = 200;
        Tbuser tbuser = tbuserRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        returnData.put("resultCode", resultCode);
        returnData.put("resultData", tbuser);
        return returnData;
    }
}