package com.hotelbooking.vm.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hotelbooking.util.ErrorCodes;
import com.hotelbooking.util.StringConstants;
import com.hotelbooking.util.Utils;

public class ResponseUtils {

	private static Log logger = LogFactory.getLog(ResponseUtils.class);

	public static BaseRsVM prepareSuccessResponse(BaseDataVM dataVM) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("Executing prepareResponse(BaseDataVM) ->");
		}

		BaseRsVM rsVM = new BaseRsVM();
		rsVM.setStatus(StringConstants.SUCCESS);
		if (null != dataVM) {
			rsVM.setData(dataVM);
		}

		return rsVM;

	}

	public static BaseRsVM prepareFailureResponse(String errorCode) {
		if (logger.isDebugEnabled()) {
			logger.debug("Executing prepareFailureResponse(BaseDataVM) ->");
		}
		BaseRsVM rsVM = new BaseRsVM();
		rsVM.setStatus(StringConstants.FAILURE);
		if (Utils.isNotEmpty(errorCode)) {

			BaseErrorVM baseErrorVM = new BaseErrorVM();
			baseErrorVM.setCode(errorCode);
			baseErrorVM.setMessage(ErrorBundles.getProperty(errorCode));
			baseErrorVM.setErrors(populateErrorVMList(errorCode));
			rsVM.setError(baseErrorVM);
		}

		return rsVM;

	}

	public static BaseRsVM prepareFailureResponse(Exception e) {

		if (logger.isDebugEnabled()) {
			logger.debug("Executing prepareFailureResponse(Exception) ->");
		}

		BaseRsVM rsVM = new BaseRsVM();
		rsVM.setStatus(StringConstants.FAILURE);
		if (null != e) {

			BaseErrorVM baseErrorVM = new BaseErrorVM();
			baseErrorVM.setCode(ErrorCodes.EC_UNKNOWN_ERROR);
			baseErrorVM.setMessage(ErrorBundles.getProperty(ErrorCodes.EC_UNKNOWN_ERROR));
			baseErrorVM.setErrors(populateErrorVMList(e.toString()));
			rsVM.setError(baseErrorVM);
		}

		return rsVM;
	}

	public static BaseRsVM prepareFailureResponse(String errorCode, List<String> errorCodes) {

		if (logger.isDebugEnabled()) {
			logger.debug("Executing prepareFailureResponse(errorCode, errorCodes) ->");
		}

		BaseRsVM rsVM = new BaseRsVM();
		rsVM.setStatus(StringConstants.FAILURE);

		if (Utils.isNotEmpty(errorCode)) {

			logger.error(errorCode);

			BaseErrorVM baseErrorVM = new BaseErrorVM();
			baseErrorVM.setCode(errorCode);
			baseErrorVM.setMessage(ErrorBundles.getProperty(errorCode));
			baseErrorVM.setErrors(populateErrorVMList(errorCodes));
			rsVM.setError(baseErrorVM);
		}

		return rsVM;
	}

	private static List<ErrorVM> populateErrorVMList(List<String> errorCodes) {

		if (logger.isDebugEnabled()) {
			logger.debug("Executing populateErrorVMList(List<String> errorCodes) ->");
		}

		List<ErrorVM> errorVMs = new ArrayList<ErrorVM>();

		if (Utils.isEmpty(errorCodes)) {
			return errorVMs;
		}

		for (String errorCode : errorCodes) {
			ErrorVM errorVM = populateErrorVM(errorCode);
			if (null != errorVM) {
				errorVMs.add(errorVM);
			}
		}
		return errorVMs;
	}

	private static List<ErrorVM> populateErrorVMList(String errorCode) {

		if (logger.isDebugEnabled()) {
			logger.debug("Executing populateErrorVMs(List<String> errorCodes) ->");
		}

		List<ErrorVM> errorVMs = new ArrayList<ErrorVM>();

		if (Utils.isEmpty(errorCode)) {
			return errorVMs;
		}

		ErrorVM errorVM = populateErrorVM(errorCode);
		if (null != errorVM) {
			errorVMs.add(errorVM);
		}
		return errorVMs;
	}

	private static ErrorVM populateErrorVM(String errorCode) {

		if (logger.isDebugEnabled()) {
			logger.debug("Executing populateErrorVM(String errorCode) ->");
		}

		ErrorVM errorVM = null;

		if (Utils.isEmpty(errorCode)) {
			return errorVM;
		}

		logger.error(errorCode);

		errorVM = new ErrorVM();
		errorVM.setCode(errorCode);
		errorVM.setMessage(ErrorBundles.getProperty(errorCode));
		return errorVM;

	}
}
