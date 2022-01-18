package com;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * @Author: liangfan
 * @Date: 2021-12-06 09:58
 * @Description:
 */

public class Generator {
    @Test
    public void test() {
        FastAutoGenerator.create(
//                        "jdbc:mysql://localhost:3306/petshop?useUnicode=true&characterEncoding=utf-8&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai",
                        "jdbc:mysql://116.62.141.102:3306/petshop_mmtax?useUnicode=true&characterEncoding=utf-8&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai",
                        "root",
                        "Liangfan1104")
                .globalConfig(builder -> {
                    builder.author("liangfan") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .enableSwagger() // 开启 swagger 模式
                            // 指定输出目录
                            //直接右键复制项目根目录的绝对路径
                            .outputDir("E:\\IdeaProject\\demo\\src\\main\\java\\com\\example\\demo");
                })
                .packageConfig(builder -> {
                    builder.parent("") // 设置父包名
                            // 设置mapperXml生成路径
                            //直接右键复制项目mapper文件夹的绝对路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,"E:\\IdeaProject\\demo\\src\\main\\resources\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("tbl_rabbitmq_info") // 设置需要生成的表名
                            .addTablePrefix("tbl_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
