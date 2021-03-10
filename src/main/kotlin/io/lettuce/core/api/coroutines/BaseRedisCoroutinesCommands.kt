/*
 * Copyright 2020-2021 the original author or authors.
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

package io.lettuce.core.api.coroutines

import io.lettuce.core.ExperimentalLettuceCoroutinesApi
import io.lettuce.core.output.CommandOutput
import io.lettuce.core.protocol.CommandArgs
import io.lettuce.core.protocol.ProtocolKeyword
import kotlinx.coroutines.flow.Flow

/**
 * Coroutine executed commands for basic commands.
 *
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mikhael Sokolov
 * @since 6.0
 * @generated by io.lettuce.apigenerator.CreateKotlinCoroutinesApi
 */
@ExperimentalLettuceCoroutinesApi
interface BaseRedisCoroutinesCommands<K : Any, V : Any> {

    /**
     * Post a message to a channel.
     *
     * @param channel the channel type: key.
     * @param message the message type: value.
     * @return Long integer-reply the number of clients that received the message.
     */
    suspend fun publish(channel: K, message: V): Long?

    /**
     * Lists the currently *active channels*.
     *
     * @return List<K> array-reply a list of active channels, optionally matching the specified pattern.
     */
    suspend fun pubsubChannels(): List<K>

    /**
     * Lists the currently *active channels*.
     *
     * @param channel the key.
     * @return List<K> array-reply a list of active channels, optionally matching the specified pattern.
     */
    suspend fun pubsubChannels(channel: K): List<K>

    /**
     * Returns the number of subscribers (not counting clients subscribed to patterns) for the specified channels.
     *
     * @param channels channel keys.
     * @return array-reply a list of channels and number of subscribers for every channel.
     */
    suspend fun pubsubNumsub(vararg channels: K): Map<K, Long>

    /**
     * Returns the number of subscriptions to patterns.
     *
     * @return Long integer-reply the number of patterns all the clients are subscribed to.
     */
    suspend fun pubsubNumpat(): Long

    /**
     * Echo the given string.
     *
     * @param msg the message type: value.
     * @return V bulk-string-reply.
     */
    suspend fun echo(msg: V): V

    /**
     * Return the role of the instance in the context of replication.
     *
     * @return List<Any> array-reply where the first element is one of master, slave, sentinel and the additional
     *         elements are role-specific.
     */
    suspend fun role(): List<Any>

    /**
     * Ping the server.
     *
     * @return String simple-string-reply.
     */
    suspend fun ping(): String

    /**
     * Switch connection to Read-Only mode when connecting to a cluster.
     *
     * @return String simple-string-reply.
     */
    suspend fun readOnly(): String

    /**
     * Switch connection to Read-Write mode (default) when connecting to a cluster.
     *
     * @return String simple-string-reply.
     */
    suspend fun readWrite(): String

    /**
     * Instructs Redis to disconnect the connection. Note that if auto-reconnect is enabled then Lettuce will auto-reconnect if
     * the connection was disconnected. Use [io.lettuce.core.api.StatefulConnection#close] to close connections and
     * release resources.
     *
     * @return String simple-string-reply always OK.
     */
    suspend fun quit(): String?

    /**
     * Wait for replication.
     *
     * @param replicas minimum number of replicas.
     * @param timeout timeout in milliseconds.
     * @return number of replicas.
     */
    suspend fun waitForReplication(replicas: Int, timeout: Long): Long?

    /**
     * Dispatch a command to the Redis Server. Please note the command output type must fit to the command response.
     *
     * @param type the command, must not be `null`.
     * @param output the command output, must not be `null`.
     * @param <T> response type.
     * @return the command response.
     */
    fun <T : Any> dispatch(type: ProtocolKeyword, output: CommandOutput<K, V, T>): Flow<T>

    /**
     * Dispatch a command to the Redis Server. Please note the command output type must fit to the command response.
     *
     * @param type the command, must not be `null`.
     * @param output the command output, must not be `null`.
     * @param args the command arguments, must not be `null`.
     * @param <T> response type.
     * @return the command response.
     */
    fun <T : Any> dispatch(type: ProtocolKeyword, output: CommandOutput<K, V, T>, args: CommandArgs<K, V>): Flow<T>

    /**
     *
     * @return @code true} if the connection is open (connected and not closed).
     */
    fun isOpen(): Boolean

    /**
     * Disable or enable auto-flush behavior. Default is `true`. If autoFlushCommands is disabled, multiple commands can
     * be issued without writing them actually to the transport. Commands are buffered until a [flushCommands] is
     * issued. After calling [flushCommands] commands are sent to the transport and executed by Redis.
     *
     * @param autoFlush state of autoFlush.
     */
    fun setAutoFlushCommands(autoFlush: Boolean)

    /**
     * Flush pending commands. This commands forces a flush on the channel and can be used to buffer ("pipeline") commands to
     * achieve batching. No-op if channel is not connected.
     */
    fun flushCommands()

}

