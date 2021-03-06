/**
 * Copyright 2017-2018 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.zhudy.duic.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 配置工具包.
 *
 * @author Kevin Zou (kevinz@weghst.com)
 */
public final class ConfigUtils {

    private static final Logger log = LoggerFactory.getLogger(ConfigUtils.class);
    private static Config config;

    private ConfigUtils() {
        throw new AssertionError("ConfigUtils 不能创建实例");
    }

    /**
     * 判断是否有配置指定参数.
     *
     * @param key 配置名称
     * @return boolean
     */
    public static boolean containsKey(String key) {
        return getOrNull(key) != null;
    }

    /**
     * 返回指定配置名称的参数值, 如果不存在则返回{@code false}.
     *
     * @param key 配置名称
     * @return boolean
     */
    public static boolean getBoolean(String key) throws ConfigNotFoundException, WrongConfigValueException {
        Object v = get(key);
        try {
            if (v instanceof String) return Boolean.parseBoolean((String) v);
            return (boolean) v;
        } catch (Exception e) {
            throw new WrongConfigValueException(key, v, e);
        }
    }

    /**
     * 返回指定配置名称的参数值, 如果不存在则返回指定的默认值.
     *
     * @param key          配置名称
     * @param defaultValue 默认值
     * @return boolean
     */
    public static boolean getBoolean(String key, boolean defaultValue) {
        Object v = getOrNull(key);
        if (v == null) return defaultValue;
        try {
            if (v instanceof String) return Boolean.parseBoolean((String) v);
            return (boolean) v;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 返回指定配置名称的参数值, 如果不存在则返回{@code 0}.
     *
     * @param key 配置名称
     * @return int
     */
    public static int getInt(String key) throws ConfigNotFoundException, WrongConfigValueException {
        Object v = get(key);
        try {
            if (v instanceof String) return Double.valueOf((String) v).intValue();
            return ((Number) v).intValue();
        } catch (Exception e) {
            throw new WrongConfigValueException(key, v, e);
        }
    }

    /**
     * 返回指定配置名称的参数值, 如果不存在则返回指定的默认值.
     *
     * @param key          配置名称
     * @param defaultValue 默认值
     * @return int
     */
    public static int getInt(String key, int defaultValue) {
        Object v = getOrNull(key);
        if (v == null) return defaultValue;
        try {
            if (v instanceof String) return Double.valueOf((String) v).intValue();
            return ((Number) v).intValue();
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 返回指定配置名称的参数值, 如果不存在则返回{@code 0}.
     *
     * @param key 配置名称
     * @return long
     */
    public static long getLong(String key) throws ConfigNotFoundException, WrongConfigValueException {
        Object v = get(key);
        try {
            if (v instanceof String) return Double.valueOf((String) v).longValue();
            return ((Number) v).longValue();
        } catch (Exception e) {
            throw new WrongConfigValueException(key, v, e);
        }
    }

    /**
     * 返回指定配置名称的参数值, 如果不存在则返回指定的默认值.
     *
     * @param key          配置名称
     * @param defaultValue 默认值
     * @return long
     */
    public static long getLong(String key, long defaultValue) {
        Object v = getOrNull(key);
        if (v == null) return defaultValue;
        try {
            if (v instanceof String) return Double.valueOf((String) v).longValue();
            return ((Number) v).longValue();
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 返回指定配置名称的参数值, 如果不存在则返回{@code 0}.
     *
     * @param key 配置名称
     * @return float
     */
    public static float getFloat(String key) throws ConfigNotFoundException, WrongConfigValueException {
        Object v = get(key);
        try {
            if (v instanceof String) return Double.valueOf((String) v).floatValue();
            return ((Number) v).floatValue();
        } catch (Exception e) {
            throw new WrongConfigValueException(key, v, e);
        }
    }

    /**
     * 返回指定配置名称的参数值, 如果不存在则返回指定的默认值.
     *
     * @param key          配置名称
     * @param defaultValue 默认值
     * @return float
     */
    public static float getFloat(String key, float defaultValue) {
        Object v = getOrNull(key);
        if (v == null) return defaultValue;
        try {
            if (v instanceof String) return Double.valueOf((String) v).floatValue();
            return ((Number) v).floatValue();
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 返回指定配置名称的参数值, 如果不存在则返回{@code 0}.
     *
     * @param key 配置名称
     * @return double
     */
    public static double getDouble(String key) throws ConfigNotFoundException, WrongConfigValueException {
        Object v = get(key);
        try {
            if (v instanceof String) return Double.parseDouble((String) v);
            return ((Number) v).doubleValue();
        } catch (Exception e) {
            throw new WrongConfigValueException(key, v, e);
        }
    }

    /**
     * 返回指定配置名称的参数值, 如果不存在则返回指定的默认值.
     *
     * @param key          配置名称
     * @param defaultValue 默认值
     * @return double
     */
    public static double getDouble(String key, double defaultValue) {
        Object v = getOrNull(key);
        if (v == null) return defaultValue;

        try {
            if (v instanceof String) return Double.parseDouble((String) v);
            return ((Number) v).doubleValue();
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 返回指定配置名称的参数值, 如果不存在则返回{@code null}.
     *
     * @param key 配置名称
     * @return String
     */
    public static String getString(String key) {
        Object v = get(key);
        try {
            return v.toString();
        } catch (Exception e) {
            throw new WrongConfigValueException(key, v, e);
        }
    }

    /**
     * 返回指定配置名称的参数值, 如果不存在则返回指定的默认值.
     *
     * @param key          配置名称
     * @param defaultValue 默认值
     * @return String
     */
    public static String getString(String key, String defaultValue) {
        Object v = get(key, defaultValue);
        try {
            return v.toString();
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 返回指定配置名称的参数值, 如果不存在则抛出 {@link ConfigNotFoundException}.
     *
     * @param key 配置名称
     * @return Object
     * @throws ConfigNotFoundException 配置不存在
     */
    public static Object get(String key) throws ConfigNotFoundException {
        Object o = getOrNull(key);
        if (o == null) {
            throw new ConfigNotFoundException(key);
        }
        return o;
    }

    /**
     * 返回指定配置名称的参数值, 如果不存在则返回指定的默认值.
     *
     * @param key          配置名称
     * @param defaultValue 默认值
     * @return Object
     */
    public static Object get(String key, Object defaultValue) {
        Object v = getOrNull(key);
        if (v == null) {
            return defaultValue;
        }
        return v;
    }

    /**
     * 返回指定配置名称的参数值, 如果不存在则返回{@code null}.
     *
     * @param key 配置名称
     * @return Object
     */
    public static Object getOrNull(String key) {
        if (config == null) {
            log.warn("未设置 Config 实例请先执行 ConfigUtils.setDefaultConfig(Config) 设置配置实例");
            return null;
        }
        return config.get(key);
    }

    /**
     * 设置默认的配置获取实例.
     *
     * @param config 配置实例
     */
    public static void setDefaultConfig(Config config) {
        ConfigUtils.config = config;
    }
}
