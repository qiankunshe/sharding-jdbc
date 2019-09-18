/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.core.route.router.sharding.validator.statement;

import com.google.common.base.Optional;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.shardingsphere.core.parse.sql.statement.SQLStatement;
import org.apache.shardingsphere.core.parse.sql.statement.dml.InsertStatement;
import org.apache.shardingsphere.core.parse.sql.statement.dml.UpdateStatement;
import org.apache.shardingsphere.core.route.router.sharding.validator.statement.impl.ShardingInsertValidator;
import org.apache.shardingsphere.core.route.router.sharding.validator.statement.impl.ShardingUpdateValidator;

/**
 * Sharding validator factory.
 *
 * @author zhangliang
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ShardingValidatorFactory {
    
    /**
     * New instance of sharding validator.
     * 
     * @param sqlStatement SQL statement
     * @return instance of sharding validator
     */
    public static Optional<ShardingValidator> newInstance(final SQLStatement sqlStatement) {
        if (sqlStatement instanceof InsertStatement) {
            return Optional.<ShardingValidator>of(new ShardingInsertValidator());
        }
        if (sqlStatement instanceof UpdateStatement) {
            return Optional.<ShardingValidator>of(new ShardingUpdateValidator());
        }
        return Optional.absent();
    }
}