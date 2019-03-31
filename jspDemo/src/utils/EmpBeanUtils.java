package utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 属性拷贝
 */
public class EmpBeanUtils {

    /**
     * 通过BeanUtils类进行属性绑定
     * @param object
     * @param param
     */
    public static void copyProperties(Object object, Map<String,String[]> param){
        ConvertUtils.register(new Converter() {
            public Object convert(Class type, Object value) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return simpleDateFormat.parse(value.toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }, Date.class);
        try {
            org.apache.commons.beanutils.BeanUtils.populate(object,param);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
