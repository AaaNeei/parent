package com.yxw.web.base;

import com.yxw.base.BaseResponse;
import com.yxw.constants.Constants;
import org.springframework.ui.Model;

public class BaseWebController {
	/**
	 * 500页面
	 */
	protected static final String ERROR_500_FTL = "500.ftl";

	public Boolean isSuccess(BaseResponse<?> baseResp) {
		if (baseResp == null) {
			return false;
		}
		if (!Constants.HTTP_RES_CODE_200.equals(baseResp.getRtnCode())) {
			return false;
		}
		return true;
	}

	public void setErrorMsg(Model model, String errorMsg) {
		model.addAttribute("error", errorMsg);
	}

}