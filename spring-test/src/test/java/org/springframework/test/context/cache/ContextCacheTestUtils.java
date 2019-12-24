/*
 * Copyright 2002-2015 the original author or authors.
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

package org.springframework.test.context.cache;

import static org.junit.Assert.*;

/**
 * Collection of utility methods for testing scenarios involving the
 * {@link ContextCache}.
 *
 * @author Sam Brannen
 * @since 4.2
 */
public class ContextCacheTestUtils {

	/**
	 * Reset the state of the static context cache in {@link DefaultCacheAwareContextLoaderDelegate}.
	 */
	public static final void resetContextCache() {
		DefaultCacheAwareContextLoaderDelegate.defaultContextCache.reset();
	}

	/**
	 * Assert the statistics of the static context cache in {@link DefaultCacheAwareContextLoaderDelegate}.
	 *
	 * @param usageScenario the scenario in which the statistics are used
	 * @param expectedSize the expected number of contexts in the cache
	 * @param expectedHitCount the expected hit count
	 * @param expectedMissCount the expected miss count
	 */
	public static final void assertContextCacheStatistics(String usageScenario, int expectedSize, int expectedHitCount,
			int expectedMissCount) {
		assertContextCacheStatistics(DefaultCacheAwareContextLoaderDelegate.defaultContextCache, usageScenario,
			expectedSize, expectedHitCount, expectedMissCount);
	}

	/**
	 * Assert the statistics of the supplied context cache.
	 *
	 * @param contextCache the cache to assert against
	 * @param usageScenario the scenario in which the statistics are used
	 * @param expectedSize the expected number of contexts in the cache
	 * @param expectedHitCount the expected hit count
	 * @param expectedMissCount the expected miss count
	 */
	public static final void assertContextCacheStatistics(ContextCache contextCache, String usageScenario,
			int expectedSize, int expectedHitCount, int expectedMissCount) {

		assertEquals("Verifying number of contexts in cache (" + usageScenario + ").", expectedSize,
			contextCache.size());
		assertEquals("Verifying number of cache hits (" + usageScenario + ").", expectedHitCount,
			contextCache.getHitCount());
		assertEquals("Verifying number of cache misses (" + usageScenario + ").", expectedMissCount,
			contextCache.getMissCount());
	}

}
