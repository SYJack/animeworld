/**
 * 
 */
package org.jack.anime.utils.tool;

import java.util.List;

import org.jack.anime.entity.PageResult;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author jack
 *
 */
public class PageUtil {
	public static <T> PageResult<T> toPagedResult(List<T> datas,PageInfo<T> pageInfo) {  
		PageResult<T> result = new PageResult<T>();  
        if (datas instanceof Page) {  
            result.setPageNo(pageInfo.getPageNum());  
            result.setPageSize(pageInfo.getPageSize());  
            result.setDataList(datas);  
            result.setTotal(pageInfo.getTotal());  
            result.setPages(pageInfo.getPages());  
        }  else {  
            result.setPageNo(1);  
            result.setPageSize(datas.size());  
            result.setDataList(datas);  
            result.setTotal(datas.size());  
        }  
        return result;  
    }  
}
