package com.zhenghao.risk.control.repository.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.zhenghao.risk.control.repository.constant.DataSourceConstant;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * zhenghao
 * 2018/4/4
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(basePackages = "com.zhenghao.risk.control.repository.mapper",
        sqlSessionFactoryRef = "riskControlSqlSessionFactory")
@Profile("default")
public class RiskControlDataSourceConfig {

    private static final String MAPPER_XML_LOCATION = "classpath:com/zhenghao/risk/control/repository/mapper/*.xml";

    @Bean(name = "riskControlDataSource")
    @Primary
    public DataSource riskControlDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(DataSourceConstant.RiskControl.DRIVER);
        dataSource.setUrl(DataSourceConstant.RiskControl.URL);
        dataSource.setUsername(DataSourceConstant.RiskControl.USER_NAME);
        dataSource.setPassword(DataSourceConstant.RiskControl.PASSWORD);

        return dataSource;
    }

    @Bean(name = "riskControlSqlSessionFactory")
    @Primary
    public SqlSessionFactory riskControlSqlSessionFactory(@Qualifier("riskControlDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_LOCATION));
        return sessionFactory.getObject();
    }

    @Bean(name = "riskControlTxManager")
    @Primary
    public DataSourceTransactionManager riskControlTransactionManager(@Qualifier("riskControlDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
