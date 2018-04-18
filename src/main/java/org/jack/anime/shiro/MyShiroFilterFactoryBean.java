package org.jack.anime.shiro;

import javax.annotation.Resource;

import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.jack.anime.entity.PageResult;
import org.jack.anime.service.impl.AnimeShiroFilterServiceImpl;
import org.jack.anime.service.vo.animeShiroFilter.AnimeShiroFilterVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyShiroFilterFactoryBean extends ShiroFilterFactoryBean {
	
	private static final Logger logger = LoggerFactory.getLogger(MyShiroFilterFactoryBean.class);

    /**
     * 配置中的过滤链
     */
    public static String definitions;

    //权限service
    @Resource(name="animeShiroFilterServiceImpl")
    private AnimeShiroFilterServiceImpl animeShiroFilterServiceImpl;

	@Override
	public void setFilterChainDefinitions(String definitions) {
		MyShiroFilterFactoryBean.definitions = definitions;
		//数据库动态权限
        PageResult<AnimeShiroFilterVo> list = animeShiroFilterServiceImpl.getListpager(null, 0, Integer.MAX_VALUE);
        
        for(AnimeShiroFilterVo vo : list.getDataList()){
            //字符串拼接权限
            definitions = definitions+vo.getName() + " = "+vo.getPerms()+"\n";
        }
        logger.info(definitions);
        //从配置文件加载权限配置
        Ini ini = new Ini();
        ini.load(definitions);
        Ini.Section section = ini.getSection("urls");
        if (CollectionUtils.isEmpty(section)) {
            section = ini.getSection("");
        }

        this.setFilterChainDefinitionMap(section);
	}
	
}
