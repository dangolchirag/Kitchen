package com.example.utils;


public interface APIResult<T> {
	void onResult(T data);
	void onError(Exception e);
}
