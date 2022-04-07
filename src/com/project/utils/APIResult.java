package com.project.utils;


public interface APIResult<T> {
	void onResult(T data);
	void onError(Exception e);
}
