package jx.pgz.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author admin
 * @since 2022/11/30
 */
@Data
public class Result<T> implements Serializable {

    //状态码
    private String code;

   //数据
    private T data;

   //操作信息
    private String msg;




    public static <T> Result<T> success(T data,String meg) {
        Result<T> result = new Result<>();
        result.setCode("200");
        result.setMsg(meg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode("200");
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(T data) {
        Result<T> result = new Result<>();
        result.setCode("500");
        result.setMsg("操作失败");
        result.setData(data);
        return result;
    }



}
