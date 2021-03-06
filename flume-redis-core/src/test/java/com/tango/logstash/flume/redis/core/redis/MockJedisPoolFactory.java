/**
 *  Copyright 2014 TangoMe Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.tango.logstash.flume.redis.core.redis;

import static org.mockito.Mockito.when;

import com.tango.logstash.flume.redis.core.redis.JedisPoolFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class MockJedisPoolFactory implements JedisPoolFactory {

	private final Jedis jedis;

	private final JedisPool mockedJedisPool;
		
	
	public MockJedisPoolFactory(JedisPool _jedisPool, Jedis _jedis ) {
		mockedJedisPool= _jedisPool;
		jedis = _jedis;
	}
	
	public Jedis getJedis() {
		return jedis;
	}

	public JedisPool create(JedisPoolConfig jedisPoolConfig, String host, Integer port, Integer timeout,
			String password, Integer database) {

		when(mockedJedisPool.getResource()).thenReturn(jedis);
		return mockedJedisPool;
	}

}