package com.jingdianjichi.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.subject.application.convert.SubjectLabelControllerConverter;
import com.jingdianjichi.subject.application.entity.SubjectLabelDTO;
import com.jingdianjichi.subject.common.result.Result;
import com.jingdianjichi.subject.domain.entity.SubjectLabelBO;
import com.jingdianjichi.subject.domain.service.SubjectLabelDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 标签分类controller
 */
@RestController
@RequestMapping("/subject/label")
@Slf4j
public class SubjectLabelController {

    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.add.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
//            判断入参或者入参属性不能为空，两种方法。StringUtils：commons-lang包中工具类
            Preconditions.checkNotNull(subjectLabelDTO.getLabelName(), "标签名不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelControllerConverter.INSTANCE.convertDtoToBo(subjectLabelDTO);
            subjectLabelDomainService.add(subjectLabelBO);
            return Result.ok(true);
        } catch (Exception e) {
            return Result.fail(false);
        }
    }

    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.update.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getLabelName(), "标签名不能为空");
            Preconditions.checkNotNull(subjectLabelDTO.getSortNum(), "排序不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelControllerConverter.INSTANCE.convertDtoToBo(subjectLabelDTO);
            subjectLabelDomainService.update(subjectLabelBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(false);
        }
    }

    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.delete.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getId(), "标签id不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelControllerConverter.INSTANCE.convertDtoToBo(subjectLabelDTO);
            subjectLabelDomainService.delete(subjectLabelBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(false);
        }
    }

    @PostMapping("/queryLabelByCategoryId")
    public Result<List<SubjectLabelDTO>> queryLabelByCategoryId(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.queryLabelByCategoryId.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(), "分类id不能为空");
            SubjectLabelBO subjectLabelBO = SubjectLabelControllerConverter.INSTANCE.convertDtoToBo(subjectLabelDTO);
            List<SubjectLabelBO> subjectLabelBOList = subjectLabelDomainService.queryLabelByPrimaryId(subjectLabelBO);
            List<SubjectLabelDTO> subjectLabelDTOList = SubjectLabelControllerConverter.INSTANCE
                    .convertBoToDtoList(subjectLabelBOList);
            return Result.ok(subjectLabelDTOList);

        } catch (Exception e) {
            log.error("SubjectLabelController.queryLabelByCategoryId.error:{}", e.getMessage(), e);
            return Result.fail("查询分类下标签失败");
        }

    }
}
