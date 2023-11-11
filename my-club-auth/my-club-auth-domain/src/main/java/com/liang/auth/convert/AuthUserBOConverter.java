package com.liang.auth.convert;

import com.liang.auth.basic.entity.AuthUser;
import com.liang.auth.entity.AuthUserBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户bo转换器
 *
 * @author yzy
 * @date 2023/11/04
 */
@Mapper
public interface AuthUserBOConverter {

    AuthUserBOConverter INSTANCE = Mappers.getMapper(AuthUserBOConverter.class);

    /**
     * bo转实体
     *
     * @param authUserBO 用户 bo
     * @return 结果
     */
    AuthUser convertBOToEntity(AuthUserBO authUserBO);

}
