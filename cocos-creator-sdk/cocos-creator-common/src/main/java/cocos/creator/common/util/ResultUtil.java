package cocos.creator.common.util;

import cocos.creator.common.enums.ResultCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回值封装工具类
 *
 * @author 刘旭辉
 */
@AllArgsConstructor
@Getter
public class ResultUtil<T> {

    private int code;       // 状态码
    private String msg;     // 返回的信息
    private T data;         // 返回的数据

    /**
     * 成功时候的调用（有数据）
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultUtil<T> success(T data) {
        return new ResultUtil<T>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 成功时候的调用（无数据）
     *
     * @param <T>
     * @return
     */
    public static <T> ResultUtil<T> success() {
        return new ResultUtil<T>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 异常时候的调用（有msg参数）
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ResultUtil<T> error(String msg) {
        return new ResultUtil<T>(ResultCodeEnum.ERROR.getCode(), msg, null);
    }

    /**
     * 异常时候的调用（无msg参数）
     *
     * @param <T>
     * @return
     */
    public static <T> ResultUtil<T> error() {
        return new ResultUtil<T>(ResultCodeEnum.ERROR.getCode(), ResultCodeEnum.ERROR.getMessage(), null);
    }

    /**
     * 自定义返回值时的调用（无数据）
     *
     * @param resultCodeEnum
     * @param <T>
     * @return
     */
    public static <T> ResultUtil<T> custom(ResultCodeEnum resultCodeEnum) {
        return new ResultUtil<T>(resultCodeEnum.getCode(), resultCodeEnum.getMessage(), null);
    }

    /**
     * 自定义返回值时的调用（有数据）
     *
     * @param resultCodeEnum
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultUtil<T> custom(ResultCodeEnum resultCodeEnum, T data) {
        return new ResultUtil<T>(resultCodeEnum.getCode(), resultCodeEnum.getMessage(), data);
    }

}
