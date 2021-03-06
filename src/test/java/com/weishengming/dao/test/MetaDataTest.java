package com.weishengming.dao.test;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.ext.matedata.DatabaseMetaDataFactory;
import org.mybatis.ext.matedata.MapperContextFactoty;
import org.mybatis.ext.matedata.MapperFactory;
import org.mybatis.ext.matedata.MetaDataProvider;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-weishengming-test.xml")
public class MetaDataTest extends AbstractJUnit4SpringContextTests {

    @Resource
    private DataSource dataSource;

    @Test
    public void testKeHu() {
        MetaDataProvider databaseMetaDataFactory = new DatabaseMetaDataFactory();
        databaseMetaDataFactory.setDataSource(dataSource);
        MapperContextFactoty mapperContextFactoty = new MapperContextFactoty();
        mapperContextFactoty.setMetaDataProvider(databaseMetaDataFactory);
        MapperFactory mapperFactory = new MapperFactory();
        mapperFactory.setMapperContextFactoty(mapperContextFactoty);
        mapperFactory.build("com.weishengming.dao.entity", "");
                             

    }

}
