package com.github.fish.spring4.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 基于条件的自动配置
 * @author fish
 *
 */
public class GBKCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String encoding = System.getProperty("file.encoding");
		if (encoding != null) {
			return "gbk".equals(encoding.toLowerCase());
		}
		return false;
	}

}
