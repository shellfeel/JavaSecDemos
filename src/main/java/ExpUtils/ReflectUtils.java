package ExpUtils;

import sun.misc.BASE64Encoder;

import java.io.*;
import java.lang.reflect.Field;

// 反射常用方法
public class ReflectUtils {

    public static void setFields(Object obj, String name, Object value) throws NoSuchFieldException, IllegalAccessException {
//        Class cls = templates.getClass();
        Class cls = obj.getClass();
        Field field =  cls.getDeclaredField(name);
        field.setAccessible(true);
        field.set(obj, value);
//        field.set(cls,value);
    }

//    返回查询字段的数值
    public static Field getFields(Object obj, String name) throws NoSuchFieldException {
        Class cls = obj.getClass();
        return cls.getDeclaredField(name);
    }

//返回指定路径二进制文件byte字节数组
    public static byte[] getClassByte(String path) throws IOException {
//        path = "target/classes/ExpUtils/ReflectUtils.class";
        File file = new File(path);
        if (file.exists()){
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream in = new BufferedInputStream(fileInputStream);
            ByteArrayOutputStream bos = new ByteArrayOutputStream((int)file.length());
            int buf_size = 3000;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while ((len = in.read(buffer,0,buf_size)) != -1){
                bos.write(buffer,0,len);
            }
            return bos.toByteArray();

        }
        return null;
    }

//    返回指定路径二进制文件base64编码
    public static String getClassByteCodeBase64(String path) throws IOException {
//        path = "target/classes/ExpUtils/ReflectUtils.class";
        File file = new File(path);
        if (file.exists()){
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(getClassByte(path));
        }
        return null;

    }

    public static void main(String[] args) throws IOException {
        getClassByteCodeBase64("target/classes/ExpUtils/ReflectUtils.class");
    }
}
