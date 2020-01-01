/*
 * Copyright 2011-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.lettuce.apigenerator;

import java.io.File;

/**
 * @author Mark Paluch
 */
class Constants {

    public static final String[] TEMPLATE_NAMES = { "BaseRedisCommands", "RedisGeoCommands", "RedisHashCommands",
            "RedisHLLCommands", "RedisKeyCommands", "RedisListCommands", "RedisScriptingCommands", "RedisSentinelCommands",
            "RedisServerCommands", "RedisSetCommands", "RedisSortedSetCommands", "RedisStreamCommands", "RedisStringCommands",
            "RedisTransactionalCommands" };

    public static final File TEMPLATES = new File("src/main/templates");
    public static final File SOURCES = new File("src/main/java");
}
