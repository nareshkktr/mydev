/*
 * 
 */
package com.kasisripriyawebapps.myindia.constants;

import java.io.File;

/**
 * The Class ApplicationConstants.
 */
public class ApplicationConstants {

	/** The Constant MIN_PASSWORD_LENGTH. */
	public static final Integer MIN_USER_NAME_LENGTH = (int) 6;

	/** The Constant MAX_PASSWORD_LENGTH. */
	public static final Integer MAX_USER_NAME_LENGTH = (int) 15;

	/** The Constant MIN_PASSWORD_LENGTH. */
	public static final Integer MIN_PASSWORD_LENGTH = (int) 6;

	/** The Constant MAX_PASSWORD_LENGTH. */
	public static final Integer MAX_PASSWORD_LENGTH = (int) 15;

	/** The Constant IDENTITY_CARD_TYPE_ADHAR. */
	public static final String IDENTITY_CARD_TYPE_ADHAR = "ADHAR";

	/** The Constant IDENTITY_CARD_TYPE_VOTER_ID. */
	public static final String IDENTITY_CARD_TYPE_VOTER_ID = "VOTER ID";

	/** The Constant MIN_IDENTITY_ADHAR_CARD_LENGTH. */
	public static final Integer MIN_IDENTITY_ADHAR_CARD_LENGTH = (int) 12;

	/** The Constant MIN_IDENTITY_VOTER_CARD_LENGTH. */
	public static final Integer MIN_IDENTITY_VOTER_CARD_LENGTH = (int) 10;

	/** The Constant MAX_IDENTITY_ADHAR_CARD_LENGTH. */
	public static final Integer MAX_IDENTITY_ADHAR_CARD_LENGTH = (int) 12;

	/** The Constant MAX_IDENTITY_VOTER_CARD_LENGTH. */
	public static final Integer MAX_IDENTITY_VOTER_CARD_LENGTH = (int) 17;

	/** The Constant SALT_STRING_LENGTH. */
	public static final Integer SALT_STRING_LENGTH = (int) 32;

	/** The Constant ZONE_ID_UTC. */
	public static final String ZONE_ID_UTC = "UTC";

	/** The Constant DEFAULT_TIMESTAMP_FORMAT. */
	public static final String DEFAULT_TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

	/** The Constant SYSTEM_ACCOUNT_ID. */
	public static final Long SYSTEM_ACCOUNT_ID = (long) -1;

	/** The Constant LOGIN_THROUGH_INTERNAL. */
	public static final String LOGIN_THROUGH_INTERNAL = "INTERNAL";

	/** The Constant ELECTRORAL_SEARCH. */
	public static final String ELECTRORAL_SEARCH = "electoralsearch.in/";

	/** The Constant ELECTRORAL_CAPTCHA_SERVICE_URL. */
	public static final String ELECTRORAL_CAPTCHA_SERVICE_URL = "Captcha";

	/** The Constant ELECTRORAL_SEARCH_SERVICE_URL. */
	public static final String ELECTRORAL_SEARCH_SERVICE_URL = "Search";

	/** The Constant ELECTRORAL_SEARCH_FULL_URL. */
	public static final String ELECTRORAL_SEARCH_FULL_URL = "http://electoralsearch.in/";

	/** The Constant HIBERNATE_DAILECT_LBL. */
	public static final String HIBERNATE_DAILECT_LBL = "hibernate.dialect";

	/** The Constant HIBERNATE_DEFAULT_SCHEMA_LBL. */
	public static final String HIBERNATE_DEFAULT_SCHEMA_LBL = "hibernate.default_schema";

	/** The Constant HIBERNATE_SHOW_SQL_LBL. */
	public static final String HIBERNATE_SHOW_SQL_LBL = "hibernate.show_sql";

	/** The Constant HIBERNATE_FORMAT_SQL_LBL. */
	public static final String HIBERNATE_FORMAT_SQL_LBL = "hibernate.format_sql";

	/** The Constant HIBERNATE_HBM2DDL_AUTO_LBL. */
	public static final String HIBERNATE_HBM2DDL_AUTO_LBL = "hibernate.hbm2ddl.auto";

	/** The Constant HIBERNATE_CONNECTION_USE_UNICODE_LBL. */
	public static final String HIBERNATE_CONNECTION_USE_UNICODE_LBL = "hibernate.connection.useUnicode";

	/** The Constant HIBERNATE_CONNECTION_CHARACTER_ENCODING_LBL. */
	public static final String HIBERNATE_CONNECTION_CHARACTER_ENCODING_LBL = "hibernate.connection.characterEncoding";

	/** The Constant HIBERNATE_CONNECTION_CHARSET_LBL. */
	public static final String HIBERNATE_CONNECTION_CHARSET_LBL = "hibernate.connection.charSet";

	/** The Constant HIBERNATE_JDBC_BATCH_SZIE_LBL. */
	public static final String HIBERNATE_JDBC_BATCH_SZIE_LBL = "hibernate.jdbc.batch_size";

	/** The Constant HIBERNATE_ORDER_INSERTS_LBL. */
	public static final String HIBERNATE_ORDER_INSERTS_LBL = "hibernate.order_inserts";

	/** The Constant HIBERNATE_ORDER_UPDATES_LBL. */
	public static final String HIBERNATE_ORDER_UPDATES_LBL = "hibernate.order_updates";

	/** The Constant HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE_LBL. */
	public static final String HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE_LBL = "hibernate.cache.use_second_level_cache";
	public static final String HIBERNATE_BATCH_VERSIONED_DATA_LBL = "hibernate.jdbc.batch_versioned_data";

	public static final String IMAGE_ROOT_PATH = System.getProperty("catalina.home") + File.separator + "Images";
	public static final String OBJECT_TYPE_USER = "User";
	public static final String OBJECT_TYPE_POLTIICIAN = "Politician";
	public static final String OBJECT_TYPE_PARTY = "Party";
	public static final String OBJECT_TYPE_LOCATION = "Location";
	public static final String OBJECT_TYPE_PROBLEM = "Problem";
	public static final String OBJECT_TYPE_EVENT = "Event";
	public static final String OBJECT_TYPE_COMMENT = "Comment";
	public static final String OBJECT_TYPE_POST = "Post";
	public static final String OBJECT_TYPE_PROBLEM_TYPE = "ProblemType";

	public static final Object SUCCESS_MESSAGE = "Success";

	public static final String COMMENT_TEXT = "Text";
	public static final String VOTER_ACCOUNT_TYPE = "VOTER";

	public static final String COMMENT_REPLIED = "Replied";
	public static final String COMMENTED = "Commented";

}
