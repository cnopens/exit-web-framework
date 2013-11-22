package org.exitsoft.showcase.web.foundation.audit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.exitsoft.orm.core.Page;
import org.exitsoft.orm.core.PageRequest;
import org.exitsoft.orm.core.PropertyFilter;
import org.exitsoft.orm.core.PropertyFilters;
import org.exitsoft.orm.core.PageRequest.Sort;
import org.exitsoft.showcase.common.SystemVariableUtils;
import org.exitsoft.showcase.common.enumeration.SystemDictionaryCode;
import org.exitsoft.showcase.entity.foundation.audit.OperatingRecord;
import org.exitsoft.showcase.service.foundation.SystemAuditManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 操作记录管理Controller
 * 
 * @author vincent
 *
 */
@Controller
@RequestMapping("/foundation/audit/operating-record")
public class OperatingRecordController {
	
	@Autowired
	private SystemAuditManager systemAuditManager;
	
	/**
	 * 获取操作记录列表
	 * 
	 * @param pageRequest 分页实体信息
	 * @param request HttpServlet请求
	 * 
	 * @return {@link Page}
	 */
	@RequestMapping("view")
	public Page<OperatingRecord> view(PageRequest pageRequest,HttpServletRequest request) {
		
		List<PropertyFilter> filters = PropertyFilters.build(request,true);
		
		if (!pageRequest.isOrderBySetted()) {
			pageRequest.setOrderBy("id");
			pageRequest.setOrderDir(Sort.DESC);
		}
		
		request.setAttribute("operatingState", SystemVariableUtils.getVariables(SystemDictionaryCode.OperatingState));
		
		return systemAuditManager.searchOperatingRecordPage(pageRequest, filters);
	}
	
}
