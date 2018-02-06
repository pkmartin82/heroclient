package com.pkm.hero.service.rest.exception;

import org.apache.log4j.Logger;

public class JaxRsExceptionGenerator {

	private Logger logger;

	private JaxRsExceptionGenerator() {
		logger = Logger.getLogger(this.getClass());
	}

	public static JaxRsExceptionGenerator buildJaxRsExceptionGenerator() {
		return new JaxRsExceptionGenerator();
	}

//	public 
}
