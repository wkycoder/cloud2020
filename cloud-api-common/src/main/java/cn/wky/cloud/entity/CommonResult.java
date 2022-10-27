package cn.wky.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wky
 * @create 2020-05-03-9:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code; // 响应码
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> CommonResult<T> ok(String message, T data) {
        return new CommonResult<>(200, message, data);
    }

}
