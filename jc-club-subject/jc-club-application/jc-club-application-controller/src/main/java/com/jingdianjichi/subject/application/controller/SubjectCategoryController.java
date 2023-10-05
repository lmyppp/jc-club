package com.jingdianjichi.subject.application.controller;


import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.subject.application.convert.SubjectCategoryBOConverter;
import com.jingdianjichi.subject.application.entity.SubjectCategoryDTO;
import com.jingdianjichi.subject.common.result.Result;
import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import com.jingdianjichi.subject.domain.service.SubjectCategoryDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 刷题分类controller
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {
    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
//            判断入参或者入参属性不能为空，两种方法。StringUtils：commons-lang包中工具类
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(), "分类不能为空");
            Preconditions.checkArgument(StringUtils.isNotEmpty(subjectCategoryDTO.getCategoryName()), "类别名不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "父id不能为空");
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryBOConverter.INSTANCE.convertDtoToBo(subjectCategoryDTO);
            subjectCategoryDomainService.add(subjectCategoryBO);
            return Result.ok(true);
        } catch (Exception e) {
            return Result.fail(false);
        }
    }

    /**
     * 查询分类（大类）
     *
     * @return
     */
    @GetMapping("/queryPrimaryCategory")
    public Result<List<SubjectCategoryDTO>> queryPrimaryCategory() {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.queryPrimaryCategory.dto:{}");
            }
            SubjectCategoryBO subjectCategoryBO = new SubjectCategoryBO();
            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryCategory(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryBOConverter.INSTANCE
                    .convertBoToDto(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOList);
        } catch (Exception e) {
            return Result.fail("查询失败");
        }
    }

    /**
     * 根据parentid查询分类（大类下的分类）
     *
     * @param subjectCategoryDTO-
     * @return
     */
    @PostMapping("/queryCategoryByPrimary")
    public Result<List<SubjectCategoryDTO>> queryCategoryByPrimary(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.queryCategoryByPrimary.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "ParentId不能为空");
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryBOConverter.INSTANCE.convertDtoToBo(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService
                    .queryCategory(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryBOConverter
                    .INSTANCE.convertBoToDto(subjectCategoryBOList);
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.queryCategoryByPrimary.dto:{}", JSON.toJSONString(subjectCategoryDTOList));
            }
            return Result.ok(subjectCategoryDTOList);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryCategoryByPrimary.dto:{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        }
    }

    /**
     * 修改分类
     *
     * @param subjectCategoryDTO
     * @return
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.update.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryBOConverter.INSTANCE.convertDtoToBo(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.update(subjectCategoryBO);

            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.update.dto:{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        }
    }

    /**
     * 根据id删除分类
     *
     * @param subjectCategoryDTO
     * @return
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.delete.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            Preconditions.checkNotNull(subjectCategoryDTO.getId(), "id不能为空");
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryBOConverter.INSTANCE.convertDtoToBo(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.delete(subjectCategoryBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.delete.dto:{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        }
    }
}
