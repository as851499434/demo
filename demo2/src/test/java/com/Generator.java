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
                    builder.author("liangfan") // ��������
                            .fileOverride() // �����������ļ�
                            .enableSwagger() // ���� swagger ģʽ
                            // ָ�����Ŀ¼
                            //ֱ���Ҽ�������Ŀ��Ŀ¼�ľ���·��
                            .outputDir("E:\\IdeaProject\\demo\\src\\main\\java\\com\\example\\demo");
                })
                .packageConfig(builder -> {
                    builder.parent("") // ���ø�����
                            // ����mapperXml����·��
                            //ֱ���Ҽ�������Ŀmapper�ļ��еľ���·��
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,"E:\\IdeaProject\\demo\\src\\main\\resources\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("tbl_rabbitmq_info") // ������Ҫ���ɵı���
                            .addTablePrefix("tbl_", "c_"); // ���ù��˱�ǰ׺
                })
                .templateEngine(new FreemarkerTemplateEngine()) // ʹ��Freemarker����ģ�壬Ĭ�ϵ���Velocity����ģ��
                .execute();
    }
}
