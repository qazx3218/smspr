package com.example.smspr.mapper;

import com.example.smspr.dto.CommonDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
//2024-07-11 추가(클래스 처음 추가함)
public interface TbpostMapper {
    /**/
    CommonDto.PostDetailResDto detail(String id);
    List<CommonDto.PostDetailResDto> list(Map<String, Object> param);

}