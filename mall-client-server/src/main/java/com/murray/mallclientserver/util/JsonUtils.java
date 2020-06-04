package com.murray.mallclientserver.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON工具类
 *
 * @author wulongwei
 */
public class JsonUtils {

    // 定义jackson对象
    /**
     * @Description: /TODO Jackson，我感觉是在Java与Json之间相互转换的最快速的框架，当然Google的Gson也很不错，但是参照网上有人的性能测试，看起来还是Jackson比较快一点
     * //TODO Jackson处理一般的JavaBean和Json之间的转换只要使用ObjectMapper 对象的readValue和writeValueAsString两个方法就能实现。但是如果要转换复杂类型Collection如 List<YourBean>，那么就需要先反序列化复杂类型 为泛型的Collection Type。
     * //TODO 如果是ArrayList<YourBean>那么使用ObjectMapper 的getTypeFactory().constructParametricType(collectionClass, elementClasses);
     * //TODO 如果是HashMap<String,YourBean>那么 ObjectMapper 的getTypeFactory().constructParametricType(HashMap.class,String.class, YourBean.class);
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     *
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
        try {
//            使用jackon的ObjectMapper的writeValueAsString方法可以把java对象转化成json字符串
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {

        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json数据转换成pojo对象list
     *
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
//.getTypeFactory().constructParametricType()获取类型工厂,并且构造参数类型,适用于map
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}