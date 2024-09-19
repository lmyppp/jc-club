package com.jingdianjichi.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.subject.application.convert.SubjectAnswerControllerConverter;
import com.jingdianjichi.subject.application.convert.SubjectInfoControllerConverter;
import com.jingdianjichi.subject.application.entity.SubjectInfoDTO;
import com.jingdianjichi.subject.common.pageentity.PageResult;
import com.jingdianjichi.subject.common.result.Result;
import com.jingdianjichi.subject.domain.entity.SubjectAnswerBO;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.domain.service.SubjectInfoDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/subject")
@Slf4j
public class SubjectController {
    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.add.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectName(), "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(), "难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(), "分数不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getCategoryIds(), "分类id不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelIds(), "标签id不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoControllerConverter.INSTANCE.convertDtoToBo(subjectInfoDTO);
            List<SubjectAnswerBO> subjectAnswerBOList = SubjectAnswerControllerConverter.INSTANCE
                    .convertDtoToBoList(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOList);
            subjectInfoDomainService.add(subjectInfoBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectController.add.bo:{}", e.getMessage(), e);
            return Result.fail(false);
        }
    }

    /**
     * 分页查询
     *
     * @param subjectInfoDTO
     * @return
     */
    @PostMapping("/getSubjectPage")
    public Result<PageResult<SubjectInfoDTO>> getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.getSubjectPage.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(), "分类id不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(), "标签id不能为空");
            SubjectInfoBO subjectInfoBO = SubjectInfoControllerConverter.INSTANCE.convertDtoToBo(subjectInfoDTO);
            PageResult<SubjectInfoBO> subjectInfoBOPageResult = subjectInfoDomainService.getSubjectPage(subjectInfoBO);
            return Result.ok(subjectInfoBOPageResult);
        } catch (Exception e) {
            log.error("SubjectController.getSubjectPage.bo:{}", e.getMessage(), e);
            return Result.fail(false);
        }
    }

    /**
     * 查询题目信息
     *
     * @param subjectInfoDTO
     * @return
     */
    @PostMapping("/querySubjectInfo")
    public Result<SubjectInfoDTO> querySubjectInfo(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.querySubjectInfo.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkNotNull(subjectInfoDTO.getId(), "id不能为空");
            SubjectInfoBO subjectInfoBO = SubjectInfoControllerConverter.INSTANCE.convertDtoToBo(subjectInfoDTO);
            SubjectInfoBO boResult = subjectInfoDomainService.querySubjectInfo(subjectInfoBO);
            SubjectInfoDTO infoDTO = SubjectInfoControllerConverter.INSTANCE.convertBoToDto(boResult);
            return Result.ok(infoDTO);
        } catch (Exception e) {
            log.error("SubjectController.querySubjectInfo.bo:{}", e.getMessage(), e);
            return Result.fail("查询为空");
        }
    }

}
