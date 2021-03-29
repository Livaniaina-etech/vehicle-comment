package com.voitures.constraint.exception;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author e.livaniaina
 */
public enum ErrorsEnum {

	ERR_COMMENT_VEHICLE_NOT_FOUND("ERR_COMMENT_VEHICLE_01", "Vehicle not found.", Boolean.TRUE, Boolean.FALSE),
	ERR_COMMENT_USER_NOT_FOUND("ERR_COMMENT_USER_01", "User not found.", Boolean.TRUE, Boolean.FALSE);

	private final String errorCode;
	private final String errorMessage;
	private final Boolean error;
	private final Boolean warning;

	/**
	 * liste de correspondance entre un enum et errorCode
	 */
	private static final Map<String, ErrorsEnum> BYID = new HashMap<String, ErrorsEnum>();

	static {
		for (ErrorsEnum e : ErrorsEnum.values()) {
			if (BYID.put(e.getErrorCode(), e) != null) {
				throw new IllegalArgumentException("duplicate id: " + e.getErrorCode());
			}
		}
	}

	ErrorsEnum(String errorCode, String errorMessage, Boolean error, Boolean warning) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.error = error;
		this.warning = warning;
	}

	@Override
	public String toString() {
		return "ErrorCode : " + errorCode + " errorMessage : " + errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public static ErrorsEnum getById(String id) {
		return BYID.get(id);
	}

	public Boolean getError() {
		return error;
	}

	public Boolean getWarning() {
		return warning;
	}

}
