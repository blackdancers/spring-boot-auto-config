package com.github.fish.spring4.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 基于条件的自动配置
 * @author fish
 *
 */
public class UTF8Condition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String encoding = System.getProperty("file.encoding");
		if (encoding != null) {
			return "utf-8".equals(encoding.toLowerCase()); // 返回true才执行
		}
		return false;
	}

}
