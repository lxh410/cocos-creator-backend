package cocos.creator.account.config;

import cocos.creator.common.constant.FieldConstant;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * 配置通用新增与更新字段
 *
 * @author 刘旭辉
 */
@Slf4j
@Configuration
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {

    /**
     * 通用的新增字段
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //判断是否有传递该属性
        if (metaObject.hasSetter("createBy")) {
            Object createId = getFieldValByName("createBy", metaObject);
            if (createId == null) {
                //开发中 创建者 修改者ID 通过Aop 或者权限框架获取当前操作用户 ，用用户ID进行填充即可
                this.strictInsertFill(metaObject, "createBy", String.class, "admin");
            }
        }
        //判断是否有传递该属性
        if (metaObject.hasSetter("createTime")) {
            Object createTime = getFieldValByName("createTime", metaObject);
            if (createTime == null) {
                this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
            }
        }
        //判断是否有传递该属性
        if (metaObject.hasSetter("isDeleted")) {
            Object isDeleted = getFieldValByName("isDeleted", metaObject);
            if (isDeleted == null) {
                this.strictInsertFill(metaObject, "isDeleted", Integer.class, FieldConstant.UN_DELETED);
            }
        }
    }

    /**
     * 通用的更新字段
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        //判断是否有传递该属性
        if (metaObject.hasSetter("updateBy")) {
            Object modifyId = getFieldValByName("updateBy", metaObject);
            if (modifyId == null) {
                this.strictUpdateFill(metaObject, "updateBy", String.class, "admin");
            }
        }
        //判断是否有传递该属性
        if (metaObject.hasSetter("updateTime")) {
            Object modifyTime = getFieldValByName("updateTime", metaObject);
            if (modifyTime == null) {
                this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
            }
        }
    }


}
